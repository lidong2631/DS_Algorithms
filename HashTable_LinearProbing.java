Open Addressing - Linear Probing

From schoolbook java

class DataItem {
    private int iData;

    public DataItem(int ii) {
        iData = ii;
    }

    public int getKey() {
        return iData;
    }
} //end class DataItem


class HashTable {
    private DataItem[] hashArray    //array holds hash table
    private int arraySize;
    private DataItem nonItem;   //for deleted items

    public HashTable(int size) {    //constructor
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);     //deleted item key is -1
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(DataItem item) {     //insert a DataItem assumes table not full
        int key = item.getKey();
        int hashVal = hashFunc(key);

        while(hashArray[hashVal]!=null && hashArray[hashVal].getKey()!=-1) {    //until empty cell
            ++hashVal;
            hashVal %= arraySize;   //go to next cell ans wrap around if necessary
        }
        hashArray[hashVal] = item;
    }   //end insert()

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);

        while(hashArray[hashVal]!=null) {
            if(hashArray[hashval].getKey()==key) {
                DataItem tmp = hashArray[hashval];  //save item
                hashArray[hashVal] = nonItem;       //del item
                return tmp;                         //return item
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);

        while(hashArray[hashVal]!=null) {
            if(hashArray[hashval].getKey()==key)
                return hashArray[hashVal];
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
}

In open addressing, when a data item cannot be placed at the index calculated by the hash function, another location in the array is sought.

loadFactor = nItems/arraySize;

Problem: once a cluster forms, it tends to grow larger. Items that hash to any value in the range of the cluster will step along around
insert themselves at the end of the cluster, thus making it even bigger.







