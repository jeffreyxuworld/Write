package com.leixu.write.leetcode;

import com.leixu.write.kotlin.singleton.LazySingleton;

/**
 * Created by Lei on 2017/11/2.
 *
 * Description

    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

     The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

    判断括号匹配是否正确，很明显，我们可以用栈来解决这个问题，当出现左括号的时候入栈，当遇到右括号时，判断栈顶的左括号是否何其匹配，不匹配的话直接返回false即可，最终判断是否空栈即可，
    这里我们可以用数组模拟栈的操作使其操作更快，有个细节注意下top = 1;，从而省去了之后判空的操作和top - 1导致数组越界的错误。
 *
 */

public class Solution020 {

    public boolean isValid(String s){
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for(char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if(c == ')' && stack[--top] != '('){
                return false;
            } else if(c == ']' && stack[--top] != '['){
                return false;
            } else if(c == '}' && stack[--top] != '{'){
                return false;
            }


        }

        return top == 1;

    }


    public static void main(String[] args) {
        Solution020 solution = new Solution020();
        System.out.println(solution.isValid("()[]{}({[]})"));
        System.out.println(solution.isValid("(])]"));

//        SimpleSingleton.INSTANCE.test();

//        LazySingleton.Companion.getInstance().getB();

    }



}
