import java.util.*;
public class PrefixProblem {
    static class Node{
    Node childern[] =new Node[26];
    boolean eow =false;
    int freq=0;
    Node(){
        for(int i=0;i<26;i++)
        {
            childern[i]=null;
        }
    }
    }
    public static void insert(String word)
    {
        Node curr  =  root;
        for(int i =0;i<word.length();i++)
        {
            int idx =word.charAt(i)-'a';
            if(curr.childern[idx]==null)
            {
                curr.childern[idx]=new Node();
            }
            curr =curr.childern[idx];
            curr.freq++;
        }
        curr.eow=true;
    }public static String prefix(String word)
    {
        StringBuilder st =new StringBuilder();
        Node curr = root;
        for(int i=0;i<word.length();i++)
        {
            int idx = word.charAt(i)-'a';
            st.append(word.charAt(i));
            if(curr.childern[idx].freq==1)
            {
                return st.toString();
            }
            curr =curr.childern[idx];

        }
        return word;
    }
    public static Node root =new Node();
    public static void main(String args[])
    {
        String arr[] ={"zebra","dog","duck","dove"};
        for(int i =0;i<arr.length;i++)
        {
            insert(arr[i]);
        }
        ArrayList<String> ar = new ArrayList<>();
        for(String st :arr)
        {
            ar.add(prefix(st));
        }
        for(int i =0;i<ar.size();i++)

        {
            System.out.println(ar.get(i));
        }

    }

}
