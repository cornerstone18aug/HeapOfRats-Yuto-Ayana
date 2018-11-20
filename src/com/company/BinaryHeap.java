package com.company;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.management.openmbean.InvalidKeyException;

public class BinaryHeap<K extends Comparable, V> implements VCPriorityQueue<K,V> {

  private int queue = 100;
  private int size;
//  private K[] array;
  private List<Entry<K, V>>[] list;

  private int leftChildIndex(int parentIndex) {return 2 * parentIndex;}
  private int rightChildIndex(int parentIndex) {return 2 * parentIndex + 1;}
  private int parentIndex(int childIndex) {return (childIndex - 1) / 2;}
  private List<Entry<K, V>> parent(int i) {return list[parentIndex(i)];}

  private boolean hasLeftChild(int index) {return leftChildIndex(index) < size;}
  private boolean hasRightChild(int index) {return rightChildIndex(index) < size;}
  private boolean hasParent(int index) {return parentIndex(index) >= 0;}

  public BinaryHeap() {
    list = (List<Entry<K, V>>[]) new Comparator[queue];
    size = 0;
  }

  public void add(List<Entry<K, V>> value) {
    list[size] = value;
    size++;
    heapifyUp();
  }

//  public K remove() {
//    if(size == 0) throw new IllegalStateException();
//    List<Entry<K, V>> value = list[0];
//    list[0] = list[size - 1];
//    size--;
//    heapifyDown();
//    return (K) value;
//  }

  public void heapifyUp(){
    int index = size - 1;
    while(hasParent(index) && (parent(index).get(index).getKey().compareTo(list[index].get(index).getKey()) > 0)) {
      swap(index,parentIndex(index));
      index = parentIndex(index);
    }
  }

  public void heapifyDown(){
    int index = 1;

    while(hasLeftChild(index)) {
      int smallerChild = leftChildIndex(index);

      if(hasRightChild(index)
          && (list[leftChildIndex(index)].get(index).getKey().compareTo(list[rightChildIndex(index)].get(index).getKey()) > 0)) {
        smallerChild = rightChildIndex(index);
      }

      if(list[index].get(index).getKey().compareTo(list[smallerChild].get(index).getKey()) > 0) {
        swap(index, smallerChild);
      } else {
        break;
      }
      index = smallerChild;
    }
  }

  private void swap(int indexOne, int indexTwo) {
    List<Entry<K, V>> temp = list[indexOne];
    list[indexOne] = list[indexTwo];
    list[indexTwo] = temp;
  }


  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public Entry<K, V> enqueue(K key, V value) throws IllegalArgumentException {
    Entry<K, V> newEntry = new Entry<>(key, value);
    heapifyUp();
    heapifyDown();
    return newEntry;
  }

  @Override
  public Entry<K, V> peek() {
    if(this.isEmpty()) {
      throw new InvalidKeyException();
    }
    Entry<K, V> min = list[0].get(0);
    return min;
  }

  @Override
  public Entry<K, V> dequeueMin() {
    int index = 1;
    while(hasLeftChild(index)) {
      int smallerChild = leftChildIndex(index);

      if(hasRightChild(index)
              && (list[leftChildIndex(index)].get(index).getKey().compareTo(list[rightChildIndex(index)].get(index).getKey()) > 0)) {
        smallerChild = rightChildIndex(index);
      }

      swap(parentIndex(smallerChild), smallerChild);

      index = smallerChild;
    }

    List<Entry<K, V>> arrayList = new ArrayList<>();

    return arrayList.remove(0);
  }

  @Override
  public VCPriorityQueue<K, V> merge(VCPriorityQueue<K, V> other) {
    return null;
  }
}
