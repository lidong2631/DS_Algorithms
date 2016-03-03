class ArrayIns {
    private long[] theArray;
    private int nElems;

    public ArrayIns(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void quickSort() {
        recQuickSort(0, nElems-1);
    }

    public void recQuickSort(int left, int right) {
        if(right-left<=0)
            return;
        else {
            long pivot = theArray[right];   //rightmost item

            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition-1);
            recQuickSort(partition+1, right);
        }
    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left-1;
        int rightPtr = right;
        while(true) {
            while(theArray[++leftPtr] < pivot)
                ;
            while(rightPtr > 0 && theArray[--rightPtr] > pivot)
                ;
            if(leftPtr >= rightPtr)     //if pointers cross, partition done
                break;
            else
                swap(leftPtr, rightPtr);    //swap elements
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    public void swap(int index1, int index2) {
        long tmp = theArray[index1];
        theArray[index1] = theArray[index2];
        theArray[index2] = tmp;
    }
}

Three steps:
1 Partition the array or subarray into left (smaller keys) and right (larger keys) groups.

2 Call ourselves to sort the left group.

3 Call ourselves again to sort the right group.


Choosing a Pivot Value
1 The pivot value should be the key value of an actual data item

2 You can pick a data item to be the pivot more or less at random. For simplicity here we pick right end item

3 After partition, if the pivot is inserted at the boundary between the left and right subarrays, it will be in its final sorted position.



Degenerate to O(n^2) performance
Ideally the pivot should be the median of the items being sorted. If it has to sort one large and one small array, it is less efficient

because the larger subarray has to be subdivided more times.

The worst situation results when a subarray with N elements is divided into one subarray with 1 element and the other with N-1 elements.

This is in fact what takes place with inversely sorted data: In all subarrays, the pivot is the smallest item, so every partition results

in N-1 elements in one subarray and only the pivot in the other. The partitioning process is lost and the performance of the algorithm

degenerates to O(n^2)

Besides being slow, when the number of partitions increases, the number of recursive function calls increases. The machine stack may

overflow and paralyze the system.

To summarize, we select the rightmost element as the pivot. If the data is truly random, this is not too bad a choice. However, when the

data is sorted or inversely sorted, choosing the pivot from one end or the other is a bad idea.



Median of Three partitioning instead of randomly pick a single element. Note if you use median of three partitioning method, it follows that

quicksort algorithm wont work for partitions of three or fewer items. We can use insertion sort for small partitions
















