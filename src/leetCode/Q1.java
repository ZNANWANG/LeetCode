package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。你可以假设每种输入只会对应
 * 一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @Author: Wang An
 * @Date: 4/25/2020 11:15 PM
 */
public class Q1 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 4, 3, 0};
        int target = 0;
        Q1 test = new Q1();
        int[] result = test.twoSum1(nums, target);
        System.out.print(Arrays.toString(result));
    }

    /**
     * 蛮力查找：双重遍历给定数组，找出和为目标值的那两个整数，并返回他们的数组下标。
     * <p>
     * 复杂度分析：
     * 时间复杂度：O(n^2)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n)的时间。因此时间复杂度为 O(n^2)。
     * 空间复杂度：O(1)
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 和为目标值的两个整数的数组下标组成的数组
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 两遍哈希表
     * 为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。如果存在，我们需要找出它的索引。保持数组中的每个元素
     * 与其索引相互对应的最好方法是什么？哈希表。
     * <p>
     * 通过以空间换取速度的方式，我们可以将查找时间从 O(n)降低到 O(1)。哈希表正是为此目的而构建的，它支持以 近似 恒定的时间进行快速查找。我用
     * “近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)。但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)。
     * <p>
     * 一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。然后，在第二次迭代中，我们将检查每个元素所对应的目
     * 标元素（target - nums[i]）是否存在于表中。注意，该目标元素不能是 nums[i]本身！
     * <p>
     * 复杂度分析：
     * 时间复杂度：O(n)，
     * 我们把包含有 n个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1)，所以时间复杂度为 O(n)。
     * <p>
     * 空间复杂度：O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n个元素。
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 和为目标值的两个整数的数组下标组成的数组
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表
     * 事实证明，我们可以一次完成。在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素。如果它存在，
     * 那我们已经找到了对应解，并立即将其返回。
     * <p>
     * 复杂度分析：
     * 时间复杂度：O(n)，
     * 我们只遍历了包含有 n个元素的列表一次。在表中进行的每次查找只花费 O(1)的时间。
     * <p>
     * 空间复杂度：O(n)，
     * 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n个元素。
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 和为目标值的两个整数的数组下标组成的数组
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
