import java.util.*;
 class Solution {
    public int calculate(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int number = 0;
        char operator = '+';
        for (int index = 0; index < s.length(); index++) {
            char charValue = s.charAt(index);
            if (Character.isDigit(charValue)) {
                number = (number * 10) + (charValue - '0');
            }
          if ((!Character.isDigit(charValue) && charValue != ' ') || index == s.length() - 1) {
                if (charValue == '(') {
                 operatorStack.push(operator);
                    operator = '+';
                    number = 0;
                } else {
                 if (operator == '+') {
                        numberStack.push(number);
                    } else if (operator == '-') {
                        numberStack.push(-number);
                    } else if (operator == '*') {
                        numberStack.push(numberStack.pop() * number);
                    } else if (operator == '/') {
                        numberStack.push(numberStack.pop() / number);
                    }
                    if (charValue == ')') {
                        int subResult = 0;
                         while (!numberStack.isEmpty() && (operatorStack.isEmpty() || operatorStack.peek() != '(')) {
                            subResult += numberStack.pop();
                        }
                        if (!operatorStack.isEmpty()) {
                            operatorStack.pop();
                        }
                         if (!operatorStack.isEmpty()) {
                            char prevOperator = operatorStack.pop();
                            if (prevOperator == '+') {
                                numberStack.push(subResult);
                            } else if (prevOperator == '-') {
                                numberStack.push(-subResult);
                            } else if (prevOperator == '*') {
                                numberStack.push(numberStack.pop() * subResult);
                            } else if (prevOperator == '/') {
                                numberStack.push(numberStack.pop() / subResult);
                            }
                        } else {
                            numberStack.push(subResult);
                        }
                    } else {
                        
                        operator = charValue;
                    }
                    number = 0;
                }
            }
        }
        int sum = 0;
        while (!numberStack.isEmpty()) {
            sum += numberStack.pop();
        }
        return sum;
    }
}