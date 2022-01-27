/**整数反转
 * @author zhangliang
 * @date 2021/6/29.
 */
public class Test7 {
    public int reverse(int x) {
        int r = 0;
        while (x != 0){
            if(r > Integer.MAX_VALUE/10 || Integer.MIN_VALUE/10 > r){
                return 0;
            }
            int d = x%10;
            r = r*10+d;
            x/=10;
        }
        return r;
    }
}
