import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class WordFinder {
    static trieNode[] dict = new trieNode[26];
    
    public static class trieNode{
        ArrayList<String> matches = new ArrayList<String>();
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
                tmp[s.charAt(i) - 'a'].matches.add(s);
                tmp = tmp[s.charAt(i) - 'a'].children;
            }
        }
    }
    
    public static void find(String s){
        ArrayList<String> matches = null;

        trieNode[] tmp = dict;
        for(int j=0; j<s.length(); j++){
            if(tmp[s.charAt(j) - 'a'] == null){
                System.out.println("NOT FOUND");
                return;
            }
            else{
                matches = tmp[s.charAt(j) - 'a'].matches;
                tmp = tmp[s.charAt(j) - 'a'].children;
            }
        }
        for(String str : matches){
            System.out.println(str + " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the WordFinder program.");
        System.out.println("Valid commands are:");
        System.out.println("add (string)");
        System.out.println("find (string)");
        System.out.println("Type 'exit' to close");

        String op = "";
        String contact = "";
        while(!op.equals("exit")) {
            System.out.print("Command: ");
            op = in.next();
            if(op.equals("add")){
                contact = in.next();
                add(contact);
            }
            else if(op.equals("find")) {
                contact = in.next();
                find(contact);
            }
        }
    }
}