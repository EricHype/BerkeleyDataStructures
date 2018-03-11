package com.ericheitmuller.assignment3;

public class QuestionAnswers {


    /*

    Q: Explain the difference between HashMap and LinkedHashMap with an example implementation.

    A: See EHHashMap and EHLinkedHashMap for implementations. The difference is that a LinkedHashMap preserves the
    order of keys as they are inserted. Keys in the HashMap are not guaranteed to be in any order.


    Q: Define the following terms based on your study of Hashing.

    A:
    Linear probing: A system of handling hash collision where the initial position is at the location of the hash, then
    go ahead linearly until an open position is found and insert there. Getting must use the same procedure of
    starting at hash position and linearly comparing each key to input.

    Quadratic probing: A system of handling has collision by adding a quadratic polynomial to the original hashcode.
    Quadratic probing can be a more efficient algorithm in a closed hashing table, since it better avoids the clustering
    problem that can occur with linear probing. It also provides good memory caching because
    it preserves some locality of reference.

    Load factor: Load factor is the ratio of the number of elements to the number of buckets. As the load factor grows larger,
    the hash table becomes slower, and it may even fail to work. The expected constant time property of a hash table
    assumes that the load factor is kept below some bound. For a fixed number of buckets,
    the time for a lookup grows with the number of entries and therefore the desired constant time is not achieved.

    Perfect Hash function: A hashing function that does not have any hash collisions.

    */
}
