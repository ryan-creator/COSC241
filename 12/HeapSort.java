package week12;

public class HeapSort extends Sorter {

    public HeapSort(Integer[] nums){
        super(nums);
    }

    public void sortNums(){
        int n = nums.length;
        for(i = n / 2 - 1; i >= 0; i--){
            heapify(nums.length, i);
        }  

        for(i = n - 1; i >= 0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(i,0);
        } 
    }

    public void heapify(int n, int index){
        int root = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        if(leftChild < n && nums[leftChild] > nums[root]){
            root = leftChild;
        }
        if(rightChild < n && nums[rightChild] > nums[root]){
            root = rightChild;
        }
        if(root != index){
            swap(i,j);
            // int temp = nums[index];
            // nums[index] = nums[root];
            // nums[root] = temp;
            heapify(n, root);
        }
    }   
}
