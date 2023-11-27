package LE7Q2;
import LE7Q1.*;
import static LE7Q1.LucasDemoHashingWithLinearProbing.*;

public class LucasDemoHashingWithAllOpenAddressingTechniques {
    public static void addValueQuadraticProbe(Integer i){
        boolean found = false; //Loop exit
        int pow = 1;

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

                pos = pos + (int)Math.pow(pow,2); //Increment
                pow++;

                if(pos >= hashTable.length){
                    pos=0; //Reset to front of hashtable
                }
            }
        }
    }

    public static void addValueDoubleHashing(Integer i){
        boolean found = false; //Loop exit

        int pos = (i % tableCapacity); //Find index
        if(pos < 0){
            pos = pos + tableCapacity;
        }

        int round = 0;
        int key2 = Math.abs(tableCapacity - i % tableCapacity);

        while(!found){
            //System.out.println(pos + 1);//Debug
            if(hashTable[pos].getKey() == null || hashTable[pos].getKey().equals(-111) || hashTable[pos].getKey().equals(-1)){ //Check if the spot is available
                hashTable[pos].setKey(i); //If so place it here

                found = true; //Exit loop
            }else{
                round++;
                pos = pos + (round * key2); //Increment

                if(pos == hashTable.length){
                    pos=0; //Reset to front of hashtable
                }
            }
        }
    }

    public static int thePrimeNumberForSecondHashFunction(int i){
        int q = 0;

        while(q < tableCapacity){

        }

        return q;
    }
}
