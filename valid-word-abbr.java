class Solution{
    public boolean valinWordAbbreviation(String word,String abbr){
if(word==null||abbr==null){
    return false;
}
int a=0;
int b=0;
while(a<word.length()&&b<abbr.length())
{
    if(Character.isDigit(abbr.charAt(b)))
    {
        if(abbr.charAt(b)=='0')
        {
            return false;
        }
        int total=0;
        while(b<abbr.length()&&Character.isDigit(abbr.charAt(b))){
            total=total*10+abbr.charAt(b)-'0';
            b++;
        }
        a+=total;
    }else{
        if(word.charAt(a)!=abbr.charAt(b))
        {
            return false;
        }
        a++;
        b++;

    }
}
   return a==word.length()&&b==abbr.length()&& b==abbr.length();
   
 }
}