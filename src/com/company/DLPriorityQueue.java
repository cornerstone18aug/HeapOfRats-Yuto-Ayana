package com.company;

import java.util.*;

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
        if (this.queue != null) {
            queue.add(newEntry);
            Collections.sort(queue, new Comparator<Entry<K, V>>() {
                @Override
                public int compare(Entry<K, V> e1, Entry<K, V> e2) {
                    return e1.getKey().compareTo(e2.getKey());
                }
            });
        }else {
            queue.add(newEntry);
        }
        return newEntry;
    }

    @Override
    public Entry<K, V> peek() {
        if (isEmpty()) {
            return null;
        }
        return queue.getFirst();
    }

    @Override
    public Entry<K, V> dequeueMin() {
        if (isEmpty()) {
            return null;
        }
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
