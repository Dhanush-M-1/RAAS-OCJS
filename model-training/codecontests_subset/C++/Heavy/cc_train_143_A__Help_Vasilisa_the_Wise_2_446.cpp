#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-8;
const int maxn = 100005;
int a[4];
bool vis[10];
int r1, r2, c1, c2, d1, d2;
bool check() {
  if (r1 != a[0] + a[1]) return 0;
  if (r2 != a[2] + a[3]) return 0;
  if (c1 != a[0] + a[2]) return 0;
  if (c2 != a[1] + a[3]) return 0;
  if (d1 != a[0] + a[3]) return 0;
  if (d2 != a[1] + a[2]) return 0;
  return 1;
}
bool dfs(int d, int x) {
  if (d) a[d - 1] = x, vis[x] = 1;
  if (d == 4) {
    if (check()) return 1;
    vis[x] = 0;
    return 0;
  }
  for (int i = 1; i <= 9; i++)
    if (!vis[i])
      if (dfs(d + 1, i)) return 1;
  vis[x] = 0;
  return 0;
}
int main() {
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  bool f = dfs(0, 0);
  if (f)
    printf("%d %d\n%d %d\n", a[0], a[1], a[2], a[3]);
  else
    puts("-1");
  return 0;
}
