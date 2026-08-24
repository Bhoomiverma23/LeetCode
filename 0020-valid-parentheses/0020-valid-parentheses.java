import java.util.Stack;

class Solution {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);  // Push opening bracket
            } else {
                if (stack.isEmpty()) {
                    return false;  // No matching opening
                }
                char top = stack.pop();  // Check matching pair
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;  // Wrong pair
                }
            }
        }
        return stack.isEmpty();  // Valid if stack is empty
    }

    public static void main(String[] args) {
        String str = "()";
        if (isValid(str)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
