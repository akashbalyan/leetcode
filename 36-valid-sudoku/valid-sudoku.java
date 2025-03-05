class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        //check rows
        for(int i=0;i<9;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]!= '.' && set.contains(board[i][j])){
                    return false;
                }else{
                    set.add(board[i][j]);
                }
            }
        }

        //check columns
        for(int i=0;i<9;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[j][i]!= '.' && set.contains(board[j][i])){
                    return false;
                }else{
                    set.add(board[j][i]);
                }
            }
        }

        //check sub boxes

        for(int i=0;i<=6;i=i+3){
            for(int j=0;j<=6;j=j+3){
            
                HashSet<Character> set;
                int r = i;
                int c = j;
                //firrst row
                set = new HashSet<Character>();
                for(int n=c;n<c+3;n++){
                    if(board[r][n]!= '.' && set.contains(board[r][n])){
                        return false;
                    }else{
                        set.add(board[r][n]);
                    }
                }
                // second row
                //set = new HashSet<Character>();
                for(int n=c;n<c+3;n++){
                    if(board[r+1][n]!= '.' && set.contains(board[r+1][n])){
                        return false;
                    }else{
                        set.add(board[r+1][n]);
                    }
                }
                // third row
                //set = new HashSet<Character>();
                for(int n=c;n<c+3;n++){
                    if(board[r+2][n]!= '.' && set.contains(board[r+2][n])){
                        return false;
                    }else{
                        set.add(board[r+2][n]);
                    }
                }
            }
        }
        return true;
    }
}