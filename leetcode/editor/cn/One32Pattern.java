package editor.cn;

//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 枚举 3 是容易想到并且也是最容易实现的。由于 3 是模式中的最大值，并且其出现在 1 和 2 的中间，
// 因此我们只需要从左到右枚举 3 的下标 j ，那么：
//
//- 由于 1 是模式中的最小值，因此我们在枚举 j 的同时，
//  维护数组 a 中左侧元素 a[0..j-1] 的最小值，即为 1 对应的元素 a[i]。
//  需要注意的是，只有 a[i] < a[j] 时， a[i] 才能作为 1 对应的元素；
//
//- 由于 2 是模式中的次小值，因此我们可以使用一个有序集合（例如平衡树）
//  维护数组 a 中右侧元素 a[j+1..n-1] 中的所有值。
//  当我们确定了 a[i] 和 a[j] 之后，只需要在有序集合中查询严格比 a[i] 大的那个最小的元素，
//  即为 a[k] 。需要注意的是，只有 a[k] < a[j] 时， a[k] 才能作为 3 对应的元素。
//
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 栈 
// 👍 382 👎 0

import java.util.TreeMap;

public class One32Pattern{
  public static void main(String[] args) {
  
    Solution solution = new One32Pattern().new Solution();
    int nums[] = {3,1,4,2};
    solution.find132pattern(nums);
    
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean find132pattern(int[] nums) {

    //枚举
    int n = nums.length;
    if (n < 3) {
      return false;
    }

    // 左侧最小值
    int leftMin = nums[0];
    // 右侧所有元素
    TreeMap<Integer, Integer> rightAll = new TreeMap<>();

    for (int k = 2; k < n; ++k) {
      rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
    }

    for (int j = 1; j < n - 1; ++j) {
      if (leftMin < nums[j]) {
        Integer next = rightAll.ceilingKey(leftMin + 1);
        // ceilingKey（K key）方法用来返回的最小键 大于或等于给定键，如果不存在则返回null。
        if (next != null && next < nums[j]) {
          return true; // 132 栗园
        }//
      }
      leftMin = Math.min(leftMin, nums[j]);
      rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
      if (rightAll.get(nums[j + 1]) == 0) {
        rightAll.remove(nums[j + 1]);
      }//
    }

    return false;
  }

}
//leetcode submit region end(Prohibit modification and deletion)

}