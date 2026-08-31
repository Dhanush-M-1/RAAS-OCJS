#include <bits/stdc++.h>
using namespace std;
int d[100005], h[100005], n, dp[100005][3];
int fun(int idx, int dir) {
  if (idx == n) {
    return 0;
  }
  if (dp[idx][dir] != -1) {
    return dp[idx][dir];
  }
  int &ret = dp[idx][dir];
  if (dir != 2) {
    if (!idx || d[idx - 1] < d[idx] - h[idx]) ret = 1 + fun(idx + 1, 0);
  } else {
    if (d[idx - 1] + h[idx - 1] < d[idx] - h[idx]) {
      ret = 1 + fun(idx + 1, 0);
    }
  }
  ret = max(ret, fun(idx + 1, 1));
  if ((idx == n - 1 || d[idx + 1] > h[idx] + d[idx])) {
    ret = max(ret, 1 + fun(idx + 1, 2));
  }
  return ret;
}
int main() {
  memset(dp, -1, sizeof dp);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> d[i] >> h[i];
  }
  cout << fun(0, 0) << endl;
  return 0;
}
