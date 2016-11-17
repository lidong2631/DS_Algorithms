
Stack: A stack allows access to only one data item: the last item inserted. If you move this item, you can access the next-to-last item inserted, and so on.
	This capability can be used to check whether parentheses, braces, and brackets are balanced in a computer program source file.
	A stack is also a handy aid of algorithms applied to certain complex data structures. In chapter 8, "Binary trees" we'll see it used to help traverse the nodes
	of a tree. In chapter 13, "Graph", we'll apply it to searching the vertices of a graph.


Class Stack {
	private int maxSize;
	private long[] stackArray;
	private int top;

	public Stack(int s) {					//Initialization
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}

	public void push(long j) {				//Push
		stackArray[++top] = j;
	}

	public long pop() {						//Pop
		return stackArray[top--];
	}

	public long peek() {					//Peek
		return stackArray[top];
	}

	public boolean isEmpty() {				//isEmpty
		return (top == -1);
	}

	public boolean isFull() {				//isFull
		return (top == maxSize-1);
	}
}



Efficiency of Stacks: O(1)