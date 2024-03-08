import java.util.*;
/**
 * floodfill
 */
public class floodfill {
    public static void helper(int[][] img,int sr,int sc,int color,int orgcolor,boolean vis[][])
    {
        if(sr>=img.length ||sr<0||sc<0||sc>=img[0].length||img[sr][sc]!=orgcolor||vis[sr][sc])
        {
            return;

        }
        img[sr][sc]=color;
        vis[sr][sc]=true;
        //left
        helper(img, sr, sc-1, color, orgcolor,vis);
        //right
        helper(img, sr, sc+1, color, orgcolor,vis);
        //up
        helper(img, sr-1, sc, color, orgcolor,vis);
        //down
        helper(img, sr+1, sc, color, orgcolor,vis);
    }

    public static int[][] floodFill(int[][] img,int sr,int sc,int color )
    {
        boolean vis[][] =new boolean[img.length][img[0].length];
        helper(img,sr,sc,color,img[sr][sc],vis);
        return img;

    }
    public static void main(String[] args) {
        int[][] img={{1,1,1},
                {1,1,0},
                {1,0,1}};
        floodFill(img,1,1,3);
        for(int i=0;i<img.length;i++)
        {
            for(int j=0;j<img[0].length;j++)
            {
                System.out.print(img[i][j]+" ");

            }
            System.out.println();
        }       
    }
}