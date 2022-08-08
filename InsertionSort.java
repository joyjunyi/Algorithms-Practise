import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
    //定义数组
        int[] arr = {101,34,119,1};
        insertionSort(arr);
    }
    // 最终合体
    public static void insertionSort(int[] arr){
        for(int i = 1 ; i < arr.length ; i++) {
            int key = arr[i];
            int keyIndex = i - 1;

            while (keyIndex >= 0 && key < arr[keyIndex]) {
                arr[keyIndex + 1] = arr[keyIndex];  //后移，{101,34,119,1} => {101,101,119,1}
                keyIndex--;
            }

            arr[keyIndex + 1] = key;
            System.out.println("第"+ i +"轮插入排序：");
            System.out.println(Arrays.toString(arr));
        }
    }

    // 分步骤进行
    public static void insertionSort01(int[] arr){
        //第1轮，给34找位子，即{101,34,119,1} => {34,101,119,1}

        //定义待插入的数
        int key = arr[1];
        int keyIndex = 1 - 1; //即arr[1]前面数的下标

        //给key找到插入的位置
        //说明：
        //1、keyIndex >= 0 这句话保证不越界
        //2、key < arr[keyIndex] 表示待插入数还没有找到插入的位置
        //3、就需要将arr[keyIndex]后移
        while(keyIndex >= 0 && key < arr[keyIndex]){
            arr[keyIndex + 1] = arr[keyIndex];  //后移，{101,34,119,1} => {101,101,119,1}
            keyIndex--;
        }
        //当退出while循环时，说明插入的位置找到，keyIndex + 1
        //举例：
        arr[keyIndex + 1] = key;
        System.out.println("第1轮插入排序：");
        System.out.println(Arrays.toString(arr));

        //第2轮，给119找位子，即{34,101,119,1} => {34,101,119,1}

        //定义待插入的数
        key = arr[2];
        keyIndex = 2 - 1; //即arr[1]前面数的下标

        //给key找到插入的位置
        //说明：
        //1、keyIndex >= 0 这句话保证不越界
        //2、key < arr[keyIndex] 表示待插入数还没有找到插入的位置
        //3、就需要将arr[keyIndex]后移
        while(keyIndex >= 0 && key < arr[keyIndex]){
            arr[keyIndex + 1] = arr[keyIndex];  //后移，{101,34,119,1} => {101,101,119,1}
            keyIndex--;
        }
        //当退出while循环时，说明插入的位置找到，keyIndex + 1
        //举例：
        arr[keyIndex + 1] = key;
        System.out.println("第2轮插入排序：");
        System.out.println(Arrays.toString(arr));

        //第3轮，给1找位子，即{34,101,119,1} => {1,34,101,119}

        //定义待插入的数
        key = arr[3];
        keyIndex = 3 - 1; //即arr[1]前面数的下标

        //给key找到插入的位置
        //说明：
        //1、keyIndex >= 0 这句话保证不越界
        //2、key < arr[keyIndex] 表示待插入数还没有找到插入的位置
        //3、就需要将arr[keyIndex]后移
        while(keyIndex >= 0 && key < arr[keyIndex]){
            arr[keyIndex + 1] = arr[keyIndex];  //后移，{101,34,119,1} => {101,101,119,1}
            keyIndex--;
        }
        //当退出while循环时，说明插入的位置找到，keyIndex + 1
        arr[keyIndex + 1] = key;
        System.out.println("第3轮插入排序：");
        System.out.println(Arrays.toString(arr));
    }
}
