package week07;

import java.io.*;
import java.util.*;

/** makes words based on their letter frequency.
    @author Ryan Cole
 */
public class FrequencyGenerator implements WordGenerator {

    /** a data feild. */
    private Random random;
    /** a data feild. */
    private double [] weight = new double['z' - 'a' + 1];

    /** Constructor that calls other methods.
        @param r say something
     */
    public FrequencyGenerator(Random r) {
        random = r;
        try {
            Scanner scan = new Scanner(new File("letter-frequencies.txt"));
            for(int i = 0; scan.hasNextDouble(); i++){
                weight[i] = scan.nextDouble();
            }
            scan.close();
        } catch (Exception e){
            System.out.println("File not found");
        }


    }

    /** generators the next word.
        @param n word length
        @return the word
     */
    public String nextWord(int n) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++){
            char c = (char) ('a'+index());
            result.append(c);
        }
        return result.toString();
    }

    /** gets the index of the letter.
        @return a random letter
     */
    public double index(){
        int i = 0;
        double r = random.nextDouble();
        while(r > weight[i]){
            r = r - weight[i];
            i++;
        }
        return i;
    }
    
}
