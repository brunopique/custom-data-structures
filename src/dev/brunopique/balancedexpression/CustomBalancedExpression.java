package dev.brunopique.balancedexpression;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CustomBalancedExpression {
    private final List<Character> openingBrackets = Arrays.asList('(', '[');
    private final List<Character> closingBrackets = Arrays.asList(')', ']');

    // when reach a closing bracket, we need to go back to find the opening one

    // if it's an opening bracket we push it to the top of the stack
    // when we get to the closing bracket we pop it and compare it to opening
    // other wise return false

    public boolean isBalanced(String string) {

        Stack<Character> stack = new Stack<>();
        char openingBracket;

        for (char ch : string.toCharArray()) {

            if (isOpeningBracket(ch))
                stack.push(ch);
            else if (isClosingBracket(ch)) {
                if (stack.isEmpty())
                    return false;
                else {
                    openingBracket = stack.pop();
                    if (!isClosingBracketMatched(openingBracket, ch))
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }


    private boolean isOpeningBracket(char ch) {
        return openingBrackets.contains(ch);
    }

    private boolean isClosingBracket(char ch) {
        return closingBrackets.contains(ch);
    }

    // openingBrackets[] = 0: ')', 1: ']'
    // closingBrackets[] = 0: ')', 1: ']'
    // if 'openingBracket' and 'closingBracket' match array position, we have a match
    private boolean isClosingBracketMatched(char openingBracket, char closingBracket) {
        return openingBracket == '(' && closingBracket != ')'
                || openingBracket == '[' && closingBracket != ']';
    }
}
