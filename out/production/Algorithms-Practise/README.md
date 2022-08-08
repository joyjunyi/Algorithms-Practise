# Algorithms

## Insertion Sort
  **Code**
```Java
import java.util.Arrays;

public class InsertionSort {
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
  **Time Complexity**

![Insertion sort time complexity](https://i.stack.imgur.com/AxoMa.png)

## Insertion Sort
**Code**
```Java

```