import java.util.LinkedList;

public class DecodeString {

    public static void main(String[] args) {

        //String s = "3[a]";
        //String s = "3[a]2[bc]";
        //String s = "3[a2[c]]";
        String s = "2[abc]3[cd]ef";

        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {

        int n = s.length();

        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<String> strings = new LinkedList<>();

        int currentNum = 0;
        String currentString = "";

        for(int i = 0; i < n; i++) {

            char c = s.charAt(i); //current character

            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c -'0');

            } else if (c == '[') {
                nums.push(currentNum);
                strings.push(currentString);

                currentNum = 0;
                currentString = "";


            } else if (c == ']') {
                int repeat = nums.pop();
                String prevString = strings.pop();
                String temp = "";

                for (int j = 0; j < repeat; j++) {
                    temp += currentString;
                }
                currentString = prevString + temp;

            } else { //if c is a regular letter
                currentString += c;

            }
        }

        return currentString;
    }
}

/*
Sources
https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html
ChatGPT for character to digit and debugging else if(c == ']')
 */