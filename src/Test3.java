import java.util.*;

/**无重复字符的最长子串
 * @author zhangliang
 * @date 2021/6/25.
 */
public class Test3 {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(new Test3().t1("abac"));
        System.out.println(System.currentTimeMillis()-l);

    }
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <s.length(); j++) {
                Character current = s.charAt(j);
                if (list.contains(current)) {
                    max = Math.max(max, list.size());
                    list = new ArrayList<>();
                    break;
                }else{
                    list.add(current);
                }
            }
            max = Math.max(max, list.size());

        }
        return max;
    }
    public int t1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = map.get(alpha);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }



    public int t(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
