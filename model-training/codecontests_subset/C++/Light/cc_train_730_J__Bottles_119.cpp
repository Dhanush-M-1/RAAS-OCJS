#include <bits/stdc++.h>
using namespace std;
int dp[105][105 * 105];
int n, k, sum;
struct node {
  int a, b;
  bool operator<(const node &a) const { return b > a.b; }
} p[105];
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> p[i].a;
    sum += p[i].a;
  }
  for (int i = 1; i <= n; i++) cin >> p[i].b;
  sort(p + 1, p + 1 + n);
  int tot = 0;
  for (int i = 1; i <= n; i++) {
    tot += p[i].b;
    if (tot >= sum) {
      k = i;
      break;
    }
  }
  memset(dp, -1, sizeof dp);
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = sum - p[i].a; j >= 0; j--) {
      for (int pre = i - 1; pre >= 0; pre--)
        if (dp[pre][j] != -1) {
          dp[pre + 1][j + p[i].a] =
              max(dp[pre + 1][j + p[i].a], dp[pre][j] + p[i].b);
        }
    }
  }
  int t;
  for (int i = sum; i; i--) {
    if (dp[k][i] >= sum) {
      t = i;
      break;
    }
  }
  printf("%d %d\n", k, sum - t);
  return 0;
}
