#include <bits/stdc++.h>
using namespace std;
const int maxn = 100 + 50;
int dp[maxn][maxn * maxn];
struct Node2 {
  int a, b;
} t[maxn];
bool cmp2(Node2 x, Node2 y) {
  if (x.b != y.b)
    return x.b > y.b;
  else
    return x.a > y.a;
}
int main() {
  int n, sum = 0, summ = 0, cnt = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &t[i].a), sum += t[i].a;
  for (int i = 1; i <= n; i++) scanf("%d", &t[i].b);
  sort(t + 1, t + 1 + n, cmp2);
  for (int i = 1; i <= n; i++) {
    summ += t[i].b;
    if (summ >= sum) {
      cnt = i;
      break;
    }
  }
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = sum; j >= t[i].a; j--) {
      for (int k = i; k >= 1; k--) {
        if (dp[k - 1][j - t[i].a] != -1)
          dp[k][j] = max(dp[k][j], dp[k - 1][j - t[i].a] + t[i].b);
      }
    }
  }
  int ans = 0;
  for (int i = sum; i >= 1; i--) {
    if (dp[cnt][i] >= sum) {
      ans = sum - i;
      break;
    }
  }
  printf("%d %d\n", cnt, ans);
  return 0;
}
