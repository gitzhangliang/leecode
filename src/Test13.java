import java.util.HashMap;
import java.util.Map;

/**罗马数字转整数
 * @author zhangliang
 * @date 2021/6/29.
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。

给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class Test13 {
    private int getNum(Character character){
        Map<Character,Integer> map = new HashMap<>(16);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map.get(character);
    }
    public int romanToInt(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = this.getNum(s.charAt(i));
            if(i<s.length()-1 && num<this.getNum(s.charAt(i+1)) ){
                n-=num;
            }else{
                n+=num;
            }
        }
        return n;
    }
}
