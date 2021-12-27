package d1215;

import java.util.*;

/**
 * @author qlk
 * @create 2021-12-15-18:10
 */
public class p4 {
    public void inter(){
//        Scanner scanner = new Scanner(System.in);
//        String in = scanner.nextLine();
        int[][] in1 = {{ 0, 9},{4 , 1},{5 , 7},{6 , 2},{7 , 4},{10 , 9}};
        int in2 = 5;
        int in3 = 4;
        maxTotalFruits(in1,in2,in3);
    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int[] length = new int[fruits.length];
        length[0] = fruits[0][1];
        for (int i = 1; i < fruits.length; i++) {
            length[i] = length[i - 1] + fruits[i][1];
        }
        for(int i = 0; i < fruits.length; i++){
            int left = fruits[i][1];
            int right1 = k - Math.abs(startPos - left);
        }
        return 0;
    }
}
