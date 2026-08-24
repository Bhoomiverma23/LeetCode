import java.util.Stack;
class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);  
            } else {
                if (stack.isEmpty()) {
                    return false;  
                }
                char top = stack.pop();  
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;  
                }
            }
        }
        return stack.isEmpty(); 
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