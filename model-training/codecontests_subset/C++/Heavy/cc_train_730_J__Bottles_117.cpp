#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e2 + 20;
int dp[maxn][maxn * maxn];
int a[maxn], b[maxn];
void work() {
  int n;
  scanf("%d", &n);
  int all_A = 0;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
    all_A += a[i];
  }
  int all_B = 0;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &b[i]);
    all_B += b[i];
  }
  memset(dp, -0x3f, sizeof dp);
  dp[0][0] = 0;
  for (int i = 1; i <= n; ++i) {
    for (int j = n; j >= 1; --j) {
      for (int k = all_B; k >= b[i]; --k) {
        dp[j][k] = max(dp[j][k], dp[j - 1][k - b[i]] + a[i]);
      }
    }
  }
  int ansNeed = (0x3f3f3f3f);
  bool flag = true;
  for (int i = 1; i <= n && flag; ++i) {
    for (int j = 1; j <= all_B; ++j) {
      if (dp[i][j] < 0) continue;
      int lef = j - dp[i][j];
      int need = all_A - dp[i][j];
      if (lef >= need) {
        flag = false;
        ansNeed = min(ansNeed, need);
        flag = false;
      }
    }
    if (!flag) {
      cout << i << " " << ansNeed << endl;
      return;
    }
  }
}
int main() {
  work();
  return 0;
}
