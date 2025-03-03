// https://practice.geeksforgeeks.org/contest/interview-series-44/problems/


class Solution{
    int maxCoins(ArrayList<Integer> arr, int n) {
		//Write your code here
		int [] extraSpaceIncluded = new int [n + 2];
		extraSpaceIncluded[0] = extraSpaceIncluded[n + 1] = 1;
		for (int i = 1; i <= n; i++) {
		    extraSpaceIncluded[i] = arr.get(i - 1);
		}
		int [][] dp = new int [n + 2][n + 2];
		for (int i = 1; i <= n; i++) {
		    for (int left = 1; left < n - i + 2; left++) {
		        int right = left + i - 1;
		        for (int p = left; p < right + 1; p++) {
		            dp[left][right] = Math.max(
		                dp[left][right],
		                dp[left][p - 1] + 
		                extraSpaceIncluded[left - 1] * extraSpaceIncluded[p] * extraSpaceIncluded[right + 1] + dp[p + 1][right]);
		        }
		    }
		}
		return dp[1][n];
	}
}


// matrix chain multiplication variant

// https://youtu.be/AWyGB-P90sg

//User function Template for Java

class Solution{
    int maxCoins(ArrayList<Integer> arr, int n) {
		//Write your code here
		int [] extraSpaceIncluded = new int [n + 2];
		extraSpaceIncluded[0] = extraSpaceIncluded[n + 1] = 1;
		for (int i = 1; i <= n; i++) {
		    extraSpaceIncluded[i] = arr.get(i - 1);
		}
		int [][] dp = new int [n + 2][n + 2];
		for (int i = n; i > 0; i--) {
		    for (int j = i; j <= n; j++) {
		        for (int k = i; k <= j; k++) {
		            dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + 
		            extraSpaceIncluded[k] * extraSpaceIncluded[i - 1] * 
		            extraSpaceIncluded[j + 1]);
		        }
		    }
		}
		return dp[1][n];
	}
}