#include <bits/stdc++.h>
using namespace std;
inline int max(int x, int y) { return x > y ? x : y; }
int n;
struct node {
  int a, b;
  bool operator<(const node &rhs) const { return b > rhs.b; }
} p[110];
int d[110][110 * 110];
int main() {
  int sum = 0, w = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &p[i].a);
    sum += p[i].a;
  }
  for (int i = 1; i <= n; i++) {
    scanf("%d", &p[i].b);
    w += p[i].b;
  }
  sort(p + 1, p + 1 + n);
  int cnt = 1;
  int ssum = sum;
  while (ssum - p[cnt].b > 0) ssum -= p[cnt++].b;
  memset(d, -1, sizeof d);
  for (int i = 1; i <= n; i++) {
    for (int j = i; j >= 2; j--)
      for (int k = w; k >= 1; k--) {
        if (d[j - 1][k] != -1) d[j][k] = d[j - 1][k];
        if (k >= p[i].b && d[j - 1][k - p[i].b] != -1)
          d[j][k] = max(d[j - 1][k - p[i].b] + p[i].a, d[j][k]);
      }
    d[1][p[i].b] = max(d[1][p[i].b], p[i].a);
  }
  int ans = 0;
  for (int i = w; i >= sum; i--) {
    if (d[cnt][i] > ans) ans = d[cnt][i];
  }
  printf("%d %d\n", cnt, sum - ans);
}
