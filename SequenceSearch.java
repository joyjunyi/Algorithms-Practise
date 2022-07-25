import java.util.Scanner;

/*
enter a string, and find it in the array.
give messages of any possible outcomes
 */
public class SequenceSearch {
    public static void main(String[] args) {
        String[] arr = {"apple","banana","orange","grape","pineapple","watermelon"};
        Scanner myscanner = new Scanner(System.in);
        int index = -1;

        System.out.println("please enter a fruit:");
        String fruit = myscanner.next();

        for(int i = 0 ; i < arr.length ; i++){
            if(fruit.equalsIgnoreCase(arr[i])){
                System.out.println(arr[i] + " is found in the " + (i+1) + "th position");
                index = i;
            }
        }
        //index == -1 is always used for the exception
        if(index == -1){
            System.out.println(fruit + " is not in the array.");
        }
    }
}
