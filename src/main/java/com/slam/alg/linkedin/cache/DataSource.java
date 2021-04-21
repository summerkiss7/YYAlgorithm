package com.slam.alg.linkedin.cache;

public interface DataSource <K, T extends Rankable>{
    T get(K key);
}
