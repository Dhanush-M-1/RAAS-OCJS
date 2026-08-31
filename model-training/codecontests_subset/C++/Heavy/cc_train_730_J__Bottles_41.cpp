#include <bits/stdc++.h>
using namespace std;
int f[20001][101];
struct node {
  int ai, bi;
} a[1001];
bool cmp(node x, node y) { return x.bi > y.bi; }
int main() {
  int n, sum1 = 0, sum2 = 0, d = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i].ai);
    sum1 += a[i].ai;
  }
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i].bi);
  }
  sort(a + 1, a + n + 1, cmp);
  while (sum1 > sum2) sum2 += a[++d].bi;
  printf("%d ", d);
  memset(f, 128, sizeof(f));
  f[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = sum2; j >= a[i].bi; j--) {
      for (int k = 1; k <= d; k++) {
        f[j][k] = max(f[j][k], f[j - a[i].bi][k - 1] + a[i].ai);
      }
    }
  }
  int ans = 0;
  for (int i = sum1; i <= sum2; i++) {
    ans = max(ans, f[i][d]);
  }
  printf("%d\n", sum1 - ans);
  return 0;
}
