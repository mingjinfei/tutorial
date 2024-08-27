package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <h3>3数之和 - 用之前 Leetcode 40 题思路来解</h3>
 */
public class SumLeetcode15_2 {

    static List<List<Integer>> threeSum(int[] candidates) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, 0, candidates, new boolean[candidates.length], new LinkedList<>(), result);
        return result;
    }

    static int count = 0;

    static void dfs(int target, int start, int[] candidates, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> result) {
        count++;
        if (stack.size() == 3) {
            if (target == 0) {
                result.add(new ArrayList<>(stack));
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                continue;
            }
            if (i > 0 && candidate == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            stack.push(candidate);
            dfs(target - candidate, i + 1, candidates, visited, stack, result);
            stack.pop();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        int[] candidates = {-9, -5, -4, -3, -2, -1, 0, 2, 3, 7, 8, 11, 13, 16, 17, 21, 22, 23, 24, 25};
        int[] candidates = new int[]{-19921, -19644, -19607, -19475, -19410, -19391, -19370, -19357, -19335, -19246, -19177, -19165, -19145, -19082, -18980, -18942, -18874, -18838, -18791, -18747, -18563, -18547, -18461, -18422, -18348, -18331, -18242, -18221, -18211, -18159, -18126, -18080, -17902, -17790, -17561, -17452, -17365, -17363, -17341, -17223, -17025, -17008, -16929, -16922, -16866, -16832, -16760, -16580, -16523, -16511, -16464, -16350, -16324, -16267, -16151, -16109, -16085, -16065, -16000, -15982, -15917, -15816, -15802, -15741, -15659, -15653, -15619, -15524, -15501, -15477, -15462, -15331, -15317, -15293, -15239, -15206, -15121, -15114, -15086, -15052, -15016, -14915, -14866, -14859, -14782, -14778, -14606, -14600, -14531, -14530, -14452, -14388, -14270, -14263, -14258, -14104, -14087, -14003, -13897, -13840, -13782, -13726, -13706, -13658, -13631, -13594, -13547, -13505, -13500, -13439, -13417, -13304, -13174, -13155, -13016, -12957, -12879, -12761, -12716, -12641, -12609, -12470, -12458, -12393, -12388, -12374, -12235, -12228, -12179, -12113, -12041, -11931, -11829, -11753, -11670, -11662, -11555, -11433, -11318, -11293, -11270, -11261, -11242, -11219, -11113, -10960, -10957, -10859, -10696, -10660, -10640, -10400, -10301, -10238, -10218, -10184, -10130, -10101, -9741, -9732, -9642, -9474, -9461, -9310, -9274, -9243, -9241, -9096, -9037, -9022, -8966, -8938, -8853, -8849, -8838, -8832, -8824, -8801, -8798, -8763, -8682, -8527, -8420, -8385, -8270, -8217, -7908, -7877, -7845, -7810, -7679, -7642, -7628, -7617, -7611, -7535, -7532, -7528, -7418, -7341, -7269, -7240, -7180, -7049, -7041, -6954, -6939, -6864, -6601, -6511, -6493, -6468, -6417, -6242, -6218, -6167, -6088, -5933, -5860, -5589, -5532, -5475, -5475, -5453, -5431, -5306, -5021, -4942, -4913, -4899, -4866, -4423, -4322, -4259, -4257, -4185, -4159, -4105, -4088, -4026, -3990, -3765, -3728, -3642, -3596, -3555, -3490, -3487, -3406, -3333, -3303, -3271, -3251, -3221, -3218, -3046, -2989, -2954, -2951, -2919, -2863, -2707, -2586, -2460, -2445, -2437, -2388, -2314, -2288, -2243, -2156, -2151, -2141, -2072, -1958, -1900, -1859, -1806, -1760, -1741, -1636, -1560, -1523, -1483, -1415, -1408, -1343, -1331, -1187, -1186, -1119, -759, -602, -585, -562, -542, -447, -394, -104, -90, 20, 21, 46, 250, 252, 324, 727, 792, 860, 874, 910, 910, 925, 929, 1202, 1209, 1454, 1558, 1591, 1637, 1897, 1909, 1919, 1988, 2099, 2246, 2344, 2391, 2590, 2689, 2705, 2759, 2803, 2826, 2890, 2909, 3015, 3023, 3063, 3114, 3213, 3295, 3302, 3325, 3340, 3342, 3638, 3649, 3649, 3695, 3848, 3900, 3939, 4031, 4071, 4103, 4247, 4280, 4320, 4394, 4460, 4508, 4656, 4675, 4713, 4856, 5017, 5262, 5355, 5356, 5453, 5465, 5467, 5475, 5680, 5852, 5897, 5992, 6001, 6019, 6059, 6086, 6184, 6214, 6364, 6421, 6428, 6739, 6822, 6912, 7170, 7225, 7228, 7252, 7332, 7344, 7352, 7461, 7712, 8284, 8315, 8434, 8623, 8731, 8838, 8845, 8860, 8940, 8942, 8959, 8990, 9104, 9147, 9174, 9255, 9337, 9344, 9344, 9541, 9612, 9623, 9883, 9947, 9948, 10029, 10052, 10079, 10093, 10142, 10151, 10153, 10159, 10236, 10390, 10406, 10481, 10673, 10709, 10710, 11092, 11219, 11276, 11422, 11474, 11515, 11576, 11721, 11839, 11855, 12052, 12200, 12241, 12326, 12333, 12582, 12642, 12687, 12718, 12741, 12783, 12808, 12820, 12900, 13033, 13041, 13042, 13048, 13091, 13141, 13170, 13200, 13211, 13213, 13343, 13483, 13501, 13606, 13615, 13616, 13621, 13686, 13700, 13777, 13805, 13848, 13859, 13947, 13974, 14014, 14079, 14162, 14184, 14198, 14333, 14349, 14367, 14525, 14627, 14740, 14848, 14861, 14906, 14961, 14996, 15016, 15086, 15129, 15396, 15473, 15498, 15686, 15690, 15750, 15779, 15922, 15929, 15966, 15970, 16059, 16244, 16296, 16538, 16590, 16634, 16659, 16814, 16822, 17016, 17056, 17165, 17307, 17318, 17452, 17642, 17708, 17718, 17764, 17910, 17921, 17984, 17994, 18008, 18041, 18096, 18123, 18179, 18242, 18403, 18470, 18516, 18593, 18669, 18683, 18749, 18766, 18913, 19121, 19343, 19355, 19355, 19369, 19450, 19486, 19491, 19546, 19553, 19664, 19672, 19700, 19746, 19758, 19878, 19927, 19956, 19997};
        System.out.println("数据量:" + candidates.length);
        System.out.println(threeSum(candidates));
        System.out.println("耗费时间:" + (System.currentTimeMillis() - start));
        System.out.println("递归次数:" + count);
    }
}
