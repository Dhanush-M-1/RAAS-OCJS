#include <bits/stdc++.h>
using namespace std;
int dp[105][10005];
struct node {
  int a, b;
} bottle[105];
bool cmp(node t1, node t2) {
  if (t1.b != t2.b)
    return t1.b > t2.b;
  else
    return t1.a > t2.a;
}
int main() {
  int n, sum = 0;
  int cnt;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &bottle[i].a);
    sum += bottle[i].a;
  }
  for (int i = 1; i <= n; i++) scanf("%d", &bottle[i].b);
  sort(bottle + 1, bottle + n + 1, cmp);
  for (int i = 1, tmp = 0; i <= n; i++) {
    tmp += bottle[i].b;
    if (sum <= tmp) {
      cnt = i;
      break;
    }
  }
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = sum - bottle[i].a; j >= 0; j--) {
      for (int pre = i - 1; pre >= 0; pre--) {
        if (dp[pre][j] != -1) {
          dp[pre + 1][j + bottle[i].a] =
              max(dp[pre + 1][j + bottle[i].a], dp[pre][j] + bottle[i].b);
        }
      }
    }
  }
  int t;
  for (int i = sum; i >= 0; i--) {
    if (dp[cnt][i] >= sum) {
      t = i;
      break;
    }
  }
  printf("%d %d\n", cnt, sum - t);
  return 0;
}
