#include <bits/stdc++.h>
using namespace std;
int k, n, m, sum, cur;
pair<int, int> a[110];
int f[110][10010], mn[110][10010];
bool Cmp(pair<int, int> a, pair<int, int> b) {
  return a.second > b.second || (a.second == b.second && a.first > b.first);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i].first), sum += a[i].first;
  for (int i = 1; i <= n; i++) scanf("%d", &a[i].second);
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j < i; j++)
      for (int k = 0; k < sum; k++)
        if (!k || mn[j][k]) {
          int t = mn[j][k] + 1;
          if (!mn[i][k + a[i].second] || t < mn[i][k + a[i].second] ||
              (t == mn[i][k + a[i].second] &&
               f[j][k] + a[i].first > f[i][k + a[i].second]))
            mn[i][k + a[i].second] = t,
                      f[i][k + a[i].second] = f[j][k] + a[i].first;
        }
  }
  int Mn = n + 1, Mx = 0;
  for (int i = 1; i <= n; i++)
    for (int j = sum; j <= 10000; j++)
      if (mn[i][j] && mn[i][j] < Mn || (mn[i][j] == Mn && f[i][j] > Mx))
        Mn = mn[i][j], Mx = f[i][j];
  printf("%d %d\n", Mn, sum - Mx);
}
