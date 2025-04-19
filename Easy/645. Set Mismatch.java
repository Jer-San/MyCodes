class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int dup = 0;
        int sum = 0;
        for (int key : map.keySet()) {
            sum = sum + key;
            if (map.get(key) > 1) {
                dup = key;
            }
        }
        int n = nums.length;
        int tot = (n * (n + 1)) / 2;
        System.out.print(tot - sum);
        return new int[] { dup, tot - sum };
    }
}
