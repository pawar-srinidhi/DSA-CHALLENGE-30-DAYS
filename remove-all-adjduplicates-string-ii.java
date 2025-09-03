class Solution {
    public String removeDuplicates(String A, int k) {
        int N = A.length();
        StringBuilder sb=new StringBuilder();
        Stack<Integer> countStack=new Stack<Integer>();
        for(int i=0;i < N;i++)
           {
            char currentChar=A.charAt(i);
            int size=sb.length();
            if(size>0&& currentChar==sb.charAt(size-1))
            {
                int count=countStack.pop();
                if(count+1<k)
                {
                    countStack.push(count+1);
                    sb.append(currentChar);
                }
                else
                {
                    sb.setLength(size-k+1);
                }
            }
            else
            {
                sb.append(currentChar);
                countStack.push(1);
            }
           }
           return sb.toString();
    }
}