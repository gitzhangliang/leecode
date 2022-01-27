/**盛最多水的容器
 * @author zhangliang
 * @date 2021/6/29.
 */
public class Test11 {
    public static void main(String[] args) {
        System.out.println(new Test11().maxArea(new int[]{4,3,2,1,4}));
    }
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            int i1 = height[i];
            for (int j = i+1; j < height.length; j++) {
                int i2 = height[j];
                int y = Math.min(i1,i2);
                int x = j-i;
                int a = x*y;
                area = Math.max(area,a);
            }
        }
        return area;
    }

    public int maxArea1(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }

}
