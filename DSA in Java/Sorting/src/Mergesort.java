import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 1, 3, 4};
        System.out.println("Original array: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] mergedArray = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                mergedArray[k++] = arr[i++];
            } else {
                mergedArray[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            mergedArray[k++] = arr[i++];
        }

        while (j <= right) {
            mergedArray[k++] = arr[j++];
        }

        for (int x = 0, y = left; x < mergedArray.length; x++, y++) {
            arr[y] = mergedArray[x];
        }
        System.out.println("After merging: " + Arrays.toString(arr));
    }
}
