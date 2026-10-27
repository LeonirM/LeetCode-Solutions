class Solution {
        public int lB(int[] nums, int target) {
       int n = nums.length;
       int low=0;
       int high = n-1;
       int ans1 = n;
       while(low<=high){
        int mid = low+(high-low)/2;
        if(nums[mid] >= target){
            ans1 = mid;
            high = mid - 1;

        }
        else{
            low = mid + 1;
        }


       } 
       return ans1;
    }

        public int uB(int[] nums, int target) {
       int n = nums.length;
       int low=0;
       int high = n-1;
       int ans2 = n;
       while(low<=high){
        int mid = low+(high-low)/2;
        if(nums[mid] > target){
            ans2 = mid;
            high = mid - 1;

        }
        else{
            low = mid + 1;
        }


       } 
       return ans2;
    }
    public int[] searchRange(int[] nums, int target) {
       int lowerBound = lB(nums,target);
       if(lowerBound == nums.length || nums[lowerBound] != target) return new int[]{-1,-1};
       return new int[]{lowerBound,uB(nums,target)-1};
    }
}