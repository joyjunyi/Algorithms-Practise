package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6,5,3,1,8,7,2,4};

        quickSort(arr,0,arr.length-1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int left,int right) {
        int pivot,i,j,temp;

        if(left >= right) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        pivot = arr[right];
        i = left;
        j = right;
        while(i < j) {
            //左边当发现大于p的值时停止循环
            while(arr[i] <= pivot && i < j) {
                i++;
            }
            //右边当发现小于p的值时停止循环
            while(arr[j] >= pivot && i < j) {
                j--;
            }

            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[right] = arr[j];//这里的arr[j]一定是停小于p的，经过i、j交换后j处的值一定是小于p的(i先走)
        arr[j] = pivot;
        quickSort(arr,left,i-1);  //对左边快排
        quickSort(arr,i+1,right); //对右边快排

    }
}
