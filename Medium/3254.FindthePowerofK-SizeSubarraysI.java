class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        int[] ans = new int[n-k+1];
        int left = 0;
        int i = 0;
        for(int j=0;j<n-k+1;j++){
            for(int right=0;right<k;right++){
                res[right] = nums[j+right];
            }
            if(isSorted(res)){
                ans[i] = res[res.length-1];
                i++;
            }
            else{
                ans[i] = -1;
                i++;
            }
        } 
        return ans;
    }
    public boolean isSorted(int[] arr){
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i:arr){
            
            if(!tree.isEmpty() && tree.last()+1 != i){
                return false;
            }
            tree.add(i);
        }
        if(tree.size()<arr.length){
            return false;
        }
        int j=0;
        for(int i:tree){
            if(arr[j]!=i){
                return false;
            }
            j++;
        }
        return true;
    }
}
