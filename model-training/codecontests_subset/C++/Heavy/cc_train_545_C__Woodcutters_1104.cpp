#include <bits/stdc++.h>
using namespace std;
const long long M = 1e9 + 7;
const int N = 1e6 + 7;
int n;
int x[N], h[N];
int dp[100001][3];
int getAns(int idx, int con) {
  if (idx > n) return 0;
  if (dp[idx][con] != -1) return dp[idx][con];
  int ans = 0;
  int pos;
  if (con == 0) pos = x[idx - 1];
  if (con == 1) pos = x[idx - 1];
  if (con == 2) pos = x[idx - 1] + h[idx - 1];
  ans = max(ans, getAns(idx + 1, 0));
  if (x[idx] - h[idx] > pos) ans = max(ans, getAns(idx + 1, 1) + 1);
  if (x[idx] + h[idx] < x[idx + 1]) ans = max(ans, getAns(idx + 1, 2) + 1);
  return dp[idx][con] = ans;
}
int main() {
  cin >> n;
  for (long long i = 1; i < (int)n + 1; i++) cin >> x[i] >> h[i];
  x[0] = INT_MIN, h[0] = INT_MIN;
  x[n + 1] = INT_MAX;
  memset(dp, -1, sizeof dp);
  cout << getAns(1, 0);
  return 0;
}
