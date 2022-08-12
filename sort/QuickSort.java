package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 4, 3, 3, 8, 32};

        quickSort(arr,0,arr.length-1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right) {
        int pivot,i,j,temp;

        if(left >= right) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        pivot = arr[left];
        i = left;
        j = right;
        while(i < j) {
            //右边当发现小于p的值时停止循环
            while(arr[j] >= pivot && i < j) {
                j--;
            }

            //这里一定是右边开始，上下这两个循环不能调换

            //左边当发现大于p的值时停止循环
            while(arr[i] <= pivot && i < j) {
                i++;
            }

            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[left] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[i] = pivot;
        quickSort(arr,left,j-1);  //对左边快排
        quickSort(arr,j+1,right); //对右边快排

    }
}
