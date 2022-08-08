/*
maze game: 设计一个迷宫
 */
public class RecursionMazeGame {
    public static void main(String[] args) {
        // 造一个二维数组，表示迷宫，1表示障碍物，0表示空
        int[][] arr = new int[7][7];
        for(int i = 0 ; i < 7 ; i++){
            arr[i][0] = 1;
            arr[i][6] = 1;
        }
        for(int i = 0 ; i < 7 ; i++){
            arr[0][i] = 1;
            arr[6][i] = 1;
        }
        arr[3][1] = 1;
        arr[3][2] = 1;

        M m = new M();
        m.findWay(arr,1,1);
        //print the maze
        System.out.println("=====初始迷宫为=====");
        for(int[] row:arr){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println("");
        }
    }
}
/* start: arr[i][j]
check order is → ↓ ↑ ←, everytime
如果找到路，返回true；如果是死路，返回false
0 为没走过的地方；1为障碍物；2为走过的地方；3表示走过走不通是死路
if arr[6][6] == 2, return true（走出了）
if arr[i][j+1] = 0, then arr[i][j+1] = arr[i][j]
else if arr[i-1][j] = 0, then  arr[i-1][j] = arr[i][j]
else if arr[i+1][j] = 0, then  arr[i+1][j] = arr[i][j]
else if arr[i][j-1] = 0, then  arr[i][j-1] = arr[i][j]
*/
class M{
    int[][] arr;
    public boolean findWay(int[][] arr, int i, int j){
        if(arr[6][6]== 2){
            return true;
        }else{
            if (arr[i][j] == 0) {           //说明当前位置没走过，可以走
                arr[i][j] = 2;
                if(findWay(arr,i+1,j)){             // ↓
                    return true;
                } else if (findWay(arr,i,j+1)) {    // →
                    return true;
                } else if (findWay(arr,i-1,j)) {    // ↑
                    return true;
                } else if (findWay(arr,i,j-1)) {    // ←
                    return true;
                }
            }else{                          //如果arr[i][j]不等于0，等于1，2，3
                return false;               //走不通
            }
        }
        return false;



    }
}