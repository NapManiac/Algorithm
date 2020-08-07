import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[10000000];
        //生成[0,100)的随机数
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*100);
        }
        System.out.println(Arrays.toString(arr));
        headSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void headSort(int[] arr) {
        //从最后一个非叶子节点开始调整为大顶堆
        for (int i = arr.length/2-1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        //将每个大顶堆的根和最后一个交换，再构建大顶堆
        for (int i = arr.length-1; i > 0; i--) {
            swap(arr, i, 0);
            adjustHeap(arr, 0, i);
        }
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        //先取出可能要交换的父节点arr[i]
        int temp = arr[i];
        //交换可能导致儿子节点比孙子节点小，所以要循环下去
        for (int k = 2*i+1; k <= length-1; k = k*2+1) {
            //判断哪个儿子更大，注意，需要先判断右儿子存不存在
            if (k+1 <= length-1 && arr[k] < arr[k+1]) {
                k++;//k指向右儿子
            }
            //令父节点保存比他更大的儿子节点
            if (temp < arr[k]) {
                arr[i] = arr[k];
                //该子节点继续向下寻找不符合大顶堆的子节点
                i = k;
            } else {
                //没产生交换说明父节点以下的符合大顶堆，不需要继续
                break;
            }
        }
        //频繁换导致效率低，直接最后赋值
        arr[i] = temp;
    }
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
