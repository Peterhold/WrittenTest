package d1226;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author qlk
 * @create 2021-12-26-11:39
 * //直接模拟法枚举硬解，通过map记录遍历过的数
 *      我没有考虑到重复数的情况
 *      我没有考虑到k == 0的情况
 */
public class p4 {
    public void inner(){
        int[] in1 = new int[]{8,4,5,1,9,8,6,5,6,9,7,3,8,3,6,7,10,11,6,4};
        recoverArray(in1);
    }
    int[] nums;
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        int k = 0;
        int[] ans = new int[nums.length/2];
        for (int i = 1; i < nums.length; i++) {
            k = nums[i] - nums[0];
            if(k % 2 != 0){
                continue;
            }
            if(ifRight(k/2,ans)){
                break;
            }
            if(i == nums.length - 1){
                k = 100000;
            }
        }
        return ans;
    }
    public boolean ifRight(int k,int[] ans){
        Map<Integer,Integer> map1 = new Hashtable<>();
        int ss = 0;
        for (int i = 0; i < nums.length; i++) {
            map1.put(nums[i],map1.getOrDefault(nums[i],0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map1.get(nums[i]) == 0){
                continue;
            }
            int num = nums[i] + 2 * k;
            if(map1.containsKey(num) && map1.get(num) >= 1){
                map1.put(num,map1.get(num) - 1);
                map1.put(nums[i],map1.get(nums[i]) - 1);
                ans[ss++] = nums[i] + k;
            }
            else{
                return false;
            }
        }
        System.out.println(k);
        return true;
    }
}
