#include <bits/stdc++.h>
using namespace std;
const int maxn = 100 + 100;
struct node {
  int w, v;
  bool operator<(const node &b) const {
    if (v != b.v)
      return v > b.v;
    else
      return w > b.w;
  }
} a[maxn];
int dp[maxn][10005];
int main() {
  int n;
  scanf("%d", &n);
  long long sum = 0;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i].w);
    sum += a[i].w;
  }
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i].v);
  int cnt = 0;
  int total = 0;
  sort(a + 1, a + n + 1);
  for (int i = 1; i <= n; ++i) {
    total += a[i].v;
    if (total >= sum) {
      cnt = i;
      break;
    }
  }
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; ++i) {
    for (int j = sum; j - a[i].w >= 0; j--) {
      for (int k = i; k >= 1; --k) {
        if (dp[k - 1][j - a[i].w] != -1)
          dp[k][j] = max(dp[k][j], dp[k - 1][j - a[i].w] + a[i].v);
      }
    }
  }
  int ans = 0;
  for (int i = sum; i > 0; --i) {
    if (dp[cnt][i] >= sum) {
      ans = sum - i;
      break;
    }
  }
  printf("%d %d\n", cnt, ans);
  return 0;
}
