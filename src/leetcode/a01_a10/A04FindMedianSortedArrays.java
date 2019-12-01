package leetcode.a01_a10;

/*
4. 寻找两个有序数组的中位数
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。
示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
 */

public class A04FindMedianSortedArrays {

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int MIN_VALUE = 0x80000000;

        int MAX_VALUE = 0x7fffffff;

        int N1 = nums1.length;
        int N2 = nums2.length;
        if (N1 > N2) {// 确保N1是短的部分。
            return findMedianSortedArrays2(nums2, nums1);
        }

        if (N1 == 0)
            return ((double) nums2[(N2 - 1) / 2] + (double) nums2[N2 / 2]) / 2;
        int size = N1 + N2;
        int cutL = 0, cutR = N1;// 长度为N的数组可以切 N + 1 刀
        int cut1 = N1 / 2;
        int cut2 = size / 2 - cut1;

        while (cut1 <= N1) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = size / 2 - cut1;

            double L1 = (cut1 == 0) ? MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == N1) ? MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == N2) ? MAX_VALUE : nums2[cut2];
            if (L1 > R2)
                cutR = cut1 - 1;
            else if (L2 > R1)
                cutL = cut1 + 1;
            else {// 切的位置正确时
                if (size % 2 == 0) {// 总长度为偶数时
                    L1 = (L1 > L2 ? L1 : L2);// L 取大，R 取小，才是最中间的两个。
                    R1 = (R1 < R2 ? R1 : R2);
                    return (L1 + R1) / 2;
                } else {
                    R1 = (R1 < R2 ? R1 : R2);// 总长度为奇数时，总是 R 的最小值
                    return R1;
                }
            }
        }
        return -1;
    }
}