#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e4 + 10;
struct Bottle {
  int v, n;
} a[110];
int DP[110][MAX];
int main() {
  int n, sum_n = 0, sum_v = 0, maxx = 0, num = 0;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i].n);
    sum_n += a[i].n;
  }
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i].v);
    sum_v += a[i].v;
  }
  for (int i = 0; i < n; i++)
    for (int j = i + 1; j; j--)
      for (int k = sum_v; k >= a[i].v; k--)
        if (DP[j - 1][k - a[i].v] || k == a[i].v)
          DP[j][k] = max(DP[j][k], DP[j - 1][k - a[i].v] + a[i].n);
  for (int i = 1; i <= n; i++) {
    for (int j = sum_n; j <= sum_v; j++)
      if (DP[i][j] > maxx) {
        maxx = DP[i][j];
        num = i;
      }
    if (maxx != 0) break;
  }
  printf("%d %d\n", num, sum_n - maxx);
  return 0;
}
