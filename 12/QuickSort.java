package week12;

public class QuickSort extends Sorter {
    
    public QuickSort(Integer[] nums){
        super(nums);
    }

    public void sortNums(){
        quickSort(0,nums.length - 1);
    }

    public void quickSort(int left, int right){
        if(comparisons++ >= 0 && left < right){
            int p = partition(left, right);
            update();
            quickSort(left, p);
            update();
            quickSort(p + 1, right);
            update();
        }
    }

    public int partition(int left, int right){
        int pivot = nums[left];
        int hole = left;
        int i = left + 1;
        int j = right;
        while(true){
            while(comparisons++ >= 0 && j > hole && nums[j] >= pivot){
                j--;
            }
            update();
            if(comparisons++ >= 0 && j == hole){
                break;
            }
            nums[hole] = nums[j];
            hole = j;
            update();
            while(comparisons++ >= 0 && i < hole && nums[i] < pivot){
                i++;
            }
            if(comparisons++ >= 0 && i == hole){
                break;
            }
            update();
            nums[hole] = nums[i];
            hole = i;
        }
        update();
        nums[hole] = pivot;
        return hole;
    }
    
}
