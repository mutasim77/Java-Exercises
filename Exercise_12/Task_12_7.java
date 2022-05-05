/*

(NumberFormatException) Write the bin2Dec(String binaryString) method to convert a binary string into a decimal number.
Implement the bin2Dec method to throw a NumberFormatException if the string is not a binary string.

*/

public class Task_12_7 {
    public static void main(String[] args) {
        System.out.println(bin2Dec("101010"));
    }

    public static int  bin2Dec(String binaryString) throws NumberFormatException{
       int decimal;
        if(!isBinary(binaryString)){
            throw new NumberFormatException();
        }else{
           decimal=Integer.parseInt(binaryString,2);
        }
        return decimal;
    }

    public static boolean isBinary(String binary){
        for (int i = 0; i < binary.length() ; i++) {
            char a = binary.charAt(i);
            if( a != '0' && a != '1'){
                return false;
            }
        }
        return true;
    }
}
