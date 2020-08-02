public int longestCommonSubsequence(String text1, String text2) {
  int[][] dp = new int[text1.length()+1][text2.length()+1];
  int i = 1;
  int j = 1;
  for(i = 1; i<dp.length; i++){ //text1
    for(j = 1; j<dp[0].length; j++){ //text2
      dp[i][j] = text1.charAt(i-1)==text2.charAt(j-1) ? dp[i-1][j-1]+1 : Math.max(dp[i-1][j], dp[i][j-1]);
    }
  }
  return dp[text1.length()][text2.length()];
}
