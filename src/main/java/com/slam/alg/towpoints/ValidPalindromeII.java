package com.slam.alg.towpoints;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * Explanation: Originally a palindrome.
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: Delete 'b' or 'c'.
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 * Explanation: Deleting any letter can not make it a palindrome.
 * Notice
 * The string will only contain lowercase characters.
 * The maximum length of the string is 50000.
 */
public class ValidPalindromeII {

    /**
     * @param s: a string
     * @return: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindrome(String s) {
        // Write your code here
        Pair diff = findDifference(0, s.length()-1, s);

        if(diff.left >= diff.right) {
            return  true;
        }

        return isPalindrome(diff.left + 1, diff.right, s) ||
                isPalindrome(diff.left, diff.right -1, s);
    }

    public Pair findDifference(int left, int right, String s) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left ++;
            right --;
        }
        return new Pair(left, right);
    }

    public boolean isPalindrome(int left, int right, String s) {
        Pair pair = findDifference(left, right, s);
        return  pair.left >= pair.right;
    }

    public class Pair {
        int left, right;
        Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}


