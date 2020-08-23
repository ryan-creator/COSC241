package week11;

/**
 *  A Quick Sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Ryan Cole
 */

public class QuickSort extends Sorter {
    
    /**
     *  Create a new Quick sort sorter with the given integers to sort.
     *
     *  @param nums the integers to sort.
     */
    public QuickSort(Integer[] nums){
        super(nums);
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums(){
        sort(0,nums.length);
    }

    /**
     * Recusion method that will split the array into twos.
     * @param left most array index.
     * @param right most array index.
     */
    public void sort(int left, int right){
        if(left < right){
            comparisons++;
            int p = partition(left, right - 1);
            update();
            sort(left, p);
            update();
            sort(p + 1, right);
            update();
        }
    }

    /**
     * Recusion method that will split the array into twos.
     * @param left most array index.
     * @param right most array index.
     * @return hole 
     */
    public int partition(int left, int right){
        int pivot = nums[left];
        int hole = left;
        i = left + 1;
        j = right;
        while(true){
            while(j > hole && nums[j] >= pivot){
                j--;
            }
            if(j == hole){
                break;
                
            }
            nums[hole] = nums[j];
            hole = j;
            while(i < hole && nums[i] < pivot){
                i++;
            }
            if(i == hole){
                break;

            }
            nums[hole] = nums[i];
            hole = i;
        }
        nums[hole] = pivot;

        return hole;
    }
}
