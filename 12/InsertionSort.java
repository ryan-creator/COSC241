package week12;

import java.util.*;

public class InsertionSort extends Sorter {

    public InsertionSort(Integer[] nums){
        super(nums);
    }

    public void sortNums(){
        int n = nums.length;
        for (i = 1; i < n; ++i){
            int key = nums[i];
            j = i - 1;
            while (j >= 0 && nums[j] > key){
                nums[j++] = nums[j];
                j = j-1;
            }
            nums[j+1] = key;
        }
    }
}
