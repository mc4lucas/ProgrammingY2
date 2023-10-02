package LA3Q1;

public class LucasArray {
    private Pair[] testArray;

    LucasArray(){ //Default Constructor
        testArray = new Pair[0];
    }

    public int getSize(){ //Getter method for the size of the test array
        return testArray.length;
    }

    public Pair removeFromLastIndex(){
        Pair temp = testArray[testArray.length-1];

        Pair[] tempArray = new Pair[testArray.length-1]; //Temp array to store changes
        System.arraycopy(testArray,0,tempArray,0,tempArray.length); //Copying the array
        testArray = tempArray;
        tempArray = null; //Clean up

        return temp;//Returns the last item in the array
    }

    public Pair removeFromFirstIndex(){
        Pair temp = testArray[0];

        Pair[] tempArray = new Pair[testArray.length-1]; //Temp array to store changes
        System.arraycopy(testArray,1,tempArray,0,tempArray.length); //Copying the array
        testArray = tempArray;
        tempArray = null; //Cleanup

        return temp;//Returns the last item in the array
    }

    public String toString(){ //Overriding the Pair toString method
        int index = 0; //Position in loop
        String result = "";
        while(index < testArray.length){ //This concatenates all the pairs from the array into a string
            result += testArray[index].toString();
        }

        return "The current stack: [" + result + "]"; //Returning the concatenated string
    }

    public void addAtLastIndex(Pair p){
        Pair[] tempArray = new Pair[testArray.length+1]; //Temp array to store changes
        System.arraycopy(testArray,1,tempArray,0,tempArray.length); //Copying the array
        tempArray[tempArray.length-1] = p; //Adding the sent pair to the last element of the array
        testArray = tempArray;
        tempArray = null; //Cleanup
    }
}
