// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class UniuqeString {
    
    public static boolean isUniqueWithoutAdditionalDS(String str){
        char[] chArr= str.toCharArray();
        Arrays.sort(chArr);  // O(nlogn)
        for(int i=0;i<chArr.length-1;i++){ // O(n)
            if(chArr[i]==chArr[i+1])
                return false;
        }
        return true;
    }
    
    public static boolean isUniqueWithAdditionalDS(String str){
        int MAX_CHAR=256;
        if(str.length()>MAX_CHAR)
            return false;
        
        boolean[] chars = new boolean[MAX_CHAR];
        Arrays.fill(chars,false); // O(n)
        
        for(int i=0;i<str.length()-1;i++){ // O(n)
            int index=(int)str.charAt(i); // ASCII
            if(chars[index]==true)
                return false;
            chars[index]=true;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String s = "asfgdjkha";
        boolean isUnique = false;
        // isUnique = isUniqueWithoutAdditionalDS(s);
        isUnique =  isUniqueWithAdditionalDS(s);
        System.out.println(isUnique);
    }
}