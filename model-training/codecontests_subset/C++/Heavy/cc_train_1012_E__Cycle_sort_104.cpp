#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
int n, s, t, ans, a[N];
int p[N], fa[N];
pair<int, int> b[N];
int get(int x) { return x == fa[x] ? x : fa[x] = get(fa[x]); }
bool vis[N];
vector<int> c[N];
void dfs(int x) {
  vis[x] = 1;
  c[t].push_back(x);
  if (!vis[p[x]]) dfs(p[x]);
}
int main() {
  scanf("%d%d", &n, &s);
  for (int i = (int)(1); i <= (int)(n); i++) {
    scanf("%d", &a[i]);
    b[i] = pair<int, int>(a[i], i);
  }
  sort(b + 1, b + n + 1);
  for (int i = (int)(1); i <= (int)(n); i++) p[b[i].second] = i;
  for (int i = (int)(1); i <= (int)(n); i++)
    if (a[i] == b[i].first && p[i] != i) {
      p[b[i].second] = p[i];
      b[p[i]].second = b[i].second;
      p[i] = b[i].second = i;
    }
  for (int i = (int)(1); i <= (int)(n); i++) fa[i] = i;
  for (int i = (int)(1); i <= (int)(n); i++) fa[get(i)] = get(p[i]);
  int las = -1;
  for (int i = (int)(0); i <= (int)(n); i++) {
    if (p[b[i].second] == b[i].second) continue;
    if (las >= 0 && a[las] == a[b[i].second]) {
      int x = las, y = b[i].second;
      int X = get(x), Y = get(y);
      if (X != Y) fa[X] = Y, swap(p[x], p[y]);
    }
    las = b[i].second;
  }
  for (int i = (int)(1); i <= (int)(n); i++)
    if (!vis[i] && p[i] != i) ++t, dfs(i);
  for (int i = (int)(1); i <= (int)(t); i++) ans += c[i].size();
  if (ans > s) return puts("-1"), 0;
  s = min(s - ans, t);
  if (s <= 1) {
    printf("%d\n", t);
    for (int i = (int)(1); i <= (int)(t); i++) {
      printf("%d\n", c[i].size());
      for (int j = (int)(0); j <= (int)(c[i].size() - 1); j++)
        printf("%d ", c[i][j]);
      puts("");
    }
    return 0;
  }
  printf("%d\n", t - s + 2);
  for (int i = (int)(1); i <= (int)(t - s); i++) {
    printf("%d\n", c[i + s].size());
    for (int j = (int)(0); j <= (int)(c[i + s].size() - 1); j++)
      printf("%d ", c[i + s][j]);
    puts("");
    ans -= c[i + s].size();
  }
  printf("%d\n", ans);
  for (int i = (int)(1); i <= (int)(s); i++)
    for (int j = (int)(0); j <= (int)(c[i].size() - 1); j++)
      printf("%d ", c[i][j]);
  printf("\n%d\n", s);
  for (int i = (int)(s); i >= (int)(1); i--) printf("%d ", c[i][0]);
}
