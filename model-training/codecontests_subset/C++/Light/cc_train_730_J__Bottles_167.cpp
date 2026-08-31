#include <bits/stdc++.h>
using namespace std;
int n, a[200], b[200];
pair<int, int> dp[200][10100];
int sum = 0;
pair<int, int> rec(int i, int h) {
  if (i == n) {
    if (h >= sum) return {0, 0};
    return {1e9, 1e9};
  }
  pair<int, int> &ret = dp[i][h];
  if (ret != make_pair(-1, -1)) return ret;
  pair<int, int> res1 = {1e9, 1e9}, res2 = {1e9, 1e9};
  res1 = {rec(i + 1, h).first, a[i] + rec(i + 1, h).second};
  res2 = {rec(i + 1, h + b[i]).first + 1, rec(i + 1, h + b[i]).second};
  return ret = min(res1, res2);
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  memset(dp, -1, sizeof dp);
  cin >> n;
  int i;
  for (i = 0; i < n; i++) cin >> a[i], sum += a[i];
  for (i = 0; i < n; i++) cin >> b[i];
  cout << rec(0, 0).first << " " << rec(0, 0).second;
  return 0;
}
