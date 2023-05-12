// BUG exists; Review again
class Urlify {
    public static void main(String[] args) {
        String input = " Mr John Smith ";
        int len = 13;
        
        String newStr=replace(input,len);
        System.out.print(newStr);
        
    }
    
    //Function to count all empty spaces except spaces before and after the string
    private static int countEmptySpaces(char[] ch){
       
        int count=0;
        for(int i=0;i<ch.length-1;i++){
            if(ch[i]==' ')
                count++;
        }
        return count;
    }
    
    private static char[] leftTrim(char[] ch){
        int spaces=0;
        for(int i=0;i<ch.length-1;i++){
            if(ch[i]==' ')
                spaces++;
            else
                break;
        }
        
        if(spaces==0)
            return ch;
        
        char[] newCh=new char[ch.length-spaces];
        int index=newCh.length-1;
        
        for(int j=ch.length-1;j>=spaces;j--){
            newCh[index--]=ch[j];
        }
        return newCh;
    }
    
    private static char[] rightTrim(char[] ch){
        int spaces=0;
        for(int i=ch.length-1;i>=0;i--){
            if(ch[i]==' ')
                spaces++;
            else
                break;
        }
        
        if(spaces==0)
            return ch;
        
        char[] newCh=new char[ch.length-spaces];
        for(int j=0;j<ch.length-spaces-1;j++){
            newCh[j]=ch[j];
        }
        
        return newCh;
    }
    
    private static String replace(String str,int len){
        char[] ch  = str.toCharArray();
        
         //remove empty spaces at the begining
        char[] leftTrimmedCh=leftTrim(ch);
        //remove empty spaces at the end
        char[] rightTrimmedCh = rightTrim(leftTrimmedCh);
        
        int space_count = countEmptySpaces(rightTrimmedCh); // count all empty spaces
        
        int new_len=len+2*space_count; // for 3 characters - %,2,0
        int index = new_len - 1;
        char[] newCh = new char[new_len];
        System.out.println();
        for(int k=len-1;k>=0;k--){
            if(ch[k] !=' '){
                newCh[index] = ch[k];
                index--;
            }else{
                newCh[index] = '0';
                newCh[index-1] = '2';
                newCh[index-2] = '%';
                index-=3;
            }
        }
        return new String(newCh);
    }
}