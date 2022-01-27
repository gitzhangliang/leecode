import java.util.Stack;

/**有效的括号
 * @author zhangliang
 * @date 2021/6/29.
 */
public class Test20 {
    public static void main(String[] args) {
        System.out.println(new Test20().isValid("]"));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(c=='('){
                stack.push(')');
            }else if(stack.isEmpty() || !stack.pop().equals(c)){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
