package d1215;

import java.util.*;

/**
 * @author qlk
 * @create 2021-12-15-16:18
 */
public class p1 {
    public void inter(){
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        getAns(in);
    }
    public int getAns(String in){
        char[] color =  new char[in.length()/2];
        int[] location = new int[in.length()/2];
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            if(i % 2 == 0){
                color[i/2] = c;
            }else{
                location[i/2] = c - '0';
            }
        }
        List<Map<Character,Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<Character,Integer> map = new Hashtable<>();
            list.add(map);
        }
        for (int i = 0; i < color.length; i++) {
            int loc = location[i];
            char col = color[i];
            list.get(loc).put(col,1);
        }
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            Map<Character,Integer> map = list.get(i);
            if(map.containsKey('R')&&map.containsKey('G')&&map.containsKey('B')){
                ans ++;
            }
        }
//        System.out.println(location);
//        System.out.println(color);
        System.out.println(ans);
        return ans;
    }

}
