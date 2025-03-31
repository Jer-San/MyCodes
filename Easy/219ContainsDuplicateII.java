class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int right=0;right<nums.length;right++){
            int n = nums[right]; 
            if(map.containsKey(n)){
                if(Math.abs(map.get(n)-right) <= k){
                    return true;
                }
            }
            map.put(n, right);
        }
        return false;
    }
}
