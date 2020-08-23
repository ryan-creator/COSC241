package week11;

import java.util.*;

/**
 *  A Insertion Sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Ryan Cole
 */

public class InsertionSort extends Sorter {

    //private ArrayList<Integer> list = new ArrayList<>();
    /**
     *  Create a new InsertionSort sorter with the given integers to sort.
     *
     *  @param nums the integers to sort.
     */
    public InsertionSort(Integer[] nums){
        super(nums);
    }

    /** Sort the array.  */
    public void sortNums() {
        comparisons = 0;
        int n = nums.length;
        for (int i = 1; i < n; ++i){
            int key = nums[i];
            int j = i-1;
            while (j >= 0 && nums[j] > key){
                comparisons++;
                nums[j+1] = nums[j];
                j = j-1;
                update();
            }
            nums[j+1] = key;
        }
    }

    /* My Insertion sort that works but doesn't pass the check 

    public void sortNums(){
        int count = 0;
        
        list.add(0,nums[0]);
        for(i = 1; i < nums.length; i++){
            insert(nums[i]);
            
        }    
        convert();
        update();
    }

    public void insert(int a){
        int sc = 0;
        for(int l = 0; l < list.size(); l++){

            if(a <= list.get(l) && ++comparisons > 0){
                
                System.out.println("    "+list.size());
                list.add(l,a);
                break;
            } else if(a > list.get(list.size()-1)){
                list.add(list.size(), a);
            }
            
        }
    }

    public void printArray(){
        for(int g = 0; g < list.size(); g++){
            System.out.print(list.get(g) + " ");
        }
    }

    public void convert(){
        try {
           for(int b = 0; b < list.size(); b++){
                nums[b] = list.get(b);
            } 
        } catch(Exception e){
            //error
        }
    }
    */
}
