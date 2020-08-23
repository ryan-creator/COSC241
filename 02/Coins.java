package week02;

import java.util.Random;

/**
   Coins class used to create objects for storing coins.
   @author Ryan Cole
*/
public class Coins{
    
    /** Variables for heads. Avoids using true and false. */
    public static final boolean HEADS = true;
    /** Variables for tails. Avoids using true and false. */
    public static final boolean TAILS = false;
    /** used to store the flipped coins. */
    private boolean[] coins;
    
    /** Constructor.
        @param coins takes the boolean coins
    */
    public Coins(boolean[] coins) {
        this.coins = coins;
    }

    /** Constructor.
        @param c takes a String
    */
    public Coins(String c) {
        boolean[] b = new boolean[c.length()];
        for(int i = 0; i < c.length(); i++ ){
            if(c.charAt(i) == 'H'){
                b[i] = true;
            }else {
                b[i] = false;
            }
        }
        coins = b;
    }

    /** Constructor.
     @param i takes an int
    */
    public Coins(int i){
        Random num = new Random();
        boolean[] t = new boolean[i];
        for(int j = 0; j < i; j++){
            int ranNum = num.nextInt(2);
            if(ranNum == 1){
                t[j] = true;
            }else{
                t[j] = false;
            }
        }
        coins = t;
    }

    /**  Will Count the number of tail coins.
     @return tailCount will return the count of tails
    */
    public int countTails(){
        int tailCount = 0;
        for (int i = 0; i < coins.length; i++){
            if(!coins[i]){
                tailCount++;
            }
        }
        return tailCount ;
    }

    /** Will count the number of heads coins.
     @return headCount will return the count of heads*/
    public int countHeads(){
        int headCount= 0;
        for (int i = 0; i <coins.length; i++){
            if(coins[i]){
                headCount++;
            }
        }
        return headCount ;
    }

    /** Will count how many runs there are in each object.
     @return r.size()-1 will retrun how many runs there are
    */
    public int countRuns(){
        int runs = 1;
        for(int i = 0; i < coins.length; i++){
            
            if((i + 1) < coins.length && coins[i] != coins[i+1]){
                runs++;
            }
        }
        return runs;
    }

    /** Will display the boolean ina strig format.
     @return str which will display the boolean in strign format
    */
    public String toString(){
        String str = "";
        for(int i = 0; i < coins.length; i++){
            if(coins[i]){
                str += "H";
            }else{
                str += "T";
            }        
        }
        return str;
    }
    
    /**  main method.
     @param args say something here
    */
    public static void main(String[] args) {
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        
        //objects
        Coins c = new Coins(b);
        Coins d = new Coins("HTH");
        Coins e = new Coins(5);
        
    //System.out.println(c.countHeads());
    //System.out.println(d.countHeads());
    //System.out.println(e.countHeads());
        System.out.println(c.countRuns());
    }// main end
    
}// class end
