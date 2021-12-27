package d1215;

import java.util.Scanner;

/**
 * @author qlk
 * @create 2021-12-15-17:00
 */
public class p2 {
    public void inter(){
//        Scanner scanner = new Scanner(System.in);
//        String in = scanner.nextLine();
        int[] in = new int[]{4,-2,-3,4,1};
        getAns(in);
    }

    private long getAns(int[] in) {
        int n = in.length;
        int[][] maxNum = new int[n][n];
        int[][] minNum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxNum[i][j] = 0;
                minNum[i][j] = 0;
                if(i == j){
                    maxNum[i][j] = in[i];
                    minNum[i][j] = in[j];
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int num = in[j];
                int maxnow = maxNum[i][j- 1];
                int minnow = minNum[i][j- 1];
                if(maxnow < num){
                    maxNum[i][j] = num;
                }
                else{
                    maxNum[i][j] = maxNum[i][j - 1];
                }
                if(minnow > num){
                    minNum[i][j] = num;
                }
                else{
                    minNum[i][j] = minNum[i][j - 1];
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = ans + maxNum[i][j] - minNum[i][j];
            }
        }
        System.out.println(ans);
        return ans;
    }
}
