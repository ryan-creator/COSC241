package week05;

import java.util.Scanner;
import java.util.function.Function;

/**
 *  An implementation of Young's tableau using linked cells.
 *
 * @author Iain Hewson
 */
public class Tableau {

    /** The smallest value (or root) of this Tableau. */
    private Cell smallest = null;
    /** The smallest value (or root) of this Tableau. */
    //private Cell currRow = null;
    /** The smallest value (or root) of this Tableau. */
    //private Cell newRow;
    
    
    /**
     *  Adds the given value to this tableau.
     *
     * @param value the value to be added to this tableau.
     */
    public void addValue(Integer value) {
        if (smallest == null) {
            smallest = new Cell(value);
            return;
        }        
        Cell currRow = smallest;
        Integer newValue = addToRow(currRow,value);
        while(newValue != null){
            if(currRow.below == null){
                Cell newRow = new Cell(newValue);
                newRow.above = currRow;
                currRow.below = newRow;
                return;
            } else {
                currRow = currRow.below;
                newValue = addToRow(currRow,newValue);
            }
        }       
    }

    

    /**
     *  Adds the given value to the row beginning with
     *  <code>curr</code>, keeping the row in ascending order.  If the
     *  value gets added to the end of the row <code>null</code> is
     *  returned, otherwise the bumped value is returned.
     *
     * @param curr the first cell in the current row.
     * @param value the value to be added to the row.
     * @return the bumped value, or null if the value was added to the
     *         end of the row.
     */
    protected Integer addToRow(Cell curr, int value) {
        while(curr.right != null && curr.value <  value){
            curr = curr.right;
        }
        if(curr.value >  value){
            int temp = curr.value;
            curr.value = value;
            return temp;
        }else{      
            Cell newCell  = new Cell(value);            
            curr.right = newCell;
            newCell.left = curr;
            if(curr.above == null){
                newCell.above = null;
            } else {
                if(curr.above.right == null){
                    newCell.above = null;
                } else {
                    newCell.above = curr.above.right;
                }
            }
            if(curr.above != null && curr.above.right != null){
                curr.above.right.below = newCell;
            }
            return null; 
        }
    }

    /**
     *  Iterate through every cell in the tableau printing them using
     *  the given function.
     *
     * @param f a function which when applied to a cell should return
     *        an integer.
     */
    protected void print(Function<Cell,Integer> f) {
        for (Cell i = smallest; i != null; i = i.below) {
            for (Cell j = i; j != null; j = j.right) {
                System.out.printf("[%2d]", f.apply(j));
            }
            System.out.println();
        }
    }

    /**
     *  Entry point of the program.  Reads numbers from stdin and adds
     *  them to a Tableau.  If <code>p</code> is input then the
     *  tableau is printed.  If <code>c</code> is input then a count
     *  of the neighbours of each cell is printed.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        Tableau t = new Tableau();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                t.addValue(input.nextInt());
            } else {
                String command = input.next();
                if ("p".equals(command)) {
                    t.print(cell -> cell.value);
                } else if ("c".equals(command)) {
                    t.print(cell -> cell.neighbours());
                }
            }
        }
    }

    /**
     *  A cell which holds a value and links to neighbouring cells.
     */
    protected static class Cell {
        /** The value held by this cell. */
        int value;
        /** The cell above this cell. */
        Cell above;
        /** The cell below this cell. */
        Cell below;
        /** The cell to the left of this cell. */
        Cell left;
        /** The cell to the right of this cell. */
        Cell right;

        /** Creates a new cell with the given value.
         * @param value the value contained in this cell.
         */
        Cell(int value) {
            this.value = value;
        }

        /** Returns how many horizontal and vertical (but not diagonal)
         *  neighbours this cell has.
         * @return how many neighbours this cell has.
         */
        int neighbours() {
            int count = left != null ? 1 : 0;
            count += right != null ? 1 : 0;
            count += above != null ? 1 : 0;
            count += below != null ? 1 : 0;
            return count;
        }
    }

}
