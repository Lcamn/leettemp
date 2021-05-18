package editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1770 👎 0

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    //2021-05-08 09:33:01	
    public static void main(String[] args) {
    
        Solution solution = new GenerateParentheses().new Solution();
        
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        int left = n;
        int right = n;
        backTrack(left,right,sb);

        return res;
    }
    public void backTrack(int left,int right,StringBuilder sb){
        //如果小于0就return
        if(left < 0 || right < 0){
            return;
        }
        //合法括号,左边括号数目一定大于右边的数目,当左边括号剩余的多的时候
        //说明不合法,就return出去
        if(left > right){
            return;
        }
        //符合条件,添加进去
        if(left == 0 && right == 0){
            res.add(new String(sb));
        }
        //选择
        sb.append('(');
        //递归
        backTrack(left - 1,right,sb);
        //撤销选择
        sb.delete(sb.length() - 1,sb.length());
        sb.append(')');
        backTrack(left,right - 1,sb);
        sb.delete(sb.length() - 1,sb.length());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}