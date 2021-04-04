package dev.brunopique.stringreverser;

import java.util.Optional;
import java.util.Stack;

public class CustomStringReverser {

    public static String reverse(Optional<String> stringOpt) {

        String string = stringOpt.orElseThrow();

        Stack<Character> stack = new Stack<>();

        for (char ch : string.toCharArray())
            stack.push(ch);

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty())
            stringBuilder.append(stack.pop());

        return  stringBuilder.toString();
    }
}
