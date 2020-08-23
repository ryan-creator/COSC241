package week12;

import java.util.Scanner;
import java.util.function.Function;

public class Tableau {

    private Cell smallest = null;

    public void addValue(Integer value) {
        if(smallest == null){
            smallest = new Cell(value);
            return;
        }
        value = addToRow(smallest,value);
        Cell curr = smallest;
        while(value != null){
            if(curr.below == null){
                Cell newCell = new Cell(value);
                newCell.above = curr;
                curr.below = newCell;
                return;
            } else {
                curr = curr.below;
                value = addToRow(curr,value);
            }
        }
    }

    
    protected Integer addToRow(Cell cell, int value) {
        while(cell.right != null && cell.value < value){
            cell = cell.right;
        }
        if(cell.value > value){
            int temp = cell.value;
            cell.value = value;
            return temp;
        } else {
            Cell newCell = new Cell(value);
            newCell.left = cell;
            cell.right = newCell;
            if(cell.above == null){
                newCell.above = null;
            } else {
                if(cell.above.right == null){
                    newCell.above = null;
                } else {
                    newCell.above = cell.above.right;
                }
            }
            if(cell.above != null && cell.above.right != null){
                cell.above.right.below = newCell;
            }
        }
        return null;
    }


    protected void print(Function<Cell,Integer> f) {
        for (Cell i = smallest; i != null; i = i.below) {
            for (Cell j = i; j != null; j = j.right) {
                System.out.printf("[%2d]", f.apply(j));
            }
            System.out.println();
        }
    }


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

        Cell(int value) {
            this.value = value;
        }

        int neighbours() {
            int count = left != null ? 1 : 0;
            count += right != null ? 1 : 0;
            count += above != null ? 1 : 0;
            count += below != null ? 1 : 0;
            return count;
        }
    }

}
