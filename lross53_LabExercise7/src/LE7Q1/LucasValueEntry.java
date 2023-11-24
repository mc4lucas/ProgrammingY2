package LE7Q1;

public class LucasValueEntry {
    private Integer key; //Private storage var

    LucasValueEntry(){key=-1;}//Null entry

    LucasValueEntry(Integer k){ //Constructor with argument
        key = k;
    }

    public void setKey(Integer k){key = k;} //Setter method for key
    public Integer getKey(){return key;} //Getter method for key
}
