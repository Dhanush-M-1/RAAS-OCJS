#include <bits/stdc++.h>
using namespace std;
const int N = 520233;
int n, s, a[N], b[N];
int fa[N];
int Find(int x) { return (fa[x] == x) ? x : (fa[x] = Find(fa[x])); }
map<int, int> mp;
bool Merge(int x, int y) {
  if (Find(x) != Find(y)) {
    fa[Find(x)] = Find(y);
    return true;
  }
  return false;
}
int p[N], cnt;
vector<int> v[N];
bool vis[N];
void Dfs(int u) {
  v[cnt].emplace_back(u);
  vis[u] = true;
  if (!vis[p[u]]) Dfs(p[u]);
}
map<int, vector<int> > lst;
map<int, int> rec;
int main() {
  scanf("%d%d", &n, &s);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", a + i);
    b[i] = a[i];
    fa[i] = i;
  }
  sort(b + 1, b + n + 1);
  int least = 0;
  for (int i = 1; i <= n; ++i)
    if (a[i] != b[i]) {
      ++least;
      lst[b[i]].emplace_back(i);
    }
  if (least > s) {
    puts("-1");
    return 0;
  } else if (!least) {
    puts("0");
    return 0;
  }
  for (int i = 1; i <= n; ++i)
    if (a[i] != b[i]) {
      vector<int>& v = lst[a[i]];
      p[i] = v.back();
      Merge(i, p[i]);
      v.pop_back();
    }
  for (int i = 1; i <= n; ++i)
    if (a[i] != b[i]) {
      int& t = rec[a[i]];
      if (t && Merge(i, t)) swap(p[i], p[t]);
      t = i;
    }
  for (int i = 1; i <= n; ++i)
    if (a[i] != b[i] && !vis[i]) {
      ++cnt;
      Dfs(i);
    }
  int q = s - least;
  if (q > 1)
    --q;
  else
    q = 0;
  q = min(q, cnt - 1);
  if (q) {
    printf("%d\n", cnt - q + 1);
    int sm = 0;
    for (int i = 1; i <= q + 1; ++i) sm += v[i].size();
    printf("%d\n", sm);
    for (int i = 1; i <= q + 1; ++i)
      for (int j : v[i]) printf("%d ", j);
    putchar('\n');
    printf("%d\n", q + 1);
    for (int i = q + 1; i; --i) printf("%d ", v[i][0]);
    putchar('\n');
    for (int i = q + 2; i <= cnt; ++i) {
      printf("%d\n", (int)v[i].size());
      for (int j : v[i]) printf("%d ", j);
      putchar('\n');
    }
  } else {
    printf("%d\n", cnt);
    for (int i = 1; i <= cnt; ++i) {
      printf("%d\n", (int)v[i].size());
      for (int j : v[i]) printf("%d ", j);
      putchar('\n');
    }
  }
  return 0;
}
