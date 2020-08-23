package week03;

/**
   Recursive class used to create objects for storing coins.
   @author Ryan Cole
*/

public class RecursiveApp {

    
    /** digits.
        @param n say something else here
        @return count 
    */
    public static long digits(long n){
        int count = 0;
        String str = Long.toString(n);
        for(int i = 0; i < str.length(); ++i){     
            count++;
        }
        return count;
    }

    /** Sum of The digits.
        @param n say something else here
        @return count
    */
    public static long sumOfDigits(long n){
        int count = 0;
        boolean positive = true;
        String str = Long.toString(n);
        if(str.charAt(0) == '-'){
            str = str.substring(1);
            positive = false;
        }
        for(int i = 0; i < str.length(); ++i){     
            count += Character.getNumericValue((str.charAt(i)));
        }
        if(!positive){
            count -= (count * 2);
        }
        return count;
    }
    
    /**  main method.
         @param args 
    */
    public static void main(String[] args) {

        RecursiveApp a = new RecursiveApp();
    }
}
