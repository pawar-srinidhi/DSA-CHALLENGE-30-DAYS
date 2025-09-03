class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(st.isEmpty()== false && st.peek()==ch){
                st.pop();
            }else{
                st.push(ch);
            }
        }

        StringBuilder ans=new StringBuilder();
        while(st.isEmpty()==false){
   ans.append(st.pop());

        }
     
        ans.reverse();
       return  ans.toString();
    }
}