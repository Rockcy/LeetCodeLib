package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author ：Rock-Cao
 * @date ：Created at 2020/1/17 23:50
 * @modified By：
 * @version: 1.0$
 */
public class ValidParentheses_20 {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        } else if (s.length() % 2 != 0) {
            return false;
        } else {
            HashMap<Character, Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[', ']');
            map.put('{', '}');
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    stack.push(c);
                    if (stack.size() > s.length() / 2) {
                        return false;
                    }
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (c != map.get(stack.pop())) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
