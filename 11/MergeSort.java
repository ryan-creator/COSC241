package week11;

/**
 *  A Merge Sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Ryan Cole
 */

public class MergeSort extends Sorter{
    
    /** new temp array. */
    private int[] temp;
    /**
     *  Create a new MergeSort sorter with the given integers to sort.
     *
     *  @param nums the integers to sort.
     */
    public MergeSort(Integer[] nums){
        super(nums);
    }

     /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums(){
        comparisons = 0;
        temp = new int[nums.length];
        sort(0,nums.length - 1);
    }

     /**
     * Recusion method that will split the array into twos.
     * @param left most array index.
     * @param right most array index.
     */
    public void sort(int left, int right){
        if(left < right){
            comparisons++;
            int mid = (left + right) / 2;
            sort(left, mid);
            update();
            sort(mid + 1, right);
            update();
            merge(left, mid + 1, right);
            update();
        }
    }

    /**
    * Merges the subarrays together.
    * @param left most array index.
    * @param mid middle arry index.
    * @param right most array index.
    */
    public void merge(int left, int mid, int right){
        for(int s = left; s <= right; s++){
            temp[s] = nums[s]; 
        }

        int i = left;
        int j = left;
        int k = mid;

        while(i < mid && k <= right){
            comparisons++;
            if(temp[i] < temp[k]){
                comparisons++;
                nums[j++] = temp[i++];
            } else {
                nums[j++] = temp[k++];
                comparisons++;
            }
            update();
        }
        while(i < mid){
            nums[j++] = temp[i++];//
            comparisons++;
            update();
        }
        while(j <= right){
            nums[j++] = temp[k++];
            comparisons++;
            
        }
    }
}
