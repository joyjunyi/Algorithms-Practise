/*
猴子吃桃子问题：
有一堆桃子，猴子每天都吃其中一半，然后再多吃一个。
当到第10天时，想再吃时，发现只有1个桃子了。问题：最初共多少桃子？
Day10 = 1 = Day 9/2 - 1
Day9 = (Day10 + 1) * 2
Day8 = (Day9 + 1) * 2
...
Day1 = (Day2 + 1) * 2
Day0 = (Day1 + 1) * 2
DayN = (Day(N+1) + 1) * 2
 */
public class RecursionExercise02 {
    public static void main(String[] args) {
        Monkey m = new Monkey();
        int day = 8;
        int num = m.monkey(day);
        System.out.println("第"+ day + "天，还剩余" + num + "只桃子");
    }
}
class Monkey{
    public int monkey(int n) {
        if(n == 10){
            return 1;
        } else if (n >= 0 && n < 10) {
            return (monkey(n+1)+1)*2;
        } else{
            System.out.println("n should be >= 0");
            return -1;
        }
    }
}