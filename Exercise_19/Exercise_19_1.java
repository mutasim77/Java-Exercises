/*

(Revising Listing 19.1) Revise the GenericStack class in Listing 19.1 to imple- ment it using an array rather than an ArrayList.
You should check the array size before adding a new element to the stack. If the array is full, create a new array that doubles the
current array size and copy the elements from the current array to the new array.

*/


public class Task_19_1 <E>{
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>();
        System.out.println("Size of array: " + stack1.getSize());
        System.out.println("Is array empty: " + stack1.isEmpty());
        System.out.println("Size of List before being full: " + stack1.toString());
        stack1.push("London");
        stack1.push("Berlin");
        stack1.push("Paris");
        stack1.push("Moscow");
        stack1.push("Tokyo");
        stack1.push("London");
        stack1.push("Berlin");
        stack1.push("Paris");
        stack1.push("Moscow");
        stack1.push("Tokyo");
        stack1.push("London");
        stack1.push("Berlin");
        stack1.push("Paris");
        stack1.push("Moscow");
        stack1.push("Tokyo");
        System.out.println("Size of array after adding: " + stack1.getSize());
        System.out.println("The last element: " + stack1.peek());
        System.out.println("Is array empty: "+stack1.isEmpty());
        System.out.println("Size of List when it become full: " + stack1.toString());
    }
}
