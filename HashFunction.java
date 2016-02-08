Hash Functions

The purpose of a hash function is to take a range of key values and transform them into index values in such a way that the key values are

distributed randomly across all the indices of the hash table. Keys may be completely random or not so random. 


Random Keys

The distribution of key values in a particular database determinees what the hash function needs to do. Here we assumed that the data was

randomly distributed over its entire range. In this situation the hash function

index = key % arraySize; is satisfactory. It involves only one mathematical operation, and if the key are truly random, the resulting indices

will be random too, and therefore well distributed.


Non-Random Keys

However, data is often distributed non-randomly. In this situation some work should be done to these part numbers to help ensure that they form

a range of more truly random numbers.


Do not use Non-data

The key fields should be squeezed down until every bit counts.


Use All the data


To summarize: find a hash function that is simple and fast, yet excludes the non-data parts of the key and uses all the data.



Use a Prime Number for the Modulo Base





Hashing Strings

convert short strings to key numbers by multiplying digit codes by powers of a constant. This approach has the desireable attribute of

involving all the characters in the input string. The calculated key value can then be hashed into an array index in the usual way:

index = (key) % arraySize;


public static int hashFunc1(String key) {
    int hashVal = 0;
    int pow27 = 1;

    for(int j=key.length()-1; j>=0; j--) {
        int letter = key.charAt(j)-96;
        hashVal+=pow27*letter;
        pow27*=27;
    }
    return hashVal % arraySize;
}


The hashFunc1() method is not as efficient as it might be. Aside from the character conversion, there are two multiplications and an addition

inside the loop. We can eliminate a multiplication by taking advantage of a mathematical identity called Horner method.

var4*n^4 + var3*n^3 + var2*n^2 + var1*n^1 + var0*n^0 = (((var4*n + var3)*n + var2)*n + var1)*n + var0

public static int hashFunc2(String key) {
    int hashVal = key.charAt(0) - 96;

    for(int j=1; j<key.length(); j++) {
        int letter = key.charAt(j) = 96;
        hashVal = hashVal * 27 + letter;
    }
    return hashVal % arraySize;
}

The hashFunc2() method unfortunately cannot handle strings longer than about seven letters. Longer strings cause the value of hashVal to

exceed the size of type int.

Notice that the key we eventually end up with is always less than the array size because we apply the modulo operator. It is not the final

index that is too big; it is the intermediate key values.

It turns out that we can apply modulo operator at each step in calculation. This gives the same resul but avoids overflow.

public static int hashFunc3(String key) {
    int hashVal = 0;

    for(int j=0; j<key.length; j++) {
        int letter = key.charAt(j) - 96;
        hashVal = (hashVal * 27 + letter) % arraySize;
    }
    return hashVal;
}


Folding

Another reasonable hash function involves breaking the key into groups of digits and adding the groups. This ensures that all the digits

influence the hash value. The number of digits in a group should correspond to the size of the array. That is, for an array of 1000 items,

use groups of three digits each.




Hashing Efficiency

insertion and searching in hash tables can approach O(1) time. If no collision occurs, only a call to the hash function and a single array

references are necessary to insert a new item or find an existing item.

If collisions occur, access time become dependent on the resulting probe lengths. The average probe length (and therefore the average access

time) is dependent on the load factor.




Open Addressing Versus Separate Chaining

if open addressing is to be used, double hashing seems to be the preferred system by a small margin over quadratic probing. The exception is

the situation in which plenty of memory is available and the data wont expand after the table is created; in this case linear probing is 

somewhat simpler to implement and if load factor below 0.5 are used, causes little performance penalty.

if the number of items that will be inserted in a hash table is not known when the table is created, separate chaining is preferable to open

addressing. Increasing the load factor causes major performance penalties in open addressing, but performance degrades only linearly 

in separate chaining.

When in doubt, use separate chaining. Its drawback is the need for a linked list class, but the payoff is that adding more data wont cause

performance to slow to a crawl.














