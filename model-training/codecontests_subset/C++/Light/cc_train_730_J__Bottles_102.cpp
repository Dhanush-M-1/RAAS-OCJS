#include <bits/stdc++.h>
using namespace std;
struct Node {
  int a, b;
} x[110];
bool cmp(Node i, Node j) {
  if (i.a == j.a)
    return i.b > j.b;
  else
    return i.a > j.a;
}
int n, ans, sum, k, dp[110][10010], sumv;
int main() {
  while (~scanf("%d", &n)) {
    sumv = ans = sum = k = 0;
    for (int i = 0; i < n; i++) {
      scanf("%d", &x[i].b);
      sum += x[i].b;
    }
    for (int i = 0; i < n; i++) {
      scanf("%d", &x[i].a);
      sumv += x[i].a;
    }
    sort(x, x + n, cmp);
    int temp = sum, cnt = 0;
    while (temp > 0) {
      temp -= x[cnt++].a;
      k++;
    }
    memset(dp, -0x3f3f3f3f, sizeof(dp));
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = sumv; j >= x[i - 1].a; j--) {
        for (int u = 1; u <= k; u++) {
          dp[u][j] = max(dp[u][j], dp[u - 1][j - x[i - 1].a] + x[i - 1].b);
        }
      }
    }
    ans = -0x3f3f3f3f;
    for (int i = sum; i <= sumv; i++) ans = max(ans, dp[k][i]);
    printf("%d %d\n", k, sum - ans);
  }
}
