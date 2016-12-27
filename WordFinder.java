import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class WordFinder {
    static trieNode[] dict = new trieNode[26];
    
    public static class trieNode{
        int val;
        trieNode[] children = new trieNode[26];
    }
        
    public static void add(String s){
        if(s == null){
            return;
        }
        else{
            trieNode[] tmp = dict;
            for(int i=0; i<s.length(); i++){
                if(tmp[s.charAt(i) - 'a'] == null){
                    tmp[s.charAt(i) - 'a'] = new trieNode();
                }
                tmp[s.charAt(i) - 'a'].val++;
                tmp = tmp[s.charAt(i) - 'a'].children;
            }
        }
    }
    
    public static void find(String s){
        int numMatches = 0;
        trieNode[] tmp = dict;
        for(int j=0; j<s.length(); j++){
            if(tmp[s.charAt(j) - 'a'] == null){
                System.out.println(0);
                return;
            }
            else{
                numMatches = tmp[s.charAt(j) - 'a'].val;
                tmp = tmp[s.charAt(j) - 'a'].children;
            }
        }
        System.out.println(numMatches);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if(op.equals("add")){
                add(contact);
            }
            else{
                find(contact);
            }
        }
    }
}