package Graph;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int rottenOranges(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int directions[][] = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        int time = 0;
        while(!q.isEmpty() && fresh>0){
            int size = q.size();
            //process all the rotten oranges in the unit time t
            for(int i=0; i<size; i++){
                int[] orange = q.poll();
                int r = orange[0];
                int c = orange[1];

                for(int dir[] : directions){
                    int new_r = r + dir[0];
                    int new_c = c + dir[1];

                    if(new_r<0 || new_r>=m ||
                        new_c<0 || new_c>=n || grid[new_r][new_c] != 1
                    )
                        continue;
                    
                    grid[new_r][new_c] = 2;
                    fresh--;

                    q.offer(new int[]{new_r, new_c});
                }
            }
            time++;
        }

        return fresh == 0? time : -1;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = rottenOranges(grid);
        System.out.println("Minimum time required: " + result);
    }

}
