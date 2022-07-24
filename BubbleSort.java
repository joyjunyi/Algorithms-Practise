public class BubbleSort {
    /*  Sort from smallest to largest
     */
    public static void main(String[] args) {
        int[] arr = {7,2,5,2,7,3,4,8,4,5,33,2,1,34};
        int temp = 0;

        for(int i = 0 ; i < arr.length-1 ; i++){
            for (int j = 0 ; j < arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + ",");
        }
    }
}
