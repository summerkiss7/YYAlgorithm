package com.slam.alg.linkedin.cache;

import java.util.*;

public class RetainBestCache<K, T extends Rankable> {
    private Map<K, T> cache; 
	private TreeMap<Long, Set<K>> rank; // Since it is ordered by Rank, an integer, TreeMap is super important
	private DataSource<K, T> dataSource; 
	private int capacity; 

    /* Constructor with a data source (assumed to be slow) and a cache size */ 
	public RetainBestCache(DataSource<K, T> ds, int capacity) {
		this.dataSource = ds;
		this.capacity = capacity;
		this.cache = new HashMap<K, T>();
		this.rank = new TreeMap<Long, Set<K>>();
	}

    /* Gets some data. 
	 * If possible, retrieves it from cache to be fast. If the data is not cached, 
	 * retrieves it from the data source. If the cache is full, attempt to cache the returned data, 
	 * evicting the T with lowest rank among the ones that it has available 
	 * If there is a tie, the cache may choose any T with lowest rank to evict. 
	 * */ 
	public T get(K key) {
        if(cache.containsKey(key) {
            return cache.get(key);
        }else {
            T t = dataSource.get(key);
            long curRank = t.getRank();

            if(capacity > cache.size()) {
                cache.put(key, t);
                if(!rank.containsKey(curRank)) {
                    rank.put(curRank, new HashSet<K>());
                }

                rank.get(curRank).add(key);
            }else {
                removeRankedCache();
            }

        }
    }

    private void  removeRankedCache() {
        Map.Entry<Long,Set<K>> entry = rank.firstEntry();
        Long key = entry.getKey();
        Set<K> set = entry.getValue();
        K toBeRemoved  = entry.getValue().iterator().next();

        set.remove(toBeRemoved);
        if(set.size() == 0) {
            rank.remove(key);
        }
        cache.remove(key);

    }
}