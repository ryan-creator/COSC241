package week07;

import java.io.*;
import java.util.*;

/** makes words based on their letter frequency in a text document.
    @author Ryan Cole
*/
public class DigramGenerator implements WordGenerator {

    /** a data feild. */
    private Random random;
    /** a data feild. */
    private char[] first;
    /** a data feild. */
    private String[] pairs;
    /** a data feild. */
    private final int alphabet = 26;

    /** a method.
        @param r say something
     */
    public DigramGenerator(Random r) {
        random = r;
        try{
            Scanner scan = new Scanner(new File("first-letters.txt"));
            String text = scan.nextLine();
            scan.close();
            first = new char[text.length()];
            for(int i = 0; i < text.length(); i++){
                first[i] = text.charAt(i);
            }
        } catch (Exception e) {
            System.out.println("File not Found");
        }

        try{
            Scanner sc = new Scanner(new File("continuations.txt"));
            int i = 0;
            pairs = new String [alphabet];
            while(sc.hasNextLine()){
                pairs[i] = sc.nextLine();
                i++;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("File not Found");
        }
    }

    /** method that generators the next word.
        @param n the length of the word
        @return the word
     */
    public String nextWord(int n) {
        StringBuilder result = new StringBuilder();
        int randomIndex = random.nextInt(first.length);
        char firstChar = first[randomIndex];
        result.append(firstChar);
        char prev = firstChar;

        for(int i = 1; i < n; i++){
            int index = random.nextInt(pairs[prev-'a'].length());
            char next = pairs[prev-'a'].charAt(index);
            result.append(next);
            prev = next;
        }
        return result.toString();
    } 
}
