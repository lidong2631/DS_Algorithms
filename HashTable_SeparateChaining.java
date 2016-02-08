Separate Chaining

From schoolbook java

Load Factor: load factor is typically different in separate chaining than in open addressing. In separate chaining it is normal to put N or

more items into an N cell array; thus, the load factor can be 1 or greater. There is no problem with this; some locations will simply contain

two or more items in their lists.


Buckets: Another approach similar to separate chaining is to use an array at each location in the hash table, instead of a linked list. Such

arrays are sometimes called buckets. This approach is not as efficient as the linked list approach, however, because of the problem of choosing

the size of the buckets. If they are too small, they may overflow and if they are too large, they waste memory. Linked lists does not have

this problem.


class Link {
    private int iData;
    public Link next;

    public Link(int it) {
        iData = it;
    }

    public int getKey() {
        return iData;
    }
}   //end class Link


class SortedList {
    private Link first;

    public void SortedList() {
        first = null;
    }

    public void insert(Link theLink) {  //insert link, in order
        int key = theLink.getKey();
        Link prev = null;
        Linke curr = first;

        while(curr!=null && key>curr.getKey()) {    //until end of list or curr>key
            prev = curr;
            curr = curr.next;
        }
        if(prev==null)          //if begining of list, first->new link
            first = theLink;
        else                    //not at beginning, prev->new link
            previous.next = theLink;
        theLink.next = curr;
    }   //end insert()

    public void delete(int key) {
        Link prev = null;
        Link curr = first;

        while(curr!=null && key!=curr.getKey()) {
            prev = curr;
            curr = curr.next;
        }
        if(previous==null)
            first = first.next;
        else
            prev.next = curr.next;
    }

    public Link find(int key) {
        Link curr = first;

        while(curr!=null && curr.getKey()<=key) {
            if(curr.getKey()==key)
                return curr;
            curr = curr.next;
        }
        return null;
    }
}


class HashTable {
    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for(int j=0; j<arraySize; j++)
            hashArray[j] = new SortedList();
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }
}
























