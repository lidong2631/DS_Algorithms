<<<<<<< HEAD
int constructBITree(int arr[], int n) {
	int[] BITree = new int[n+1];
	
	for(int i=1; i<=n; i++)
		BITree[i] = 0;
	
	for(int i=0; i<n; i++)
		updateBIT(BITree, n, i, arr[i]);

	return BITree;
}

void updateBIT(int BITree[], int n, int index, int val) {
	index = index + 1;

	while(index<=n) {
		BITree[index]+=val;					// add val to current node of BITree
		index+=index & (-index);			// go to current node's parent
	}
}

int getSUm(int BITree[], int index) {
	int sum = 0;

	index = index + 1;

	while(index>0) {
		sum+=BITree[index];					// add current element of BITree to sum
		index-=index & (-index);			// go to current node's parent
	}
	return sum;
}

we can get Range Sum in logarithmic time by applying getSum(r)-getSum(l-1)

http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
=======
int constructBITree(int arr[], int n) {
	int[] BITree = new int[n+1];
	
	for(int i=1; i<=n; i++)
		BITree[i] = 0;
	
	for(int i=0; i<n; i++)
		updateBIT(BITree, n, i, arr[i]);

	return BITree;
}

void updateBIT(int BITree[], int n, int index, int val) {
	index = index + 1;

	while(index<=n) {
		BITree[index]+=val;					// add val to current node of BITree
		index+=index & (-index);			// go to current node's parent index&(-index) get last set bit
	}
}

int getSUm(int BITree[], int index) {
	int sum = 0;

	index = index + 1;

	while(index>0) {
		sum+=BITree[index];					// add current element of BITree to sum
		index-=index & (-index);			// go to current node's parent
	}
	return sum;
}

The section sums are defined in such a way that queries and modifications to the table are executed in asymptotically equivalent 
time - O(\log n) in the worst case
The initial process of building the Fenwick tree over a table of values runs in O(n \log n) time

we can get Range Sum in logarithmic time by applying getSum(r)-getSum(l-1)
http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
>>>>>>> 539fb805851c31eae239f8199466d1781096f517
