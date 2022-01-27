import java.util.HashMap;
import java.util.Map;

/**整数转罗马数字
 * @author zhangliang
 * @date 2021/6/29.
 */
public class Test12 {
    public static void main(String[] args) {
        System.out.println(new Test12().intToRoman(999));
    }
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int m = num / 1000;
        if (m >0) {
            builder.append(this.add('M',m));
            num = num-1000*m;
        }
        int d = num/500;
        if (d >0) {
            if(this.startWithNum(num,9)){
                builder.append("CM");
                num = num-900;
            }else{
                builder.append(this.add('D',d));
                num = num-500*d;
            }
        }

        int c = num /100;
        if (c >0) {
            if(this.startWithNum(num,4)){
                builder.append("CD");
                num = num-400;
            }else{
                builder.append(this.add('C',c));
                num = num-100*c;
            }
        }

        int l = num /50;
        if (l >0) {
            if(this.startWithNum(num,9)){
                builder.append("XC");
                num = num-90;
            }else{
                builder.append(this.add('L',l));
                num = num-50*l;
            }
        }

        int x = num /10;
        if (x >0) {
            if(this.startWithNum(num,4)){
                builder.append("XL");
                num = num-40;
            }else{
                builder.append(this.add('X',x));
                num = num-10*x;
            }
        }

        int v = num /5;
        if (v >0) {
            if(this.startWithNum(num,9)){
                builder.append("IX");
                num = num-9;
            }else{
                builder.append(this.add('V',v));
                num = num-5*v;
            }
        }

        int i = num;
        if (i >0) {
            if(this.startWithNum(num,4)){
                builder.append("IV");
            }else{
                builder.append(this.add('I',i));
            }
        }
        return builder.toString();
    }
    private StringBuilder add(Character c,int n){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(c);
        }
        return builder;
    }
    private boolean startWithNum(int num ,int startNum){
        return String.valueOf(num).startsWith(String.valueOf(startNum));
    }

}
