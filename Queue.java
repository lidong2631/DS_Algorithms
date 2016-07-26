<<<<<<< HEAD
Queue: a data structure that is somewhat like a stack, except that in a queue the first item inserted is the first to be removed (First-In-First-Out, FIFO), while in stack,
	as we've seen, the last item inserted is the first to be removed (LIFO)

A Circular Queue: We could move all the items in a queue whenever we deleted one, but that wouldn't be very efficient. instead, we keep all the items in the same place
				and move the front and rear of the queue.
				The trouble with this arrangement is that pretty soon the rear of the queue is at the end of the array (the highest index). Even if there are empty cells
				at the beginning of the array, because you've removed them with Rem, you still cannot insert a new item because Rear can't go any further.
				To avoid the problem, the Front and Rear arrows wrap around to the the beginning of the array. The result is a Circular queue.


class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int s) {					//Constructor
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(long j) {				//Insert
		if(rear == maxSize - 1) rear = -1;		//deal with wrap around
		queArray[++rear] = j;
		nItems++;
	}

	public long remove() {						//Remove
		long temp = queArray[front++];			
		if(front == maxSize) front = 0;			//deal with wrap around
		nItems--;
		return temp;
	}

	public long peekFront() {
		return queArray[front];
	}

	public boolean isEmpty() {
		return (nItems==0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public int size() {
		return nItems;
	}
}


Efficient:O(1)


Implementation without an Item Count: Some implementations of queues do without an item count and rely on the front and rear fields to figure out whether the queue
									is empty or full and how many items are in it. When this is done, the isEmpty(), isFull(), and size() routines become surprisingly
									complicated because the sequence of items may be either broken or contiguous, as we've seen.
									Also, a strange problem arises. The front and rear pointers assume certain positions when the queue is full, but they can assume
									these exact same positions when the queue is empty. The queue can then appear to be full and empty at the same time.
									This problem can be solved by making the array one cell larger than the maximum number of items that will be placed in it.


class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;

	public Queue(int s) {						//Constructor
		maxSize = s+1;							//array is 1 cell larger
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
	}

	public void insert(long j) {				//Insert
		if(rear == maxSize-1) rear = -1;		//deal with wrap around
		queArray[++rear] = j;
	}

	public long remove() {						/Remove
		long temp = queArray[front++];
		if(front == maxSize) front = 0;
		return temp;
	}

	public long peek() {
		return queArray[front];
	}

	public boolean isEmpty() {
		return (rear+1==front||(front+maxSize-1==rear));
	}

	public boolean isFull() {
		return (rear+2==front||(front+maxSize-2==rear));
	}

	public int size() {
		if(rear>=front)
			return rear - front +1;
		else return (maxSize-front) + (rear+1)
	}
=======
Queue: a data structure that is somewhat like a stack, except that in a queue the first item inserted is the first to be removed (First-In-First-Out, FIFO), while in stack,
	as we've seen, the last item inserted is the first to be removed (LIFO)

A Circular Queue: We could move all the items in a queue whenever we deleted one, but that wouldn't be very efficient. instead, we keep all the items in the same place
				and move the front and rear of the queue.
				The trouble with this arrangement is that pretty soon the rear of the queue is at the end of the array (the highest index). Even if there are empty cells
				at the beginning of the array, because you've removed them with Rem, you still cannot insert a new item because Rear can't go any further.
				To avoid the problem, the Front and Rear arrows wrap around to the the beginning of the array. The result is a Circular queue.


class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;

	public Queue(int s) {					//Constructor
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	public void insert(long j) {				//Insert
		if(rear == maxSize - 1) rear = -1;		//deal with wrap around
		queArray[++rear] = j;
		nItems++;
	}

	public long remove() {						//Remove
		long temp = queArray[front++];			
		if(front == maxSize) front = 0;			//deal with wrap around
		nItems--;
		return temp;
	}

	public long peekFront() {
		return queArray[front];
	}

	public boolean isEmpty() {
		return (nItems==0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public int size() {
		return nItems;
	}
}


Efficient:O(1)


Implementation without an Item Count: Some implementations of queues do without an item count and rely on the front and rear fields to figure out whether the queue
									is empty or full and how many items are in it. When this is done, the isEmpty(), isFull(), and size() routines become surprisingly
									complicated because the sequence of items may be either broken or contiguous, as we've seen.
									Also, a strange problem arises. The front and rear pointers assume certain positions when the queue is full, but they can assume
									these exact same positions when the queue is empty. The queue can then appear to be full and empty at the same time.
									This problem can be solved by making the array one cell larger than the maximum number of items that will be placed in it.


class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;

	public Queue(int s) {						//Constructor
		maxSize = s+1;							//array is 1 cell larger
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
	}

	public void insert(long j) {				//Insert
		if(rear == maxSize-1) rear = -1;		//deal with wrap around
		queArray[++rear] = j;
	}

	public long remove() {						/Remove
		long temp = queArray[front++];
		if(front == maxSize) front = 0;
		return temp;
	}

	public long peek() {
		return queArray[front];
	}

	public boolean isEmpty() {
		return (rear+1==front||(front+maxSize-1==rear));
	}

	public boolean isFull() {
		return (rear+2==front||(front+maxSize-2==rear));
	}

	public int size() {
		if(rear>=front)
			return rear - front +1;
		else return (maxSize-front) + (rear+1)
	}
>>>>>>> efdafe9e8c74597bcfaaf5f773a006a58700c65b
}