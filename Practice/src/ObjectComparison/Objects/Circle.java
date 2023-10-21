package ObjectComparison.Objects;

import ObjectComparison.GeometricObject;

public class Circle extends GeometricObject {
    private Double radius;

    //Default constructor
    public Circle(){radius = 5.0;}

    //Constructor with one param
    public Circle(Double rad){
        radius = rad;
    }

    //Method for returning the radius of the circle
    public Double getRadius(){
        return radius;
    }

    //Method for setting the radius of the circle
    public void setRadius(Double rad){
        radius = rad;
    }

    //Overridden abstract method for returning the area
    @Override
    public double getArea() {
        return (Math.PI/2)*Math.pow(radius,2);
    }

    //Overridden toString method
    @Override
    public String toString(){
        return String.format("The Circle's area is: %.2f", this.getArea());
    }
}
