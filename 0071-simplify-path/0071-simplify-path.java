class Solution {
    public String simplifyPath(String path) {
        String arr[] = path.split("/");
        Stack<String> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (!arr[i].equals("") && !arr[i].equals(".")) {
                stack.push(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        if (sb.length() == 0) {
            return "/";
        }
        return sb.toString();
    }
}