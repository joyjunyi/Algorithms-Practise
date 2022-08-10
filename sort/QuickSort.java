package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,6,2,5,3,9,4,0,11};
        quickSort(arr,0,arr.length-1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int left, int right){
        int l = left;       //左下标
        int r = right;      //右下标
        int temp = 0;
        // pivot 中轴值
        //这里选取了数组中间的值，当然也可以选取数组里任何一个值
        int pivot = arr[(left + right)/2];

        //while循环，把比pivot小的数，放到pivot左边
        while(l < r){
            //在pivot左边一直找，直到找到大于等于pivot的值
            while(arr[l] < pivot){
                l++;
            }
            //在pivot右边一直找，直到找到小于等于pivot的值
            while(arr[r] > pivot){
                r--;
            }

            if(l >= r){ //说明pivot左右两边的值已交换完成
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot, r-- 前移；
            if(arr[l] == pivot){
                r--;
            }
            //如果交换完后，发现这个arr[r] == pivot, l++ 后移；
            if(arr[r] == pivot) {
                l++;
            }
        }
        //如果l=r,就必须l++,r-- 否则会栈溢出
        if(l == r){
            l++;
            r--;
        }
        //向左递归
        if(left < r){
            quickSort(arr,left,r);
        }
        //向右递归
        if(right > l){
            quickSort(arr,l,right);
        }
    }
}
