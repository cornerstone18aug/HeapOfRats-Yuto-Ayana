package com;

import com.ALPriorityQueue;
import com.Entry;
import com.VCPriorityQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DLPriorityQueue<K extends Comparable, V> implements VCPriorityQueue<K, V> {
    private LinkedList<Entry<K, V>> queue;

    public DLPriorityQueue() {
        queue = new LinkedList<>();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Entry<K, V> enqueue(K key, V value) throws IllegalArgumentException {
        Entry<K, V> newEntry = new Entry<>(key, value);
        Entry<K, V> tmp;
        if (this.queue != null) {
            for (Entry<K, V> entry : queue) {
                if (entry.getKey().compareTo(newEntry.getKey()) > 0) {
                    tmp = entry;
                    entry = newEntry;
                    newEntry = tmp;
                }
            }
        }
        queue.add(newEntry);
        return newEntry;
    }

    @Override
    public Entry<K, V> peek() {
        return queue.getFirst();
    }

    @Override
    public Entry<K, V> dequeueMin() {
        int minIndex = 0;
        return queue.remove(minIndex);
    }

    public LinkedList<Entry<K, V>> getQueue() {
        return queue;
    }

    @Override
    public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
        DLPriorityQueue<K, V> otherQ = ((DLPriorityQueue) other);
        for(Entry<K, V> entry: otherQ.getQueue()) {
            this.queue.add(entry);
        }
        return this;
    }
}
