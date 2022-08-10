package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];       // 归并排序需要额外的空间
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("归并排序后");
        System.out.println(Arrays.toString(arr));
    }
    //分解的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right)/2;     // 中间索引
            // 向左递归进行分解
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            mergeSort(arr, mid+1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }
    //合并的方法
    /**
     * @param arr   原始数组
     * @param left  左边有序数组初始索引
     * @param mid   中间索引
     * @param right 数组最右边的索引
     * @param temp  中转数组
     *
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left; // 初始化i, 左边有序序列的初始索引
        int j = mid + 1;  // 初始化j, 右边有序序列的第一位
        int t = 0; // 指向temp数组的当前索引

        //  1） 先把左右两边的有序数组，按顺序，填入temp，直到有一边处理完为止
        while(i <= mid && j <= right){
            if(arr[i]  <= arr[j]){
                temp[t]=arr[i];
                i++;
            }else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }

        //  2） 剩下另一边，就依次填充进temp即可
        while(i <= mid){
            temp[t] = arr[i];
            i++;
            t++;
        }
        while(j <= right){
            temp[t] = arr[j];
            j++;
            t++;
        }
        //  3） 将temp数组的元素依次copy到arr
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }
}
