/**回文数
 * @author zhangliang
 * @date 2021/6/28.
 */
public class Test9 {
    public static void main(String[] args) {
        System.out.println(new Test9().isPalindrome(121));
    }
    public boolean isPalindrome(int x) {
        String y  = String.valueOf(x);
        StringBuilder builder = new StringBuilder(y);
        StringBuilder reverse = new StringBuilder(y).reverse();
        return builder.toString().equals(reverse.toString());
    }
}
