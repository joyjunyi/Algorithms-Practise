/*
两个案例，帮助大家理解递归调用机制
 */
public class Recursion01 {

    public static void main(String[] args) {
        T t1 = new T();
        t1.test(4);
        int res = t1.factorial(5);
        System.out.println("res = " + res);
    }
}

class T{
    // 1、打印问题
    public void test(int n){
        if(n>2){
            test(n-1);  // 递归调用
        }
        System.out.println("n=" + n);
    }

    // 2、阶乘问题
    public int factorial(int n){
        if(n == 1){
            return 1;
        }else{
            return factorial(n-1)*n;
        }
    }
}
//