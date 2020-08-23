package week12;

public class SelectionSort extends Sorter {

    public SelectionSort(Integer[] nums){
        super(nums);
    }

    public void sortNums(){
        for(i = 0; i < nums.length; i++){
            int min_idx = i;
            for(j = i; j < nums.length; j++){
                if(comparisons++ >= 0 && nums[j] < nums[min_idx]){
                    min_idx = j;
                }
            }
            int temp = nums[min_idx];
            nums[min_idx] = nums[i];
            nums[i] = temp;
            update();
        }
    }
}
