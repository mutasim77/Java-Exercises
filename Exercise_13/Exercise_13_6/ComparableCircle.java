
public class ComparableCircle extends Circle2 implements Comparable<GeometricObject>{

    public ComparableCircle(double x, double y, double radius) {
        super(x, y, radius);
    }

    @Override
    public int compareTo(GeometricObject o){
        if (getArea() > o.getArea())
            return 1;
        else if (getArea() < o.getArea())
            return -1;
        else
            return 0;
    }

}
