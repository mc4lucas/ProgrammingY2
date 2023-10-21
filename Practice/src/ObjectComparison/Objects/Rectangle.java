package ObjectComparison.Objects;

import ObjectComparison.GeometricObject;

public class Rectangle extends GeometricObject {
    private Double height;
    private Double width;

    //Default constructor no params
    public Rectangle(){
        height =10.0;
        width = 10.0;
    }

    //Constructor with two params
    public Rectangle(Double h, Double w){
        height = h;
        width = w;
    }


    //region Setter & Getter Methods
    //Getter method for height
    public Double getHeight(){
        return height;
    }

    //Getter method for width
    public Double getWidth(){
        return width;
    }

    //Setter method for height
    public void setHeight(Double h){
        height = h;
    }

    //Setter method for width
    public void setWidth(Double w){
        width = w;
    }
    //endregion


    @Override
    public double getArea() {
        return height*width;
    }

    //Overridden toString method
    @Override
    public String toString(){
        return String.format("The Rectangles area is: %.2f", this.getArea());
    }
}
