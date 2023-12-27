import java.util.*;
public class TriesDemo {
    static class Node{
        Node children[] =new Node[26];
        boolean eow=false;
        Node()
        {
            for(int i =0;i<26;i++)
            {
                children[i] =null;
            }
        }
    }
    public static boolean search(String word)
    {
        Node curr = root;
        for(int i =0;i<word.length();i++)
        {
            int idx =word.charAt(i)-'a';
            if(curr.children[idx]==null)
            {
                return false;
            }
            curr = curr.children[idx];
        }
        if(curr.eow==true)
        return true;
        else
            return false;
    }
    public static boolean wordbreak(String word)
    {if(word.length()==0)
        return true;
        for(int i =1;i<=word.length();i++)
        {
            if(search(word.substring(0,i))&&wordbreak(word.substring(i)))
            {
                return true;
            }
        }
        return false;
    }
    public static ArrayList<String> traversal(Node curr,StringBuilder str,ArrayList<String> arr)
    {
        if(curr.eow==true)
        {
            arr.add(str.toString());

        }


        for(int i=0;i<26;i++)
        {
            if(curr.children[i]!=null)
            {
                str.append((char)(i+'a'));

                traversal(curr.children[i],str,arr);
                str.deleteCharAt(str.length()-1);
            }


        }
        return arr;
    }
    public static void insert(String word)
    {
        Node curr = root;
        for(int i=0;i<word.length();i++)
        {
            int idx =word.charAt(i)-'a';
            if (curr.children[idx]==null) {
                 curr.children[idx] =new Node();

            }
            curr =curr.children[idx];
        }
        curr.eow =true;

    }
    public static Node root = new Node();
    public static void main(String args[])
    {
        String word[] ={"ally","apple","open","track"};
        for(int i =0;i<word.length;i++)
        {
            insert(word[i]);
        }
        System.out.println(search("apple"));
        System.out.println(wordbreak("appleallyopn"));
        /*
        ArrayList<String> arr=new ArrayList<>();
         arr=traversal(root,new StringBuilder(),arr);
        for(String st :arr)
        {
            System.out.println(st);
        }
*/
    }
}
