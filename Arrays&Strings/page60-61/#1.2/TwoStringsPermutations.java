// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class TwoStringsPermutations {
    public static void main(String[] args) {
        String s1="cake";
        String s2="eakc";
        
        // if(isPermutationWithSorting(s1, s2)){
        if(isPermutationWithoutSorting(s1, s2)){
            System.out.println(s2+ " - is a permutation of - " + s1);
        }else{
            System.out.println(s2+ " - is a not permutation of - " + s1);
        }
    }
    
    // With using sorting method 
    // Time complexity = O(nlogn)
    // Space Complexity = O(n)
    // Auxillary Space Complexity = O(1)
    public static boolean isPermutationWithSorting(String s1, String s2){
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();

        Arrays.sort(ch1); //O(nlogn)
        Arrays.sort(ch2); //O(nlogn)
        
        for(int i=0;i<ch1.length;i++){ //O(n)
            if(ch1[i]!=ch2[i])
                return false;
        }
        
        return true;
    }
    
    // Without using sorting method 
    // Time complexity = O(3n)~O(n) 
    // Space Complexity = O(256) ~ O(n)
    // Auxillary Space Complexity = O(n)
    public static boolean isPermutationWithoutSorting(String s1, String s2){
        
        if(s1.length()!=s2.length()){
            return false;
        }
        
        int MAX_CHARS=256;
        int[] ch1 = new int[MAX_CHARS];
        int[] ch2 = new int[MAX_CHARS];
        
        for(int i=0;i<s1.length();i++){ //O(n)
            int idx=(int)s1.charAt(i);
            ch1[idx]++;
        }
        
        for(int i=0;i<s2.length();i++){ //O(n)
            int idx=(int)s2.charAt(i);
            ch2[idx]++;
        }
        
        for(int i=0; i<s1.length();i++){ //O(n)
            int idx=(int)s1.charAt(i);
            if(ch1[idx]!=ch2[idx])
                return false;
        }

        return true;
    }
}