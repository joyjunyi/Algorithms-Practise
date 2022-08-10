package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);

    }
    //编写一个堆排序的方法
    public static void heapSort(int[] arr){
        int temp = 0;
        System.out.println("堆排序");
        // 分步骤，实现
        // 第1步
        //adjustHeap(arr, 1, arr.length);
        //System.out.println("第1次排序： " + Arrays.toString(arr));
        // 第2步
        //adjustHeap(arr, 0, arr.length);
        //System.out.println("第2次排序： " + Arrays.toString(arr));
        //
        for(int i  = arr.length/2 - 1; i >= 0 ; i--){
            adjustHeap(arr, i, arr.length);
        }
        System.out.println("第一次将无序序列构建成堆" + Arrays.toString(arr));

        //将堆顶元素和末尾元素交换，把最大的值放在最后

        for(int j = arr.length-1; j > 0 ; j--){
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j );
            System.out.println("调整数组" + (5-j) + Arrays.toString(arr));
        }

    }
    //讲一个数组（二叉树），调整成一个大顶堆
    /**
     * 功能：完成将以 i 对应的非叶子节点的数，调整成大顶堆
     * 举例：{4,6,8,5,9}，非叶子节点i=1, 即数组中的6，6和叶子里最大的9交换，得到{4,9,8,5,6}
     * @param arr       //待调整的数组
     * @param i         //表示非叶子节点的在数组中的索引
     * @param length    //表示对多少个元素进行调整，length是在逐渐减少
     */
    public static void adjustHeap(int[] arr, int i , int length){
        int temp = arr[i];  //先取出当前元素的值，保存在临时变量
        System.out.println("arr[i]=" + arr[i]);
        //开始调整
        //说明
        //k = i * 2 + 1  , k 是 i节点的左子节点
        for(int k = i * 2 + 1; k < length ; k = k * 2 + 1){
            if(k + 1 < length && arr[k] < arr[k + 1]){        //如果左子节点的值 < 右子节点的值
                k++;                        //这时候就让 k 指向右子节点
            }
//            System.out.println("k=" + k);
            if(arr[k] > temp){      //如果子节点 > 父节点
                arr[i] = arr[k];    //子节点和父节点交换
                i = k;              //！！！这个动作非常重要，让 i 指向 k 继续循环比较
            }else{
                break;
            }
        }
        //当for循环结束时，最顶上的是最大值
        arr[i] = temp;  //将temp值放到调整后的位置

    }
}
