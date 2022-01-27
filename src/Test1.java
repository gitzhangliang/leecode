import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**两数之和
 * @author zhangliang
 * @date 2021/6/24.
 */
public class Test1 {
    public static void main(String[] args) {
        Arrays.stream(new Test1().twoSum(new int[]{2,7,11,15},17)).forEach(System.out::println);
        System.out.println("--------------");
        Arrays.stream(new Test1().t(new int[]{2,7,11,15},17)).forEach(System.out::println);

    }
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            if(n<target){
                int m = target -n;
                int j = this.find(m,nums);
                if(j>=0){
                    return new int[]{i,j};
                }
            }
        }
        return new int[2];
    }
    public int find(int a,int[] arr){
        for(int i=0;i<arr.length;i++){
            int b = arr[i];
            if(a==b){
                return i;
            }
        }
        return -1;
    }

    public int[] t(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i <nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i );
        }
        return new int[0];
    }


}
