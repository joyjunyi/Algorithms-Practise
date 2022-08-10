package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.SimpleTimeZone;

/*
sort array , from small to big
 */
public class BubbleSortOptimization {
    public static void main(String[] args) {
        //随机生成一个数组，里面有10个数据
        int[] arr= new int[80000];
        for(int i = 0 ; i < 80000 ; i++){
            arr[i] = (int)(Math.random()*800000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是 " + dateString);
//        System.out.println("排序前：" + Arrays.toString(arr));

        bubbleSort(arr);
//        System.out.println("排序后：" + Arrays.toString(arr));

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        String dateString2 = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是 " + dateString2);

    }
    //优化：把冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr){
        int temp = 0;
        //优化：当有一轮，一次排序都没有进行，则表示已经完成排序
        boolean flag = false; //创建标识，以记录各轮排序是否一次都没交换过

        for(int i = 1 ; i < arr.length ; i++){
            for(int j = 1 ; j < arr.length - i ; j++){

                if (arr[j - 1] > arr[j]) {
                    flag = true;
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!flag){ //在这一轮中，一次都没有交换过
                break;
            }else{
                flag = false; //重置flag
            }
        }
    }
}
