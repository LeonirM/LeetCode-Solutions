
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int cnt = 0;

        cnt += mergeSort(arr, left, mid);
        cnt += mergeSort(arr, mid + 1, right);

        cnt += countPairs(arr, left, mid, right);

        merge(arr, left, mid, right);

        return cnt;
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int cnt = 0;
        int r = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (r <= high && (long) nums[i] > 2L * nums[r]) {
                r++;
            }

            cnt += r - (mid + 1);
        }

        return cnt;
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}
