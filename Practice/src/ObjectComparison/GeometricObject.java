package ObjectComparison;

public abstract class GeometricObject {
    public abstract double getArea();

    //Overridden toString Method
    @Override
    public String toString(){
        return String.format("This Geometric Objects area is: %.2f",this.getArea());
    }
}
