# Algorithms

## Insertion Sort
  - **Code**
```Java
import java.util.Arrays;

public class sort.InsertionSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};     //初始数组
        insertionSort(arr);
    }
    
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int keyIndex = i - 1;

            while (keyIndex >= 0 && key < arr[keyIndex]) {
                arr[keyIndex + 1] = arr[keyIndex];  //后移，{101,34,119,1} => {101,101,119,1}
                keyIndex--;
            }

            arr[keyIndex + 1] = key;
            System.out.println("第" + i + "轮插入排序：");
            System.out.println(Arrays.toString(arr));
        }
    }
}
```
  - **Time Complexity**

![Insertion sort time complexity](https://i.stack.imgur.com/AxoMa.png)

## Merge Sort
divide and conquer: 分治法，即把问题分成若干子问题，分别解决（排序），最后合并

  - **Code**

```Java
public class sort.MergeSort {
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
```

- **Time Complexity**

O(n) = n·lgn
- **Space Complexity**

O(n) = n (因为在合并的时候要创建临时存放空间)


## Quick Sort

- **Code**

```Java
public class sort.QuickSort {
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
```

- **Time Complexity**
  
最坏情况下是O(n²)

平均的时间复杂度是O(n*lgn)

- **Space Complexity**

由于递归调用，快排的空间复杂度是Θ(lg𝑛)

## Heap Sort

- **Code**

```Java

```