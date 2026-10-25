class Solution {
    public int search(int[] nums, int target) {
        return BS(nums,0,nums.length-1,target);
    }

    private int BS(int[] nums,int low,int high,int target){
        int mid = low+(high-low)/2;

        if(low > high){
            return -1;
        }
        if(nums[mid] == target){
            return mid;
        }
        if(target < nums[mid]){
            return BS(nums,low,mid-1,target);
        }
        else{
            return BS(nums,mid+1,high,target);
        }
    }
}