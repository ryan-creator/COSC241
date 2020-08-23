package week12 ;

public class MergeSort extends Sorter{
    
    public MergeSort(Integer[] nums){
        super(nums);
    }

    public void sortNums(){
        mergeSort(0,nums.length - 1);
    }

    public void mergeSort(int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid + 1, right);
        }
    }

    public void merge(int left, int mid, int right){
        int[] temp = new int[nums.length];
        for(i = 0; i < nums.length; i++){
            temp[i] = nums[i];
        }
        i = left;
        j = left;
        int k = mid;
        while(i < mid && k <= right){
            if(temp[i] < temp[k]){
                nums[j++] = temp[i++];
            } else {
                nums[j++] = temp[k++];
            }
        }
        while(i < mid){
            nums[j++] = temp[i++];
        }
        while(j <= right){
            nums[j++] = temp[k++];
        }
    }
}
