package dev.brunopique;

import dev.brunopique.hashtable.CustomHashTable;

public class Main {
    public static void main(String[] args) {

        CustomHashTable hashTable = new CustomHashTable();

        hashTable.put(1, "hola key 1");
        System.out.println("hashTable = " + hashTable);
        hashTable.put(1, "hola key 1");
        System.out.println("hashTable = " + hashTable);
        hashTable.put(2, "hola key 2");
        System.out.println("hashTable = " + hashTable);
        hashTable.put(6, "hola key 6");
        System.out.println("hashTable = " + hashTable);

        System.out.println("hashTable.get(2) = " + hashTable.get(2));

        System.out.println("hashTable = " + hashTable);

    }
}
