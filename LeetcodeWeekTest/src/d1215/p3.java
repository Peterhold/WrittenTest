package d1215;

/**
 * @author qlk
 * @create 2021-12-15-17:16
 */
public class p3 {
    public void inter(){
//        Scanner scanner = new Scanner(System.in);
//        String in = scanner.nextLine();
        int[] in1 = new int[]{274,179,789,417,293,336,133,334,569,355,813,217,80,933,961,271,294,933,49,980,685,470,186,11,157,889,299,493,215,807,588,464,218,248,391,817,32,606,740,941,505,533,289,306,490};
        int in2 = 996;
        int in3 = 1172;
        minimumRefill(in1,in2,in3);
    }
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int alice = 0;
        int bob = plants.length - 1;
        int maxA = capacityA;
        int maxB = capacityB;
        int ans = 0;
        while(true){
            if(alice != bob){
                if(capacityA >= plants[alice]){
                    capacityA -= plants[alice];
                    alice ++;
                }
                else{
                    capacityA = maxA;
                    ans ++;
                    capacityA -= plants[alice];
                    alice ++;
                }
                if(capacityB >= plants[bob]){
                    capacityB -= plants[bob];
                    bob --;
                }
                else{
                    capacityB = maxB;
                    ans ++;
                    capacityB -= plants[bob];
                    bob --;
                }
            }
            if(alice > bob){
                break;
            }
            if(alice == bob){
                if(capacityA < plants[alice] && capacityB < plants[bob]){
                    ans ++;
                }
                break;
            }
        }
        System.out.println(ans);
        return ans;
    }
}
