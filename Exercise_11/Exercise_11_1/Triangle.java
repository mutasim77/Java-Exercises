public class Triangle extends GeometricObject{

    private double side1;
    private double side2;
    private double side3;

    Triangle() {
        side1 = 1.0;
        side2 = 1.0;
        side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }


    public Triangle(double side1, double side2, double side3, String color) {
        this(side1, side2, side3);
        setColor(color);
    }

    public double getSide1() {
        return side1;
    }


    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    boolean isTriangle(){
        if(side1 + side2 > side3 || side1 + side3 > side2 || side3 + side2 > side1 )
            return true;
        else
            return false;
    }

    @Override
    //S
    public double getArea() {
        double res = (side1 + side2 + side3) / 2;
        return Math.sqrt(res * (res - side1) * (res - side2) * (res - side3));
    }

    //P = A+B+C;
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}
