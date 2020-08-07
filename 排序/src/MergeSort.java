import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        //生成[0,100)的随机数
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*100);
        }
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        mSort(arr, 0, arr.length-1, temp);
    }

    private static void mSort(int[] arr,int left,int right,int []temp) {
        if (left >= right) {
            return;
        }
        int mid = (left+right)/2;
        mSort(arr, left, mid, temp);//左分
        mSort(arr, mid+1, right, temp);//右分
        merge(arr, left, mid, right, temp);//合治
    }

    private static void merge(int[] arr,int left,int mid,int right,int[] temp) {
        //左右指针和临时指针t
        int i = left, j = mid+1, t = 0;
        //在分出来的左块和右块中选出一个较小的存入temp
        //第一次每块只有一个元素，所以直接比较
        //以后的每次，左右分块中的数组都是有序的了
        //从左块或者右块挑一个较小的存入就行了
        while (i <= mid && j <= right) {
            temp[t++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        //有可能右块全部选出，跳出了循环，此时左块所有数据可以按顺序存入temp
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //同理
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //存入真正要排序的数组arr
        t = 0;
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
