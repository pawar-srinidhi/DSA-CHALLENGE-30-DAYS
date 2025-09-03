class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(char c: s.toCharArray()){
            if(c == '('){
                stack.push(0);
            }else{
                int res = stack.pop();
                if(res == 0)
                    res = 1;
                else
                    res = 2*res;
                
                // stack.top += res;
                int elem = stack.pop();
                elem += res;
                stack.push(elem);
            }
        }
        
        return stack.peek();
    }
}