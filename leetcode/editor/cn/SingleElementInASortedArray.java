package editor.cn;

//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,2,3, 3, 4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。 
// Related Topics 二分查找 
// 👍 206 👎 0

public class SingleElementInASortedArray{
    public static void main(String[] args) {
    
        Solution solution = new SingleElementInASortedArray().new Solution();
        
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {
       /*
       if (nums == null || nums.length == 0) {
            return 0;
        }
        boolean f = false;
        for (int i = 0; i < nums.length-1; i+=2) {
            if (nums[i] != nums[i+1]){
               return nums[i];
            }
        }
        return nums[nums.length - 1];
        */

        // 二分搜索 左 边 还是 右边 是奇数
       /* int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean halvesAreEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (halvesAreEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (halvesAreEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];*/
        int l = 0, r = nums.length - 1;
        while(l<r){
            int mid = l + (r - l)/2;
            if(mid % 2 == 1){
                mid --;
            }
            if(nums[mid] == nums[mid + 1]){
                l = mid + 2;
            }else{
                r = mid;
            }
        }

        return nums[l];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}