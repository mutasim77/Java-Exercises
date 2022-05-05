import javafx.scene.shape.Circle;

/*

 (The ComparableCircle class) Define a class named ComparableCircle that extends Circle and implements Comparable.
 Draw the UML diagram and implement the compareTo method to compare the circles on the basis of area.
 Write a test class to find the larger of two instances of ComparableCircle objects.

 */

public class forTest {
    public static void main(String[] args) {

        ComparableCircle circle1 = new ComparableCircle(0,0,11);
        ComparableCircle circle2 = new ComparableCircle(0,0,5);

        System.out.println(circle1.compareTo(circle2) != -1 ?  "Circle 1 is the largest" : "Circle 2 is the largest");

    }
}
