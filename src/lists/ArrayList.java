package lists;

import java.util.Arrays;

public class ArrayList<E> {
	public static final int INITIAL_CAPACITY = 10;
	private E[] data;
	private int size;
	private int capacity = INITIAL_CAPACITY;

	@SuppressWarnings("unchecked")
	public ArrayList() {
		data = (E[]) new Object[capacity];
	}

	public void add(E entry) {
		if (size == capacity) {
			reallocate();
		}
		data[size] = entry;
		size++;
	}

	public void add(int index, E entry) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if (size == capacity) {
			reallocate();
		}
		for (int i = size; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = entry;
		size++;
	}
	
	public E get(int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return data[index];
	}
	
	public E set(int index, E entry) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E old = data[index];
		data[index] = entry;
		return old;
	}
	
	public E remove(int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		E entry = data[index];
		for(int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}
		size--;
		return entry;
	}

	private void reallocate() {
		capacity = capacity * 2;
		data = Arrays.copyOf(data, capacity);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			sb.append(data[i]).append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);
		arr.add(8);
		arr.add(9);
		arr.add(10);
		arr.add(11);
		System.out.println(arr.toString());
		arr.add(2, 12);
		System.out.println(arr.toString());
		arr.remove(2);
		System.out.println(arr.toString());
	}

}
