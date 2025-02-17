/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return function(grid,grid.length,0,0);
    }

    private Node function(int [][] grid, int length,int x,int y){
        boolean isLeaf = true;

        for(int i = 0;i<length;i++){
            for(int j=0;j<length;j++){
                if(grid[x][y] != grid[x+i][y+j]){
                    isLeaf = false;
                    break;
                }
            }
        }
        if(isLeaf){
            boolean val  = grid[x][y] == 1 ? true : false;
            return new Node(val,true);
        }

        Node topLeft = function(grid,length/2,x,y);
        Node topRight = function(grid,length/2,x,y+(length/2));
        Node bottomLeft = function(grid,length/2,x+(length/2),y);
        Node bottomRight = function(grid,length/2,x+(length/2),y+(length/2));
        return new Node(true,false,topLeft,topRight,bottomLeft,bottomRight);
    }
}