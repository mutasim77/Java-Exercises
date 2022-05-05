/*

(The Octagon class) Write a class named Octagon that extends GeometricObject and implements
the Comparable and Cloneable inter- faces. Assume that all eight sides of the octagon are of equal length.
The area can be computed using the following formula:
 area = (2 + 4/22)* side * side
Draw the UML diagram that involves Octagon, GeometricObject, Comparable, and Cloneable.
Write a test program that creates an Octagon object with side value 5 and displays its area and perimeter.
Create a new object using the clone method and compare the two objects using the compareTo method.

*/

public class forTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Octagon octagon1 = new Octagon(5);
        System.out.printf("Area is %.2f and Perimeter is %.1f", octagon1.getArea(), octagon1.getPerimeter());
        System.out.println();

        //Cloning
        Octagon octagon2 = (Octagon)octagon1.clone();
        System.out.printf("Area is %.2f and Perimeter is %.1f", octagon2.getArea(), octagon2.getPerimeter());
        System.out.println();

        if(octagon1.compareTo(octagon2) == 1){
            System.out.println("Octagon 1 is greater than 2");
        }else if(octagon1.compareTo(octagon2) == -1){
            System.out.println("Octagon 2 is greater than 1");
        }else{
            System.out.println("Octagons are equal");
        }
    }
}
