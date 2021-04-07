package editor.cn;

//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
// （例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，
// 你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
//
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
// Related Topics 贪心算法 二分查找 动态规划 
// 👍 399 👎 0

public class IsSubsequence {
    public static void main(String[] args) {

        Solution solution = new IsSubsequence().new Solution();
        String s = "abc";
        String t = "ahbgdc";
        solution.isSubsequence(s, t);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            //s 是否 为 t 的子序列
            /*int i = 0, j = 0;int k = 0;
            for (; i < t.length() && j < s.length(); ) {
                if (s.charAt(j) == t.charAt(i)) {
                    System.out.println(s.charAt(j));
                    i++;
                    j++;
                    k++;
                } else {
                    i++;
                }
            }
            return k == s.length();*/
            //s 是否为t的子序列
            //  s: a b c   // t: a c b b c f
            int index = -1;
            for (char c : s.toCharArray()){
                index = t.indexOf(c,index +1);
                if (index == -1){
                    return false;
                }
            }
            return  true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}