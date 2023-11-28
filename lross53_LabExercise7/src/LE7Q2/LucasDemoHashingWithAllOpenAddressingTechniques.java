package LE7Q2;
import LE7Q1.*;
import static LE7Q1.LucasDemoHashingWithLinearProbing.*;

public class LucasDemoHashingWithAllOpenAddressingTechniques {
    public static void addValueQuadraticProbe(Integer key){

        int initialKey = key % hashTable.length;

        while(initialKey<0){ //If it is negative
            initialKey = initialKey + hashTable.length; //make it positive
        }

        int currentKey = initialKey; //Starting case
        int counter = 1; //Looper

        while(hashTable[currentKey].getKey() != -1){ //While not null
            currentKey = (int)(initialKey + Math.pow(counter,2));

            ++counter; //Increment before next time

            if(currentKey > initialKey+Math.pow(hashTable.length-1,2)){
                break; //Exit this loop
            }
            while(currentKey >= hashTable.length){ //If bounds are exceeded
                currentKey = currentKey - hashTable.length; //Reset
            }
        }
        if(currentKey<(initialKey+Math.pow(hashTable.length-1,2))){
            hashTable[currentKey].setKey(key); //Set the key
        }
    }

    public static void addValueDoubleHashing(Integer key){
        int h1Key = key % hashTable.length; //This is the first key
        while(h1Key<0){ //If negative
            h1Key = h1Key + hashTable.length; //Make positive
        }

        int hashCode = h1Key; //Set the default hashcode
        int h2Key = 1; //Default key 2

        if(hashTable[hashCode].getKey() != -1 && hashTable[hashCode].getKey() != -111){ //If not available
            int primeNumber = thePrimeNumberForSecondHashFunction(tableCapacity); //Find the one smaller prime number
            h2Key = primeNumber - (key%primeNumber); //Create the new key 2

            for(int i=0; i<hashTable.length;i++){
                hashCode = h1Key + (i*h2Key); //Create the new hashcode
                while(hashCode>=hashTable.length){ //Handle out of bounds
                    hashCode = hashCode-hashTable.length; //Reset to start
                }
                if(hashTable[hashCode].getKey() == -1 || hashTable[hashCode].getKey() == -111){ //If not available
                    break;
                }
                if(hashCode>(h1Key+((hashTable.length-1)*h2Key))){ //If not available
                    break;
                }
            }
        }

        if(hashCode<(h1Key+((hashTable.length-1)*h2Key))){ //If location is found
            hashTable[hashCode].setKey(key); //Set the key
        }
    }

    public static int thePrimeNumberForSecondHashFunction(int n){
        n--; //Immediately decrease the number
        int m = n / 2;//we just need to check half of the n factors

        for (int i = 3; i <= m; i++) {
            if (n % i == 0) {//if n is not a prime number
                i = 2; //reset i to 2 so that it is incremented to 3 in the for header
                //System.out.printf("i = %d\n",i);
                n--;//next n value
                m = n / 2;//we just need to check half of the n factors
            }
        }
        return n;
    }

    public static void emptyHashTable(){
        for(int i = 0; i < tableCapacity;i++){ //For the size of the hashtable / every element in hashtable
            hashTable[i].setKey(-1); //Reset to null
        }
    }

    public static void printArray(Integer[] i){
        System.out.print("The given dataset is: [");
        for(int j = 0; j<i.length; j++){
            System.out.print(i[j]+", "); //Will print each value in the array
        }
        System.out.print("\b\b]\n");
    }

    public static void main(String[] args){
        myHeader(2); //Calling my header

        System.out.print("Let's demonstrate our understanding on all the open addressing techniques...\n" +
                "How many data items: ");
        items = input.nextInt(); // Get user input

        System.out.print("What is the load factor (Recommended: <= 0.5): ");
        lf = input.nextDouble(); // Get the load factor from user

        tableCapacity = checkPrime((int)(items/lf)); //Determine capacity
        System.out.println("The minimum required table capacity would be: " + tableCapacity);

        hashTable = new LucasValueEntry[tableCapacity]; //Creating a new hashtable
        for(int x = 0; x< hashTable.length; x++){
            hashTable[x] = new LucasValueEntry(); //Instantiate with null value
        }

        Integer[] array = {7,14,-21,-28,35}; //Creating the array requested
        printArray(array); //print the created array

        System.out.println("Let's enter each data item from the above to the hash table:\n\nAdding data - linear probing resolves collision");

        //region Linear Probing
        for(int i = 0; i< array.length;i++){
            addValueLinearProbe(array[i]); //Add that value
        }
        printHashTable(); //Print the hashtable
        emptyHashTable(); //Clear the hashtable
        //endregion

        System.out.println("\nAdding data - quadratic probing resolves collision");

        //region Quadratic Probing
        if(lf >0.5){
            System.out.println("Probing failed! Use a load factor of 0.5 or less. Goodbye!");
        }

        for(int i = 0; i < array.length; i++) {
            addValueQuadraticProbe(array[i]); //Add that value
        }

        printHashTable(); //Print the hashtable
        emptyHashTable(); //Clear the hashtable

        //endregion

        System.out.println("\nAdding data - double-hashing resolves collision");

        System.out.println("The q value for double hashing is: " + thePrimeNumberForSecondHashFunction(tableCapacity)); //Alert the user

        //region Double Hashing
        for(int i = 0; i< array.length;i++){
            addValueDoubleHashing(array[i]); //Add that value
        }
        printHashTable(); //Print the hashtable
        emptyHashTable(); //Clear the hashtable
        //endregion

        myFooter(2); //Calling my footer
    }
}
