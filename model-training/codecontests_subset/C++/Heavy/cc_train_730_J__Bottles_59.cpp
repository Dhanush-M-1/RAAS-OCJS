#include <bits/stdc++.h>
using namespace std;
const int N = 1e4 + 4;
pair<int, int> DP[101][2 * N];
int F[101][101];
int a[101], b[101];
const int inf = 1e5 + 5;
pair<int, int>& dp(int i, int j) {
  if (j < 0) return DP[i][N + abs(j)];
  return DP[i][j];
}
int n;
pair<int, int> rec(int idx, int volume_free) {
  if (dp(idx, volume_free).first != -1) return dp(idx, volume_free);
  if (idx == n) {
    if (volume_free >= 0) return make_pair(0, 0);
    return {inf, 0};
  }
  pair<int, int> res;
  pair<int, int> ff = rec(idx + 1, volume_free + b[idx] - a[idx]);
  res.first = ff.first + 1;
  res.second = ff.second;
  ff = rec(idx + 1, volume_free - a[idx]);
  res = min(res, {ff.first, ff.second + a[idx]});
  return dp(idx, volume_free) = res;
}
int main() {
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> a[i];
  for (int i = 0; i < n; ++i) cin >> b[i];
  for (int i = 0; i < 101; ++i)
    for (int j = -N; j < N; ++j) dp(i, j).first = -1;
  cout << rec(0, 0).first << ' ' << rec(0, 0).second << '\n';
  return 0;
}
