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