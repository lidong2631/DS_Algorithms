Heap

A heap is a binary tree with these characteristics:

It is complete. This means it is completely filled in, reading from left to right across each row, although last row need not be full.

It is (usually) implemented as an array.

Each node in a heap satisfies the heap condition, which states that every node key is larger than (or equal to) the keys of its children



heap operation:

insert/removal



Expanding the Heap Array

O(n) time, unlike the situation with hash tables, changing the size of a heap does not require reordering the data



Efficiency of Heap operations






heap sort

Efficiency of Heapsort

heapsort runs in O(nlogn) time. Although it may be slightly slower than quicksort, an advantage over quicksort is that it is less sensitive

to the initial destribution of data. Certain arrangements of key values can reduce quicksort to slow O(n^2) time, whereas heapsort runs

in O(nlogn) time no matter how the data is distributed.








P609

class Heap {

	private int[] heapArr;
	private int HEAP_SIZE;
	private int size;

	public Heap(int s) {
		HEAP_SIZE = s;
		heapArr = new int[HEAP_SIZE];
		size = 0;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public boolean isFull() {
		return size==HEAP_SIZE;
	}

	public boolean insert(int key) {
		if(size==HEAP_SIZE)
			return false;
		heapArr[size] = key;
		heapifyUp(size++);
		return true;
	}

	public void heapifyUp(int index) {
		int parent = (index-1)/2;
		int tmp = heapArr[index];

		while(index>0 && tmp>heapArr[parent]) {
			heapArr[index] = heapArr[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heapArr[index] = tmp;
	}

	public int remove() {
		int root = heapArr[0];
		heapArr[0] = heapArr[--size];
		heapifyDown(0);
		return root;
	}

	public void heapifyDown(int index) {

		int top = heapArr[index];
		int larger;

		while(index<size/2) {
			int left = 2*index+1;
			int right= 2*index+2;

			if(right<size && heapArr[left]<heapArr[right])
				larger = right;
			else
				larger = left;
			if(top>=heapArr[larger])
				break;
			heapArr[index] = heapArr[larger];
			index = larger;
		}
		heapArr[index] = top;
	}

	public boolean change(int index, int newValue) {
		if(index<0 || index>=size)
			return false;
		int tmp = heapArr[index];
		heapArr[index] = newValue;

		if(tmp<newValue)
			heapifyUp(index);
		else
			heapifyDown(index);
		return true;
	}
}