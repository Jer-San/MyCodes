class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        if(nums.length==1){
            return (double)nums[0];
        }
        double max = -10000;
        double sum = 0;
        double average = 0;
        int c=0;
        for(int right = 0;right<nums.length;right++){
            int num = nums[right];
            sum = sum + num;
            c++;
            if(c==k){
                average = sum/k;
                max = Math.max(max, average);
                sum = sum-nums[left];
                average = 0;
                c--;
                left++;
            }

        }
        return max ;
    }
}
