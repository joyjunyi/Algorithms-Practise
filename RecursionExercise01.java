/*
请使用递归的方式求出斐波那契数：1，1，2，3，5，8，13...（第一第二位是1，从第三位起，是前两数之和）
给你一个整数n，求出第n个数的值是多少。
analyze
if n == 0 || n == 1
arr[n] = 1
else if n >= 2
arr[n] = arr[n-1] + arr[n-2]
else
print"n should be >= 0"
 */

import org.w3c.dom.ls.LSOutput;

public class RecursionExercise01 {
    public static void main(String[] args) {
        F f = new F();
        int a = 7;
        int b = f.fibonacci(a);
        if(b != -1){
            System.out.println("当 n= " + a + "时,对应的斐波那契数 = " + b );
        }
    }
}
class F{
    int arr[];
    public int fibonacci(int n){
        if(n == 1 || n == 2){
            return 1;
        } else if (n >= 2) {
            return fibonacci(n-1) + fibonacci(n-2);
        }else{
            System.out.println("n should be >= 1");
            return -1;
        }
    }
}