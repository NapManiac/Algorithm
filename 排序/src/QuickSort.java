import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        //生成[0,100)的随机数
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*100);
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length-1);
    }

    private static void qSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //以mid为分界点，分左边和右边，左边都比arr[mid]小，右边都比他大
        int mid = partition(arr, left, right);
        qSort(arr, left, mid-1);
        qSort(arr, mid+1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        //保存第一个元素，防止多次交换浪费时间
        int x = arr[left];
        while (left < right) {
            //从右到左，找到一个小于x的元素
            while (left < right && arr[right] >= x) {
                right--;
            }
            if (left < right) {
                arr[left++] = arr[right];
            }
            //从左到右，找到一个大于x的元素
            while (left < right && arr[left] <= x) {
                left++;
            }
            if (left < right) {
                arr[right--] = arr[left];
            }
        }
        arr[left] = x;
        return left;//返回分界点
    }
}
