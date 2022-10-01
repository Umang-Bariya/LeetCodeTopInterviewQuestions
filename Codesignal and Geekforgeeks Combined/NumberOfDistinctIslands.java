Given a boolean 2D matrix grid of size n * m. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).

Example 1:

Input:
grid[][] = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}}
Output:
1
Explanation:
grid[][] = {{1, 1, 0, 0, 0}, 
            {1, 1, 0, 0, 0}, 
            {0, 0, 0, 1, 1}, 
            {0, 0, 0, 1, 1}}
Same colored islands are equal.
We have 2 equal islands, so we 
have only 1 distinct island.

Example 2:

Input:
grid[][] = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}}
Output:
3
Explanation:
grid[][] = {{1, 1, 0, 1, 1}, 
            {1, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 1}, 
            {1, 1, 0, 1, 1}}
Same colored islands are equal.
We have 4 islands, but 2 of them
are equal, So we have 3 distinct islands.

Your Task:

You don't need to read or print anything. Your task is to complete the function countDistinctIslands() which takes the grid as an input parameter and returns the total number of distinct islands.

Expected Time Complexity: O(n * m)
Expected Space Complexity: O(n * m)

Constraints:
1 ≤ n, m ≤ 500
grid[i][j] == 0 or grid[i][j] == 1




// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int row = grid.length;
        int col = grid[0].length;
        
        Set<List<Integer>> findingUnique = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> movingPath = new ArrayList<>();
                    dfs(grid, i, j, i, j, movingPath, findingUnique);
                    findingUnique.add(movingPath);
                }
            }
        }
        return findingUnique.size();
    }
    
    void dfs(int [][] grid, int i, int j, int startI, int startJ, List<Integer> movingPath, Set<List<Integer>> findingUnique) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return ;
        }
        grid[i][j] = 2;
        movingPath.add(i - startI);
        movingPath.add(j - startJ);
        dfs(grid, i + 1, j, startI, startJ, movingPath, findingUnique);
        dfs(grid, i - 1, j, startI, startJ, movingPath, findingUnique);
        dfs(grid, i, j - 1, startI, startJ, movingPath, findingUnique);
        dfs(grid, i, j + 1, startI, startJ, movingPath, findingUnique);
        
    }
}
