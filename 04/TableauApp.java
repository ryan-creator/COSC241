package week04;

/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {

    }

    /**
     * Returns true if its a real tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return boolean.
     */ 
    public static boolean isTableau(int[][] t){
        if(rowLengthsDecrease(t) && isSetOf1toN(t)){
            if(columnValuesIncrease(t)  && rowValuesIncrease(t)){
                return true;
            }
        }
        return false;
    }

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    /**
     *  Returns true if no row is longer than a preceding row otherwise false.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return temp a boolean.
     */
    public static boolean rowLengthsDecrease(int[][] t){
        int rowCount = 0;
        int temp = 0;
        for(int row = 0; row < t.length; row++){
            for(int col = 0; col < t[row].length; col++){     
                rowCount++;       
            }// for end 
            if(rowCount > temp && temp != 0){
                return false;
            }
            temp = rowCount;
            rowCount = 0;      
        }// for end
        return true;
    }

    /**
     * Returns true if from right to left in any row  intergers are increasing.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return temp a boolean.
     */ 
    public static boolean rowValuesIncrease(int[][] t){
        int temp = 0;
        for(int row = 0; row < t.length; row++){
            temp = 0;
            for(int col = 0; col < t[row].length; col++){
                if(temp > t[row][col]){
                    return false;
                }       
                temp = t[row][col];   
            }
        } 
        return true;
    }

    /**
     * Returns true if from top to bottom in any col  intergers are increasing.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return temp a boolean.
     */ 
    public static boolean columnValuesIncrease(int[][] t){
        int temp = 0;
        for(int col = 0; col < t.length; col++){        
            for(int row = 0;row < t[col].length; row++){
                if( col != 0 && t[col][row] < t[col-1][row]){
                    return false;
                }         
            }
        } 
        return true;
    }

    /**
     * Returns true if the set of intergers used is 1 ... n, with n being num.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return temp a boolean.
     */ 
    public static boolean isSetOf1toN(int[][] t){
        int count = 1;  
        for(int row = 0; row < t.length; row++){
            for(int col = 0; col < t[row].length; col++){
                if(t[row][col] == count){
                    row = 0;
                    col = 0;
                    count++;
                    if(count == countCells(t)){
                        return true;
                    }
                }
            }
        }
        return false;  
    }

    /**
     * Returns the number of cells in the tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return count is an int.
     */ 
    public static int countCells(int[][] t){
        int count = 1;
        for(int row = 0; row < t.length; row++){
            for(int col = 0; col < t[row].length; col++){
                count++;
            }
        }
        return count;  
    }
}
