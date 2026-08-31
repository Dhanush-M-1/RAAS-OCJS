#include <bits/stdc++.h>
using namespace std;
struct Y {
  int h, d;
  inline bool operator<(const Y& a) const { return d < a.d; }
} dep[200005];
int n, d[200005], rt, p[200005], que[200005], f[200005], cnt;
vector<int> a[200005];
void dfs(int x, int fa) {
  dep[x].h = x, dep[x].d = dep[fa].d + 1, f[x] = fa;
  for (int i = 0; i < a[x].size(); ++i)
    if (a[x][i] != fa) dfs(a[x][i], x);
}
void dfs1(int x) {
  for (int i = 0; i < a[x].size(); ++i)
    if (p[a[x][i]] == 1 && a[x][i] != f[x]) dfs1(a[x][i]);
  que[++cnt] = x;
  for (int i = 0; i < a[x].size(); ++i)
    if (p[a[x][i]] == 0 && a[x][i] != f[x]) dfs1(a[x][i]);
}
int main(void) {
  register int i, x;
  scanf("%d", &n);
  for (i = 1; i <= n; ++i) {
    scanf("%d", &x);
    if (x != 0)
      ++d[i], ++d[x], a[i].push_back(x), a[x].push_back(i);
    else
      rt = i;
  }
  dfs(rt, 0);
  sort(dep + 1, dep + n + 1);
  for (i = n; i; --i) {
    if (d[dep[i].h] & 1)
      p[dep[i].h] = 0;
    else
      p[dep[i].h] = 1, --d[f[dep[i].h]];
    ;
    if (dep[i].h == rt && p[dep[i].h] == 0) {
      puts("NO");
      return 0;
    }
  }
  puts("YES");
  dfs1(rt);
  for (i = 1; i <= n; ++i) printf("%d\n", que[i]);
  return 0;
}
