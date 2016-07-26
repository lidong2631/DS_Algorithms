<<<<<<< HEAD
<<<<<<< HEAD
http://www.sanfoundry.com/java-program-implement-hash-tables-chaining-list-heads/

class LinkedHashEntry {
    
    String key;
    int value;
    LinkedHashEntry next;

    public LinkedHashEntry(String k, int v) {
        key = k;
        value = v;
    }
}

class HashTable {

    private int TABLE_SIZE;
    private int size;
    private LinkedHashEntry[] table;

    public HashTable(int s) {
        TABLE_SIZE = s;
        size = 0;
        table = new LinkedHashEntry[TABLE_SIZE];
        for(int i=0; i<table.length; i++)
            table[i] = null;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        for(int i=0; i<table.length; i++)
            table[i] = null;
    }

    public int hashFunc(String key) {
        int hashval = key.hashcode();
        hashval%=TABLE_SIZE;
        if(hashval<0)
            hashval+=TABLE_SIZE;
        return hashval;
    }

    public void put(String key, int value) {
        int index = hashFunc(key);

        if(LinkedHashEntry[index]==null)
            LinkedHashEntry[index] = new LinkedHashEntry(key, value);
        else {
            LinkedHashEntry curr = LinkedHashEntry[index];
            while(curr.next!=null && !curr.key.equals(key))
                curr = curr.next;
            if(curr.key.equals(key))
                curr.value = value;
            else
                curr.next = new LinkedHashEntry(key, value);
        }
        size++;
    }

    public int get(String key) {
        int index = hashFunc(key);

        if(LinkedHashEntry[index]==null)
            return -1;
        else {
            LinkedHashEntry curr = LinkedHashEntry[index];
            while(curr!=null && !curr.key.equals(key))
                curr = curr.next;
            if(curr==null)
                return -1;
            return curr.value;
        }
    }

    public void delete(String key) {
        int index = hashFunc(key);

        if(LinkedHashEntry[index]!=null) {
            LinkedHashEntry prev = null;
            LinkedHashEntry curr = LinkedHashEntry[index];

            while(curr!=null && !curr.key.equals(key)) {
                prev = curr;
                curr = curr.next;
            }
            if(curr.key.equals(key)) {
                if(prev==null)
                    curr = curr.next;
                else
                    prev.next = curr.next;
                size--;
            }
        }
    }
}









=======
>>>>>>> efdafe9e8c74597bcfaaf5f773a006a58700c65b
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
























=======
<<<<<<< HEAD
http://www.sanfoundry.com/java-program-implement-hash-tables-chaining-list-heads/

class LinkedHashEntry {
    
    String key;
    int value;
    LinkedHashEntry next;

    public LinkedHashEntry(String k, int v) {
        key = k;
        value = v;
    }
}

class HashTable {

    private int TABLE_SIZE;
    private int size;
    private LinkedHashEntry[] table;

    public HashTable(int s) {
        TABLE_SIZE = s;
        size = 0;
        table = new LinkedHashEntry[TABLE_SIZE];
        for(int i=0; i<table.length; i++)
            table[i] = null;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        for(int i=0; i<table.length; i++)
            table[i] = null;
    }

    public int hashFunc(String key) {
        int hashval = key.hashcode();
        hashval%=TABLE_SIZE;
        if(hashval<0)
            hashval+=TABLE_SIZE;
        return hashval;
    }

    public void put(String key, int value) {
        int index = hashFunc(key);

        if(LinkedHashEntry[index]==null)
            LinkedHashEntry[index] = new LinkedHashEntry(key, value);
        else {
            LinkedHashEntry curr = LinkedHashEntry[index];
            while(curr.next!=null && !curr.key.equals(key))
                curr = curr.next;
            if(curr.key.equals(key))
                curr.value = value;
            else
                curr.next = new LinkedHashEntry(key, value);
        }
        size++;
    }

    public int get(String key) {
        int index = hashFunc(key);

        if(LinkedHashEntry[index]==null)
            return -1;
        else {
            LinkedHashEntry curr = LinkedHashEntry[index];
            while(curr!=null && !curr.key.equals(key))
                curr = curr.next;
            if(curr==null)
                return -1;
            return curr.value;
        }
    }

    public void delete(String key) {
        int index = hashFunc(key);

        if(LinkedHashEntry[index]!=null) {
            LinkedHashEntry prev = null;
            LinkedHashEntry curr = LinkedHashEntry[index];

            while(curr!=null && !curr.key.equals(key)) {
                prev = curr;
                curr = curr.next;
            }
            if(curr.key.equals(key)) {
                if(prev==null)
                    curr = curr.next;
                else
                    prev.next = curr.next;
                size--;
            }
        }
    }
}









=======
>>>>>>> efdafe9e8c74597bcfaaf5f773a006a58700c65b
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
























>>>>>>> 539fb805851c31eae239f8199466d1781096f517
