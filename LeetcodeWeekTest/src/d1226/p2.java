package d1226;

import javax.sound.midi.Soundbank;

/**
 * @author qlk
 * @create 2021-12-26-10:39
 */
public class p2 {
    public void inner(){
        int in1 = 3;
        int[] in2 = new int[]{0,1};
        String in3 = "RRDDLU";
        executeInstructions(in1,in2,in3);
    }
    int max;
    public int[] executeInstructions(int n, int[] startPos, String s) {
        max = n;
        int[] ans = new int[s.length()];
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            int x1 = startPos[1];
            int y1 = startPos[0];
            int ans0 = 0;
            for (int j = i; j < ca.length; j++) {
                char c = ca[j];
                switch (c){
                    case 'R':x1 = x1 + 1;break;
                    case 'U':y1 = y1 - 1;break;
                    case 'D':y1 = y1 + 1;break;
                    case 'L':x1 = x1 - 1;break;
                }
                if(!ifOut(x1,y1)){
                    break;
                }
                else{
                    ans0 ++;
                }
            }
            ans[i] = ans0;
        }
        //System.out.println(ans);
        return ans;
    }

    public boolean ifOut(int x,int y){
        if(x < 0 || x >= max || y < 0 || y >= max){
            return false;
        }
        return true;
    }


}
