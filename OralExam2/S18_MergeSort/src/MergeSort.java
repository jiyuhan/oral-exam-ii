import java.util.Random;

/**
 * Created by thomas on 10/29/16.
 */
public class MergeSort {
    /**
     * The actual array of integers.
     */
    private static int[] arr;
    /**
     * A sub-array while merging or dividing.
     */
    private static int[] mergeArr;
    /**
     * Size of an array.
     */
    private static int size;

    /**
     * <b>Description:</b> It prints all items in an array
     *
     * @param msg a message from user
     */
    private static void printArray(String msg) {
        System.out.print(msg + " [" + arr[0]);
        for (int i = 1; i < size; i++) System.out.print(", " + arr[i]);
        System.out.println("]");
    }

    /**
     * <b>Description:</b> This method merges two array in order.
     * From merge arr[low, middle-1] and arr[middle, high-1] into arr[low, high-1].
     *
     * @param low    as the beginning point in the first sub-array
     * @param middle the ending point of the first sub-array and
     *               the beginning point in the second sub-array
     * @param high   the ending point of the second sub-array
     */
    private static void merge(int low, int middle, int high) {
        // merge arr[low, middle-1] and arr[middle, high-1] into arr[low, high-1]
        // Copy first part into the arrCopy array
        /*for (int i = low; i < middle; i++) mergeArr[i] = arr[i];*/
        System.arraycopy(arr, low, mergeArr, low, (middle - low));
        int i = low;
        int j = middle;
        int k = low;
        // Copy the smallest values from either the left or the right side back        // to the original array
        while (i < middle && j < high)
            if (mergeArr[i] <= arr[j])
                arr[k++] = mergeArr[i++];
            else
                arr[k++] = arr[j++];
        // Copy the rest of the left part of the array into the original array
        while (i < middle) arr[k++] = mergeArr[i++];
    }

    /**
     * <b>Description:</b> This method sorts an array using merge sort.
     *
     * @param low  starting place in a (sub)array
     * @param high ending place in a (sub)array
     */
    private static void mergeSort(int low, int high) {
        // sort arr[low, high-1]
        // Check if low is smaller than high, if not then the array is sorted
        if (low < high - 1) {
            // Get the index of the element which is in the middle
            int middle = (high + low) / 2;
            // Sort the left side of the array
            mergeSort(low, middle);
            // Sort the right side of the array
            mergeSort(middle, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    public static void main(String[] args) {
        int random;

        size = 100; // setting the size of the array to 100

        // create array
        arr = new int[size]; // initialize a new array with 100 items
        mergeArr = new int[size]; // the merge array will be initiated wit the same size of 100
        Random randomGenerator = new Random(); // a random generator

        random = size * 10; // 100 as the size, 0 ~ 1000 as a random number range
        for (int j = 0; j < size; j++)
            arr[j] = randomGenerator.nextInt(random); // generates random numbers < = 1000

        // Merge sort
        printArray("in"); // output the array before it's sorted
        mergeSort(0, size); // then sorts the array
        printArray("out"); // it works like a champ
    }
}
