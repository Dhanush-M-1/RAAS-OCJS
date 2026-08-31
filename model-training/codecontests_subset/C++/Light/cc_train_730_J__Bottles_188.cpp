#include <bits/stdc++.h>
using namespace std;
int n, a[110], b[110], sum = 0;
pair<int, int> dp[110][11000], q = {-1, -1};
pair<int, int> Rec(int i, int W) {
  if (i == n) {
    if (W >= sum)
      return {0, 0};
    else
      return {1e9, 1e9};
  }
  if (dp[i][W] != q) return dp[i][W];
  pair<int, int> Res1 = {1e9, 1e9}, Res2 = {1e9, 1e9};
  Res1 = {0 + Rec(i + 1, W).first, a[i] + Rec(i + 1, W).second};
  Res2 = {1 + Rec(i + 1, W + b[i]).first, 0 + Rec(i + 1, W + b[i]).second};
  return dp[i][W] = min(Res1, Res2);
}
int main() {
  memset(dp, -1, sizeof(dp));
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i], sum += a[i];
  for (int i = 0; i < n; i++) cin >> b[i];
  cout << Rec(0, 0).first << " " << Rec(0, 0).second;
  return 0;
}
