package editor.cn;

//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，
// 该路径同时满足下述要求：
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 
// 👍 90 👎 0

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println();
        //grid [xy[0]] [xy[1]];
        solution.shortestPathBinaryMatrix(grid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
     class Solution {
        private  int[][] directions = {{0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        private int row, col;
        public int shortestPathBinaryMatrix(int[][] grid) {

            row = grid.length;
            col = grid[0].length;
            if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;
            Queue<int[]> pos = new LinkedList<>();
            grid[0][0] = 1; // 直接用grid[i][j]记录从起点到这个点的最短路径长。按照题意 起点也有长度1
            pos.add(new int[]{0, 0});
            while (!pos.isEmpty() && grid[row - 1][col - 1] == 0) { // 求最短路径 使用BFS
                int[] xy = pos.remove();
                int preLength = grid[xy[0]][xy[1]]; // 当前点的路径长度
                for (int i = 0; i < 8; i++) {//遍历八个方向
                    int newX = xy[0] + directions[i][0];
                    int newY = xy[1] + directions[i][1];
                    if (inGrid(newX, newY) && grid[newX][newY] == 0) {
                        pos.add(new int[]{newX, newY});
                        grid[newX][newY] = preLength + 1; // 下一个点的路径长度要+1
                    }//
                }
            }
            return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1]; // 如果最后终点的值还是0，说明没有到达
        }

        private boolean inGrid(int x, int y) {
            return x >= 0 && x < row && y >= 0 && y < col;//判断是否越界
        }
    }

    /*
        if (grids == null || grids.length == 0 || grids[0].length == 0) {
            return -1;
        }
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                if (grids[cr][cc] == 1) {
                    continue;
                }
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }
                grids[cr][cc] = 1; // 标记
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;

    定义队列;
    定义备忘录，用于记录已经访问的位置；
    判断边界条件，是否能直接返回结果的。
    将起始位置加入到队列中，同时更新备忘录。
    while (队列不为空) {
        获取当前队列中的元素个数。
        for (元素个数) {
            取出一个位置节点。
            判断是否到达终点位置。
            获取它对应的下一个所有的节点。
            条件判断，过滤掉不符合条件的位置。
            新位置重新加入队列。
        }
    }
*/


//leetcode submit region end(Prohibit modification and deletion)

}