Open Addressing - Double Hashing

From schoolbook java

Hash the key a second time, using a different hash function, and use the result as the step size. For a given key the step size remains

constant throughout a probe, but it is different for different keys.

Formula: stepSize = constant - (key % constant);    where constant is prime and smaller than the array size
here we use stepSize = 5 - (key % 5);



class DataItem {
    private int iData;

    public DataItem(int ii) {
        iData = ii;
    }

    public int getKey() {
        return iData;
    }
}   //end class DataItem

class HashTable {
    private DataItem[] hashArray    //array holds hash table
    private int arraySize;
    private DataItem nonItem;   //for deleted items

    public HashTable(int size) {    //constructor
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);     //deleted item key is -1
    }

    public int hashFunc1(int key) {
        return key % arraySize;
    }

    public int hashFunc2(int key) {
        return 5 - key % 5;
    }

    public void insert(int key, DataItem item) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while(hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1) {
            hashVal+=stepSize;      //add the step
            hashVal%=arraySize;     //for wraparound
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while(hashArray[hashVal]!=null) {
            if(hashArray[hashVal].getKey()==key) {
                DataItem tmp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return tmp;
            }
            hashVal+=stepSize;
            hashVal%=arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);

        while(hashArray[hashVal]!=null) {
            if(hashArray[hashVal].getKey()==key)
                return hashArray[hashVal];
            hashVal+=stepSize;
            hashVal%=arraySize;
        }
        return null;
    }
}

Table size a Prime Number
Suppose array size is 15 and that a particular key hashes to an initial index of 0 and a step size of 5. The probe sequence will be 0, 5, 10, 0,

5, 10, and so on, repeating endlessly. Only these three cells are ever examined, so the algorithm will never find the empty cells that might be

waiting at 1, 2, 3, and so on.

If the array size were 13, which is prime, the probe sequence will eventually visit every cell. Using a prime number as the array size makes

it impossible for any number to divide it evenly, so the probe sequence will eventually check every cell.















