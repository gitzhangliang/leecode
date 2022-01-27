import java.util.ArrayList;
import java.util.List;

/**Z 字形变换
 * @author zhangliang
 * @date 2021/6/29.
 */
public class Test6 {
    public static void main(String[] args) {
        System.out.println(new Test6().convert("PAYPALISHIRING", 3));
        System.out.println(new Test6().convert1("PAYPALISHIRING", 3));
    }
    public String convert(String s, int numRows) {
        Character[][] c = new Character[s.length()][numRows];
        int a= 0;
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            for (; j < numRows; j++) {
                if(a == s.length()){
                    break;
                }
                c[i][j] = s.charAt(a);
                a++;
            }
            j--;
            j--;
            for (;j>0; j--) {
                if(a == s.length()){
                    break;
                }
                i++;
                c[i][j] = s.charAt(a);
                a++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int y= 0; y < numRows; y++) {
            for (int x = 0; x < s.length(); x++) {
                builder.append(c[x][y] == null?"":c[x][y]+"");
            }
        }
        return builder.toString();
    }
    public String convert1(String s, int numRows) {
        List<StringBuilder> rows = new ArrayList<>();
        int num = Math.min(s.length(),numRows);
        for (int i = 0; i < num; i++) {
            rows.add(new StringBuilder());
        }
        int row = 0;
        int next = -1;
        for (Character c:s.toCharArray()){
            rows.get(row).append(c);
            if (row == 0 || row == num-1){
                next = -next;
            }
            row+=next;
        }
        StringBuilder ss = new StringBuilder();
        for (StringBuilder builder : rows) {
            ss.append(builder);
        }
        return ss.toString();
    }
}
