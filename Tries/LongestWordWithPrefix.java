public class LongestWordWithPrefix {
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
    public static String ans="";
    public static void longest(StringBuilder st,Node root)
    {
        if(root==null)
        {
            return;
        }
        for(int i=0;i<26;i++)
        {
            if(root.children[i]!=null&&root.children[i].eow)
            {
                st.append((char)(i+'a'));
                if(st.length()>ans.length())
                {
                    ans=st.toString();
                }
                longest(st,root.children[i]);
                st.deleteCharAt(st.length()-1);
            }
        }

    }
    public static Node root = new Node();
    public static void main(String args[])
    {
        String arr[] ={"a","ap","app","appl","appy"};
    }
}
