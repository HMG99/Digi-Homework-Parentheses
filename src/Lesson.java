import java.util.Stack;

public class Lesson {
    public static void main(String[] args) {

        String str = "asdf[asd{asdfa}adf]adf()adf({asdf}asdf)";

        boolean result = isValid(str);
        System.out.println(result);

    }

    private static boolean isValid(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (stack.isEmpty() && (c == '}' || c == ')' || c == ']')) {
                return false;
            }

            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                switch (c) {
                    case '}':
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else return false;
                        break;
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else return false;
                        break;
                    case ']':
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else return false;
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}
