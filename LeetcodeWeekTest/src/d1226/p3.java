package d1226;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author qlk
 * @create 2021-12-26-10:58
 * 我没有考虑到时间复杂度，后续为了降低时间复杂度耗费了很长时间
 */
public class p3 {
    public void inner(){
        int[] in1 = new int[]{2,1,3,1,2,3,3};
        getDistances(in1);
    }
    public long[] getDistances(int[] arr) {
        HashMap<Integer, List<Integer>> map1 = new HashMap<>();
        HashMap<Integer,Integer[]> map2 = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(map1.containsKey(num)){
                map1.get(num).add(i);
            }
            else{
                map1.put(num,new ArrayList<Integer>());
                map1.get(num).add(i);
            }
        }
        long[] ans = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list1 = map1.get(arr[i]);
            if(map2.containsKey(arr[i])){
                int n1 = map2.get(arr[i])[1];
                int n2 = list1.size();
                int n3 = map2.get(arr[i])[0];
                ans[i] = ans[n3] + (n1*2 - n2)*(i - n3);
            }else{
                for (int j = 0; j < list1.size(); j++) {
                    ans[i] = ans[i] + Math.abs(i - list1.get(j));
                }
            }
            map2.put(arr[i],new Integer[]{i,map2.getOrDefault(arr[i], new Integer[]{0,0})[1] + 1});
        }
        return ans;
    }
}
