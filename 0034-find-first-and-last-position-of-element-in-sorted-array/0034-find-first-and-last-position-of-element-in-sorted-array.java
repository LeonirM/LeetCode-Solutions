class Solution {

    private int firstOcc(int[] nums ,int target){
        int first = -1;
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low) / 2 ;
            if(nums[mid] == target){
                first = mid;
                high = mid - 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return first;
    }

        private int lastOcc(int[] nums ,int target){
        int last = -1;
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high - low) / 2 ;
            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = firstOcc(nums,target);
        if(first == -1) return new int[]{-1,-1};
        int last = lastOcc(nums,target);
        return new int[]{first,last};
    }
}