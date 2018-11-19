package com.company;


import java.util.Comparator;
import javax.management.openmbean.InvalidKeyException;

public class BinaryHeap<K extends Comparable, V> implements VCPriorityQueue<K,V> {

  private int queue = 10;
  private int size;
  private K[]array;

  private int leftChildIndex(int parentIndex) {return 2 * parentIndex + 1;}
  private int rightChildIndex(int parentIndex) {return 2 * parentIndex + 2;}
  private int parentIndex(int childIndex) {return (childIndex - 1) / 2;}
  private K parent(int i) {return array[parentIndex(i)];}

  private boolean hasLeftChild(int index) {return leftChildIndex(index) < size;}
  private boolean hasRightChild(int index) {return rightChildIndex(index) < size;}
  private boolean hasParent(int index) {return parentIndex(index) >= 0;}

  public BinaryHeap() {
    array = (K[]) new Comparator[queue];
    size = 0;
  }

  public void add(K value) {
    array[size] = value;
    size++;
    heapifyUp();
  }

  public K remove() {
    if(size == 0) throw new IllegalStateException();
    K value = array[0];
    array[0] = array[size - 1];
    size--;
    heapifyDown();
    return value;
  }

  public void heapifyUp(){
    int index = size - 1;
    while(hasParent(index) && (parent(index).compareTo(array[index]) > 0)) {
      swap(index,parentIndex(index));
      index = parentIndex(index);
    }

  }

  public void heapifyDown(){
    int index = 1;

    while(hasLeftChild(index)) {
      int smallerChild = leftChildIndex(index);

      if(hasRightChild(index)
          && (array[leftChildIndex(index)].compareTo(array[rightChildIndex(index)]) > 0)) {
        smallerChild = rightChildIndex(index);
      }

      if(array[index].compareTo(array[smallerChild]) > 0) {
        swap(index, smallerChild);
      } else {
        break;
      }
      index = smallerChild;
    }
  }

  private void swap(int indexOne, int indexTwo) {
    K temp = array[indexOne];
    array[indexOne] = array[indexTwo];
    array[indexTwo] = temp;
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
    return null;
  }

  @Override
  public Entry<K, V> peek() {
    if(this.isEmpty()) {
      throw new InvalidKeyException();
    }
    return null; // need to fix
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
