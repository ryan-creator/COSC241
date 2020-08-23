package week01;

import java.util.Scanner;

public class Counter {  
    public static void main (String[] args){

        int lineCount = 1;
        int wordCount = 1;
        
        // System.out.println("Enter some text:");
        
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        
        for(int count = 0; count < str.length(); count++){
            if(str.charAt(count) == ' '){
                wordCount++;
            }
            if(str.contains( "\n")){
                lineCount++;
            }
        }
        System.out.println("lines: "+lineCount+"\nwords:"+ wordCount);
    }
}
