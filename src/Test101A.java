import entity.TreeNode;

/**
 * @author zhangliang
 * @date 2021/7/2.
 */
public class Test101A {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new Test101A().a(new int[]{1,1,2,3,3,4}));
    }

    public int a(int[] nums) {
        int start=0;
        int num = 1;
        for (int end = 1; end < nums.length; end++) {
            if(nums[start] != nums[end]){
                num++;
                start = end;
            }
        }
        return num;
    }
    public int aa(int[] nums) {
        int start=0;
        int num = 1;
        for (int end = 1; end < nums.length; end++) {
            if(nums[start] != nums[end]){
                nums[start+1] = nums[end];
                num++;
                start++;
            }
        }
        return num;
    }
}
