import java.util.HashSet;
import java.util.Set;

/**最长公共前缀
 * @author zhangliang
 * @date 2021/6/28.
 */
public class Test14 {
    public static void main(String[] args) {
        System.out.println(new Test14().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        int min= 1000000000;
        for (String str : strs) {
            min = Math.min(min,str.length());
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < min; i++) {
            String same = this.same(i, strs);
            if (same!=null) {
                builder.append(same);
            }else {
                break;
            }
        }
        return builder.toString();
    }

    public String same(int i,String[] strs){
        Set<Character> set = new HashSet<>();
        for (String str : strs) {
            set.add(str.charAt(i));
        }
        return set.size() != 1?null:strs[0].charAt(i)+"";
    }
}
