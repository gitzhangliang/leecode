/**最长回文子串
 * @author zhangliang
 * @date 2021/6/25.
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(new Test5().longestPalindrome("a"));
    }
    public String longestPalindrome(String s) {
        int max = 0;
        String longs = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String c = s.substring(i,j);
                if(this.isPalindrome(c) && c.length()>max){
                    longs = c;
                    max = c.length();
                }
            }

        }
        return longs;
    }
    public boolean isPalindrome(String c){
        for (int i = 0; i < c.length()/2; i++) {
            if(c.charAt(i)!=c.charAt(c.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
