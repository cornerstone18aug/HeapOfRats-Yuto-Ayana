package com;

import com.Entry;
import com.VCPriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class ALPriorityQueue<K extends Comparable, V> implements VCPriorityQueue<K, V> {
        private List<Entry<K, V>> queue;

        public ALPriorityQueue() {
            queue = new ArrayList<>();
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
            queue.add(newEntry);
            return newEntry;
        }

        @Override
        public Entry<K, V> peek() {
            Entry<K, V> min = queue.get(0);
            for(Entry<K, V> entry: queue) {
                if (entry.getKey().compareTo(min.getKey()) < 0) {
                    min = entry;
                }
            }
            return min;
        }

        @Override
        public Entry<K, V> dequeueMin() {
            int minIndex = 0;
            for(int i = 1; i < queue.size(); i++) {
                if (queue.get(i).getKey().compareTo(queue.get(minIndex).getKey()) < 0) {
                    minIndex = i;
                }
            }
            return queue.remove(minIndex);
        }

        public List<Entry<K, V>> getQueue() {
            return queue;
        }

        @Override
        public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
            ALPriorityQueue<K, V> otherQ = ((ALPriorityQueue) other);
            for(Entry<K, V> entry: otherQ.getQueue()) {
                this.queue.add(entry);
            }
            return this;
        }
    }
