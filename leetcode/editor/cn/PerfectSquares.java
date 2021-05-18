package editor.cn;

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 104 
// 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 799 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PerfectSquares {
    public static void main(String[] args) {

        Solution solution = new PerfectSquares().new Solution();
        System.out.println(solution.numSquares(9));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            //广度优先遍历
            List<Integer> squares = generateSquares(n);
            Queue<Integer> queue = new LinkedList<>();
            boolean[] marked = new boolean[n + 1];
            queue.add(n);
            marked[n] = true;
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                level++;
                while (size-- > 0) {
                    int cur = queue.poll();
                    for (int s : squares) {
                        int next = cur - s;
                        if (next <   0) {
                            break;
                        }
                        if (next == 0) {
                            //
                            return level;
                        }
                        if (marked[next]) {
                            continue;
                        }
                        marked[next] = true;
                        queue.add(next);
                    }
                }
            }
            return n;

        }


        /**
         * 生成小于 n 的平方数序列
         *
         * @return 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, ..
         */
        List<Integer> generateSquares(int n) {
            List<Integer> squares = new ArrayList<>();
            int square = 1;
            int diff = 3;
            while (square <= n) {
                squares.add(square);
                square += diff;
                diff += 2;
            }
            return squares;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}