package LE7Q1;
import java.util.*;

public class LucasDemoHashingWithLinearProbing {

    //region Header & footer
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 7-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nGoal of this Exercise: Experiment with HashTables and gain practice implementing and manipulating them.\n%s\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 7-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }
    //endregion


    //region Vars
        public static int items; //Field to hold the value of total # of data items to add to hash table
        public static Scanner input = new Scanner(System.in); //User input
        public static double lf; //Load factor var
        public static int tableCapacity; //Table capacity var
        public static LucasValueEntry[] hashTable; //hashTable
        public static LucasValueEntry[] workingHashTable; //rehashing operations
    //endregion

    public static void addValueLinearProbe(Integer i){
        boolean found = false; //Loop exit

        int pos = (i % tableCapacity); //Find index
        if(pos < 0){
            pos = pos + tableCapacity;
        }

        while(!found){
            //System.out.println(pos + 1);//Debug
            if(hashTable[pos].getKey() == null || hashTable[pos].getKey().equals(-111) || hashTable[pos].getKey().equals(-1)){ //Check if the spot is available
                hashTable[pos].setKey(i); //If so place it here

                found = true; //Exit loop
            }else{
                pos++; //Increment

                if(pos == hashTable.length){
                    pos=0; //Reset to front of hashtable
                }
            }
        }
    }
    public static int checkPrime(int n){
        int m = n / 2;//we just need to check half of the n factors

        for (int i = 3; i <= m; i++) {
            if (n % i == 0) {//if n is not a prime number
                i = 2; //reset i to 2 so that it is incremented to 3 in the for header
                //System.out.printf("i = %d\n",i);
                n++;//next n value
                m = n / 2;//we just need to check half of the n factors
            }
        }
        return n;
    }

    public static void removeValueLinearProbe(Integer i){
        boolean exit = false; //Loop exit


        int pos = (i % tableCapacity); //Find index
        if(pos < 0){
            pos = pos + tableCapacity;
        }

        while(!exit){
            if(hashTable[pos].getKey().equals(i)){ //Find at index
                hashTable[pos].setKey(-111); //Replace with available

                System.out.printf("%s is Found and removed! ",i); //Alert the user

                exit = true;
            }else if(hashTable[pos].getKey() == -1){ //Found a null location
                //Found a null location
                System.out.printf("%s is not found! ",i); //Alert the user

                exit = true; //Break the loop
            }else{
                if(pos == hashTable.length){
                    pos=0; //Reset to front of hashtable
                }else{
                    pos++; //Increment index
                }
            }
        }
    }

    public static void printHashTable(){
        String message; //Storage var

        System.out.print("The current Hash-Table: ["); //Print lead

        for(int x = 0; x< hashTable.length;x++){ //If it is null
            if(hashTable[x].getKey().equals(-1)){
                message = "null, ";
            }
            else if(hashTable[x].getKey().equals(-111)){ //If it is available
                message = "available, ";
            }else{
                message = hashTable[x].getKey() + ", "; //If it has a value
            }

            System.out.print(message); //Print the message
        }

        System.out.print("\b\b]\n"); //Print lead
    }

    public static void rehashingWithLinearProbe(){
        tableCapacity = checkPrime(hashTable.length * 2); //Find the next prime number

        workingHashTable = new LucasValueEntry[hashTable.length]; //Update size
        System.arraycopy(hashTable,0,workingHashTable,0,hashTable.length); //Copy the array

        hashTable = new LucasValueEntry[tableCapacity]; //Update size

        for(int x = 0; x< hashTable.length; x++){
            hashTable[x] = new LucasValueEntry(); //Instantiate with null value
        }

        for(int x=0; x< workingHashTable.length; x++){
            if(!workingHashTable[x].getKey().equals(-1) && !workingHashTable[x].getKey().equals(-111)){ //Check that it is not null or available
                addValueLinearProbe(workingHashTable[x].getKey()); //Rehash and put in new table
            }
        }

        workingHashTable = null; //Cleanup
    }

    public static void main(String[] args){ //Driver method
        myHeader(1); //Calling the header

        System.out.print("Let's decide on the initial table capacity based on the load factor and dataset size\n" + "How many data items: "); //Request input
        items = input.nextInt(); //Take user input

        System.out.print("What is the load factor (Recommended: <= 0.5): "); //Request input
        lf = input.nextDouble(); //Take user input

        tableCapacity = checkPrime((int)(items/lf)); //Determine capacity
        System.out.println("The minimum required table capacity would be: " + tableCapacity); //print capacity
        hashTable = new LucasValueEntry[tableCapacity]; //Create a new hashtable

        for(int x = 0; x< hashTable.length; x++){
            hashTable[x] = new LucasValueEntry(); //Instantiate with null value
        }

        for(int x = 0; x<items; x++){
            System.out.printf("Enter item %s: ",x+1); //Request user input
            addValueLinearProbe(input.nextInt()); //Instantiate with user given value
        }

        printHashTable(); //Print the Hash Table

        System.out.println("\nLet’s remove two values from the table and then add one…….\n");

        for(int x=0; x<2;x++){
            System.out.print("Enter a value you want to remove: "); //Request user input
            removeValueLinearProbe(input.nextInt());  //Remove the val if found
            printHashTable(); //Print the current hash table
        }

        System.out.print("Enter a value to add to the table: "); //Request input
        addValueLinearProbe(input.nextInt()); //Add the value
        printHashTable(); //Print the current hash table

        rehashingWithLinearProbe(); //Rehash the table
        System.out.println("Rehashing the table...\nThe rehashed table capacity is: " + tableCapacity);
        printHashTable(); //Print the rehashed table

        myFooter(1); //Calling the footer
    }
}
