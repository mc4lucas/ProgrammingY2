package LA3Q1;

public class Pair <Y,N> {
    private Y key;
    private N value;

    public Pair(Y key, N value){ //Constructor with methods
        this.key = key; //Sets the private key value to the constructor value
        this.value = value; //Sets the private Value to the constructor value
    }
    public Pair(){
        //Does Nothing / Default Constructor
    }

    public void setKey(Y key){
        this.key = key; //Sets the private var to the passed value
    }

    public void setValue(N value){
        this.value = value; //Sets the private var to the passed value
    }

    public Y getKey(){
        return this.key; //Returns the private var value
    }

    public N getValue(){
        return this.value; //Returns the private var value
    }

    public String toString(){
        return "[YR: "+key+", NM: "+value+"]";
    }
}
