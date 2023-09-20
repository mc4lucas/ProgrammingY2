package Q1L2;

import java.util.Scanner;

public class WorkingWithArrays {
    public static Scanner input = new Scanner(System.in);

    //region Header & footer
    public static String splitter = "======================================================="; //Storage var for the long splitter used in header and footer methods
    public static void myHeader(int qtn){ //qtn is local
        System.out.printf("%s\nLab Exercise 1-Q%d\nPrepared By: Lucas Ross\nStudent Number: 251276904\nWorking with arrays and conditional statements!\n%s\n",splitter,qtn,splitter); //Output
    }

    public static void myFooter(int qtn){ //qtn is local
        System.out.printf("%s\nCompletion of Lab Exercise 1-Q%d is successful!\nSigning off - Lucas\n%s",splitter,qtn,splitter); //output
    }
    //endregion

    public static double[] mma5MethodLucas(double[] array){
        double[] newArray = new double[0]; //new array for divisible numbers
        double[] finalArray = new double[4]; //The array that will be returned
        //region Divisibility Check
            int pos = 0; //Position in array
            while(pos < array.length){
                if(array[pos] % 5 == 0){
                    double[] temp = new double[newArray.length + 1]; //Creating a temp array
                    System.arraycopy(newArray,0,temp,0,newArray.length); //Copying old array to temp array
                    temp[newArray.length] = array[pos]; //Adding new number
                    newArray = temp; //Removing temp array
                }
                pos++; //Increment
            }
        //endregion


        //region Storage Vars Instantiation
            double max = 0;
            double min = 0;
            double avg = 0;
        //endregion


        if(newArray.length != 0){
            //region Max Calculation
            pos = 0; //Resetting position var

            while(pos < newArray.length){
                if(pos == 0){
                    max = newArray[pos]; //Setting default
                }else{
                    max = Math.max(max,newArray[pos]); //Determining which value is larger
                }

                pos++; //Increment
            }
            //endregion


            //region Min Calculation
            pos = 0; //Resetting position var

            while(pos < newArray.length){
                if(pos == 0){
                    min = newArray[pos]; //Setting default
                }else{
                    min = Math.min(min,newArray[pos]); //Determining which value is smaller
                }

                pos++; //Increment
            }
            //endregion


            //region Average Calculation
            pos = 0; //Resetting position var

            double total = 0; //Var to store total of array

            while(pos < newArray.length){
                total+=newArray[pos]; //Add up the elements of the array

                pos++; //Increment

                avg = (total/newArray.length);
            }
            //endregion

            //region Final Array Creation
                finalArray[0] = max; //Setting up the final array with calculated values
                finalArray[1] = min;
                finalArray[2] = avg;
            //endregion
        }else{
            //region Final Array Creation
            finalArray[0] = 0; //Creating the final array with default values
            finalArray[1] = 0;
            finalArray[2] = 0;
            //endregion
        }
        finalArray[3] = 251276904; //Setting studentNumber

        return finalArray;
    }

    public static void main(String[] args){
        myHeader(2); //Calling header

        System.out.print("Enter array size: ");
        double[] array = new double[input.nextInt()]; //Creating an array of size entered by user

        //region Populate array
            int pos = 0; //Incrementer
            while(pos < array.length){
                System.out.printf("Enter value %d: ",pos+1);
                array[pos] = input.nextDouble(); //Adding user input to array

                pos++; //Increment
            }
        //endregion

        double[] info = mma5MethodLucas(array); //Getting info on sent array

        if(info[0] == 0 && info[1] == 0 && info[2] == 0){
            System.out.println("\nHere is the result...... \n\nIn the array, there was no number ‘divisible by 5’ and hence the average remains 0.00."); //Done if there were no divisible numbers by 5
        }else{
            System.out.printf("\nHere is the result......\n\nThe max is %.2f.\nThe min is %.2f.\nThe average of the ‘divisible by 5 numbers’ is %.2f.\nMy student number is %d\n",info[0],info[1],info[2],(int)info[3]); //Printing the results of info
        }

        myFooter(2); //Calling the footer
    }
}
