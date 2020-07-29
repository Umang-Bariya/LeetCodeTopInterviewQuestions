Given an array of integers, find the maximum possible sum you can get from one of its contiguous subarrays. The subarray from which this sum comes must contain at least 1 element.

Example

For inputArray = [-2, 2, 5, -11, 6], the output should be
arrayMaxConsecutiveSum2(inputArray) = 7.

The contiguous subarray that gives the maximum possible sum is [2, 5], with a sum of 7.

Solution:

int arrayMaxConsecutiveSum2(int[] a) {
    int maximumSum = a[0];
    int currentSum  = a[0];
    
    for(int i = 1; i < a.length; i++){
        currentSum = Math.max(a[i] + currentSum, a[i]);
        maximumSum = Math.max(currentSum, maximumSum);
    }
    return maximumSum;
}
