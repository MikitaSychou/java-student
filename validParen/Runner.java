import java.util.Stack;

public class Runner {

    // Valid Parentheses

    //    Write a function that takes a string of parentheses,
    //    and determines if the order of the parentheses is valid.
    //    The function should return true if the string is valid, and false if it's invalid.
    //
    //    Examples
    //        "()"              =>  true
    //        ")(()))"          =>  false
    //        "("               =>  false
    //        "(())((()())())"  =>  true

    public static void main(String[] args) {
        boolean isValid = validParentheses("()");
        System.out.println(isValid);
    }

    public static boolean validParentheses(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        if (st.isEmpty()) {
            return true;
        }

        return false;
    }
}
