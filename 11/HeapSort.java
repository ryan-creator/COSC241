package week11;

/**
 *  A Heap Sort implementation which is able to be observed through its
 *  Sorter superclass.
 *
 * @author Ryan Cole
 */

public class HeapSort extends Sorter {
    
    /**
     *  Create a new Heap sort sorter with the given integers to sort.
     *
     *  @param nums the integers to sort.
     */
    public HeapSort(Integer[] nums){
        super(nums);
    }

    /**
     * Sort the integers (which are stored in the parent Sorter class).
     */
    public void sortNums(){
        int n = nums.length;
        for(int i = n / 2 - 1; i >= 0; i--){
            heapify(nums.length, i);
        }

        for(int i = n - 1; i >= 0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            update();
            heapify(i, 0);
        }
    }

    /**
    * Will heapify the array and put the largest int in the root of the heap.
    * @param n length of the array.
    * @param index the index of the start point.
    */
    public void heapify(int n, int index){
        int root = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 *  index + 2;
        if(leftChild < n && nums[leftChild] > nums[root]){
            root = leftChild;
            update();
        }
        if(rightChild < n && nums[rightChild] > nums[root]){
            root = rightChild;
            update();
        }
        if(root != index){
            int temp = nums[index];
            nums[index] = nums[root];
            nums[root] = temp;
            update();
            heapify(n, root);
        }
    }
}
