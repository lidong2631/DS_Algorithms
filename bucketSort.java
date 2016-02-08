Bucket sort is mainly useful when input is uniformly distributed over a range.

As the other two linear time sorting algorithms (radix sort and counting sort) bucket sort depends so much on the input. 

The main thing we should be aware of is the way the input data is dispersed over an interval.

Another crucial thing is the number of buckets that can dramatically improve or worse the performance of the algorithm.



Pseudo Code
1. Let n be the length of the input list L;
2. For each element i from L
   2.1. If B[i] is not empty
      2.1.1. Put A[i] into B[i] using insertion sort;
      2.1.2. Else B[i] := A[i] 
3. Concatenate B[i .. n] into one sorted list;





public class BucketSort {
	public static void sort(int[] a, int maxVal) {
		int[] bucket = new int[maxVal+1];
		for(int i=0; i<bucket.length; i++)
			bucket[i] = 0;

		for(int i=0; i<a.length; i++) {
			bucket[a[i]]++;
		}
		int p = 0;
		for(int i=0; i<bucket.length; i++) {
			for(int j=0; j<bucket[i]; j++) {
				a[p++] = i;
			}
		}
	}

	public static void main(String[] args) {
		int maxVal = 3;
		int[] data = {1, 0, 1, 2, 3, 1, 0, 3, 1, 0, 1, 3};

		ArrayUtil.print(data);
		sort(data, maxVal);
		ArrayUtil.print(data);
	}
}

average performance O(n+k) insertion sort累加+最后的桶排序 worst O(n^2)

http://www.geeksforgeeks.org/bucket-sort-2/
http://java.dzone.com/articles/algorithm-week-bucket-sort
http://www.javacodex.com/Sorting/Bucket-Sort
http://www.cs.hmc.edu/~keller/courses/cs60/s98/examples/Sort/bucketsort.java
http://www.sanfoundry.com/java-program-implement-bucket-sort/
http://en.algoritmy.net/article/41160/Bucket-sort
http://www.cs.unb.ca/~bremner/teaching/java/BucketSort.java/