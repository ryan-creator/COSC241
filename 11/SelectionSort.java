package week11;

/**
 *  A Selection Sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Ryan Cole
 */

public class SelectionSort extends Sorter {

    /**
     *  Create a new SelectionSort sorter with the given integers to sort.
     *
     *  @param nums the integers to sort.
     */
    public SelectionSort(Integer[] nums){
        super(nums);
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums(){
        int smallestIndex = 0;
        for(i = 0; i < nums.length-1; i++){
            int value = nums[i];
            for(j = i; j < nums.length; j++){
                if(++comparisons > 0 && nums[j] < value){
                    value = nums[j];
                    smallestIndex = j;
                }
            }
            if(nums[smallestIndex] == value){
                int temp = nums[i];
                nums[i] = nums[smallestIndex];
                nums[smallestIndex] = temp;
                update();
            }
        }
    }
}
