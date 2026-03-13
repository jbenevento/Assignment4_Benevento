import java.util.LinkedList;

public class InfixToPostfix {

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";

        System.out.println(infixToPostfix(s));
    }

    public static String infixToPostfix(String s) {

        int n = s.length();

        LinkedList<Character> stack = new LinkedList<>();

        String output = "";

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);   //current character

            if (Character.isLetterOrDigit(c)) {
                output += c;

            } else if (c == '(') {
                stack.push(c);


            } else if (c == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    output += stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }

            } else {
                while ((!stack.isEmpty() && stack.peek() != '('
                        && precedence(stack.peek()) >= precedence(c))) {
                    output += stack.pop();
                }
                stack.push(c);

            }
        }

        while (!stack.isEmpty()) {
            output += stack.pop();
        }

        return output;
    }

    public static int precedence(char op) {
        switch (op) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

}
/*
Sources
https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html
https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
https://www.geeksforgeeks.org/dsa/convert-infix-expression-to-postfix-expression/
https://stackoverflow.com/questions/35914209/infix-to-postfix-conversion-in-java
ChatGPT for debugging
 */