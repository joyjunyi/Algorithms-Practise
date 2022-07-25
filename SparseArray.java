public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始二维数组11*11
        //0：表示没有棋子；1表示黑子；2表示蓝子
        int chessArr1[][] = new int [11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[5][6] = 2;
        // output the original array
        for (int[] row:chessArr1 ){
            for(int data:row){
                System.out.printf("%d\t", data);
            }
            System.out.println("");
        }

        /* 二维数组 转 稀疏数组
        1、先遍历二维，得到非0数据的个数
        */
        int sum = 0;
        for (int i = 0 ; i < chessArr1.length ; i++){
            for(int j = 0 ; j < chessArr1[i].length; j++){
                if(chessArr1[i][j] != 0){
                    sum ++;
                }
            }
        }
        System.out.println("sum= " + sum);

        //创建稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0; // 用于记录是第几个非0数据

        //遍历二维数组，将非0的值存放到sparseArr中
        for (int i = 0 ; i < chessArr1.length ; i++){
            for(int j = 0 ; j < chessArr1[i].length; j++){
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        for(int[] row:sparseArr){
            for(int data:row){
                System.out.printf("%d\t", data);
            }
            System.out.println("");
        }
        //将稀疏数组 恢复成 二维数组
        //先造整体行列，再造非0数据
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        for(int i = 1 ; i < sparseArr.length; i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for(int[] row:chessArr2){
            for(int data:row){
                System.out.printf("%d\t", data);
            }
            System.out.println("");
        }

    }
}
