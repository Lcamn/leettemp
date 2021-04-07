package editor.cn;

//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
// 返回一个表示每个字符串片段的长度的列表。
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 457 👎 0

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {

        Solution solution = new PartitionLabels().new Solution();
        solution.partitionLabels("ababcbacadefegdehijhklij");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] last = new int[26];
            int len = S.length();
            for (int i = 0; i < len; i++) {
                last[S.charAt(i) - 'a'] = i;
            }

            int start = 0, end = 0;
            ArrayList<Integer> part = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                end = Math.max(end, last[S.charAt(i) - 'a']);
                if (end == i){
                    part.add(end - start + 1);
                    start = end + 1;
                }
            }
        return part;









           /* int[] last = new int[26];
            int length = S.length();
            for (int i = 0; i < length; i++) {
                last[S.charAt(i) - 'a'] = i;
            }
            //记录每个字母 最后一次出现的下标
            List<Integer> partition = new ArrayList<>();
            int start = 0, end = 0;
            for (int i = 0; i < length; i++) {
                end = Math.max(end, last[S.charAt(i) - 'a']);
                if (i == end) {
                    partition.add(end - start + 1);
                    start = end + 1;
                }
            }
            return partition;*/
            //return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}