package Hashing;

public class HashTable {
    private int tableSize;
    private float loadFactor;

    public HashTable(int sz, float lf){
        tableSize = sz;
        loadFactor = lf;
    }
}
