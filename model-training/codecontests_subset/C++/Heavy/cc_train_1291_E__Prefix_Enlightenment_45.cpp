#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
const int MAX_N = 6e5 + 5;
int n, k, a[MAX_N >> 1];
vector<int> op[MAX_N >> 1];
int fa[MAX_N], val[MAX_N];
int find(int x) { return fa[x] == x ? x : fa[x] = find(fa[x]); }
void unit(int x, int y) {
  int fx = find(x), fy = find(y);
  if (fx != fy) fa[fy] = fx, val[fx] += val[fy];
}
int get_min(int x) { return min(val[find(x)], val[find(x + k)]); }
int main() {
  scanf("%d", &n), scanf("%d", &k);
  for (register int i = 1; i <= n; i++) scanf("%1d", &a[i]);
  for (register int i = 1; i <= k; i++) {
    int x, y;
    scanf("%d", &x);
    while (x--) scanf("%d", &y), op[y].push_back(i);
  }
  for (register int i = 1; i <= 2 * k + 1; i++) fa[i] = i, val[i] = (i <= k);
  int mx = 2 * k + 1;
  val[mx] = inf;
  int ans = 0;
  for (register int i = 1; i <= n; i++) {
    if (op[i].size() == 1) {
      int tmp = op[i][0] + k * (a[i] == 0);
      ans -= get_min(op[i][0]);
      unit(tmp, mx);
      ans += get_min(op[i][0]);
    } else if (op[i].size() == 2) {
      int x = op[i][0], y = op[i][1];
      if (a[i] == 0 && find(x) != find(y + k)) {
        ans -= (get_min(x) + get_min(y));
        unit(x, y + k), unit(x + k, y);
        ans += get_min(x);
      }
      if (a[i] == 1 && find(x) != find(y)) {
        ans -= (get_min(x) + get_min(y));
        unit(x, y), unit(x + k, y + k);
        ans += get_min(x);
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
