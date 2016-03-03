Priority Queue: Like an ordinary queue, a priority queue has a front and a rear, and items are removed from the front. However, in a priority queue, items are ordered by key
				value so that the item with the lowest key (or in some implementations the highest key) is always at the front. Items are inserted in the proper position
				to maintain the order.
				Like stacks and queues, priority queues are often used as programmer's tools. We'll see one used in find something called a minimum spanning tree for a graph,
				in Chapter 14, "Weighted Graphs."

class PriorityQ {
	//array in sorted order, from max at 0 to min at size-1
	private int maxSize;
	private long[] queArray;
	private int nItems;

	public PrioirtyQ(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}

	public void insert(long item) {
		int j;

		if(nItems==0)
			queArray[nItems++] = item;
		else {
			for(j=nItems-1;j>=0;j--) {				//start at end, item with lowest key is always at the end
				if(item > queArray[j])
					queArray[j+1] = queArray[j];
				else break;
			}
			queArray[j+1] = item;
			nItems++;
		}//end else
	}//end insert()

	public long remove() {							//remove minimum item
		return queArray[--nItems];
	}

	public long peekMin() {							//peek at minimum item
		return queArray[nItems-1];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}
}


The insert() method checks whether there are any items; if not, it inserts one at index 0. Otherwise, it starts at the top of the array and shifts existing items upward
until it finds the place where the new item should go. Then it inserts the item and increments nItems. Note that if there's any chance the priority queue is full, you
should check for this possibility with isFull() before using insert().
The front and rear fields aren't necessary as they were in the Queue class because, as we noted, front is always at nItems-1 and rear is always at 0.

Efficiency: Insertion runs in O(N), while deletion takes O(1). We'll see how to improve insertion time with heaps in Chapter 12.