#include <bits/stdc++.h>
using namespace std;
const int N = 6e5 + 10;
const long long inf = 1e9 + 10;
int f[N], vist[N];
char s[N];
long long val[N];
vector<int> vec[N];
int find(int x) {
  if (f[x] == x) return x;
  f[x] = find(f[x]);
  return f[x];
}
void myunion(int x, int y) {
  if (x < y) {
    f[y] = x;
    val[x] += val[y];
  } else {
    f[x] = y;
    val[y] += val[x];
  }
}
int main() {
  int n, m, i, j, tot, x, y, fx, fy, type, ans = 0;
  scanf("%d%d", &n, &m);
  scanf("%s", s + 1);
  for (i = 1; i <= m; i++) {
    scanf("%d", &tot);
    for (j = 1; j <= tot; j++) {
      scanf("%d", &x);
      vec[x].push_back(i);
    }
  }
  for (i = 1; i <= m; i++) {
    f[i] = i;
    f[i + m] = m + i;
    val[i] = 1;
  }
  for (i = 1; i <= n; i++) {
    type = s[i] - '0';
    if (vec[i].size() == 1) {
      x = vec[i][0];
      y = x + m;
      fx = find(x);
      fy = find(y);
      if (vist[fx] || vist[fy]) ans -= min(val[fx], val[fy]);
      vist[fx] = vist[fy] = 1;
      if (type == 0) {
        val[fy] = inf;
        ans += val[fx];
      } else {
        val[fx] = inf;
        ans += val[fy];
      }
    } else if (vec[i].size() == 2) {
      x = vec[i][0];
      y = vec[i][1];
      if (type == 0) {
        if (find(x) != find(y + m)) {
          if (vist[find(x)]) ans -= min(val[find(x)], val[find(x + m)]);
          if (vist[find(y)]) ans -= min(val[find(y)], val[find(y + m)]);
          myunion(find(x), find(y + m));
          myunion(find(y), find(x + m));
          ans += min(val[find(x)], val[find(x + m)]);
        }
      } else {
        if (find(x) != find(y)) {
          if (vist[find(x)]) ans -= min(val[find(x)], val[find(x + m)]);
          if (vist[find(y)]) ans -= min(val[find(y)], val[find(y + m)]);
          myunion(find(x), find(y));
          myunion(find(x + m), find(y + m));
          ans += min(val[find(x)], val[find(x + m)]);
        }
      }
      vist[find(x)] = vist[find(x + m)] = vist[find(y)] = vist[find(y + m)] = 1;
    }
    printf("%d\n", ans);
  }
  return 0;
}
