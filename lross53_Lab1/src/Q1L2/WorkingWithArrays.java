package Q1L2;

public class WorkingWithArrays {
    public static double[] mma5MethodLucas(double[] array){
        double[] newArray = new double[0]; //new array for divisible numbers

        //region Divisibility Check
            int pos = 0; //Position in array
            while(pos < array.length){
                if(array[pos] % 5 == 0){
                    double[] temp = new double[newArray.length + 1]; //Creating a temp array
                    System.arraycopy(newArray,0,temp,0,newArray.length); //Copying old array to temp array
                    temp[pos] = array[pos]; //Adding new number
                    newArray = temp; //Removing temp array

                    pos++; //Increment
                }
            }
        //endregion


        //region Storage Vars Instantiation
            double max = 0;
            double min = 0;
            double avg = 0;
        //endregion


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
                    min = Math.min(max,newArray[pos]); //Determining which value is smaller
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
    }
}
