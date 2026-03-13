import java.util.LinkedList;

public class IsBalanced {
    public static void main(String[] args) {
        //String s = "{[()]}";
        //String s = "{[(])}¿";
        String s = "{{[[(()<>)]]}}";

        if (!isBalanced(s)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }


    }

    public static boolean isBalanced(String s) {

        int n = s.length();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i); //current character

            if (c == '{' || c == '(' || c == '[' ||
                    c == '¿' || c == '<') {

                stack.add(c);
                //puts the new element at the front (top) and moves old elements behind
                for (int j = 0; j < stack.size() - 1; j++) {
                    stack.add(stack.remove());
                }

            } else if (c == '}' || c == ')' || c == ']' ||
                    c == '?' || c == '>') {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();    //element on top of stack

                if ((top == '{' && c == '}') ||
                        (top == '(' && c == ')') ||
                        (top == '[' && c == ']') ||
                        (top == '¿' && c == '?') ||
                        (top == '<' && c == '>')) {

                    stack.remove();
                } else {
                    return false;
                }

            }

        }

        return stack.isEmpty();
    }
}

/*
Sources:
https://www.geeksforgeeks.org/dsa/implement-a-stack-using-singly-linked-list/
ChatGPT for Debugging
 */