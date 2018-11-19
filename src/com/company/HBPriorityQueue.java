package com.company;

import java.util.PriorityQueue;

public class HBPriorityQueue<K extends Comparable, V> implements VCPriorityQueue<K, V> {
    PriorityQueue<Entry<K, V>> queue;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Entry<K, V> enqueue(K key, V value) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Entry<K, V> peek() {
        return null;
    }

    @Override
    public Entry<K, V> dequeueMin() {
        return null;
    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
        return null;
    }
}
