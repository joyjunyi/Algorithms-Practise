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

```
- **Time Complexity**

主要在于初始化建堆和后来交换后循环建堆的过程。
* 循环n-1次，每次从根0一直到叶节点是log（n），所以O(nlg(n))
* 初始化建堆为从非叶节点层的最右端一个结点向上循环建堆，2^(i-1)*(k-i)  (i为当前层数，k为堆高度) O（n）
*  最好、最坏、平均情况都需要循环建堆， O（nlgn）

————————————————
- **Space Complexity**

空间复杂度：堆排序为原地排序，常量级额外空间 O（1）