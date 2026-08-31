#include <bits/stdc++.h>
inline int rint() {
  int x = 0;
  char s = getchar();
  for (; s < '0' || '9' < s; s = getchar())
    ;
  for (; '0' <= s && s <= '9'; s = getchar()) x = x * 10 + (s ^ '0');
  return x;
}
template <typename Tp>
inline void wint(Tp x) {
  if (x < 0) putchar('-'), x = -x;
  if (9 < x) wint(x / 10);
  putchar(x % 10 ^ '0');
}
const int MAXN = 2e5;
int n, s, ecnt = 1, a[MAXN + 5], tmp[MAXN + 5], rk[MAXN + 5],
          head[MAXN * 2 + 5];
bool vis[MAXN + 5];
struct Edge {
  int to, nxt;
} graph[MAXN * 2 + 5];
std::vector<std::vector<int> > ans;
inline void link(const int s, const int t) {
  graph[++ecnt].to = t, graph[ecnt].nxt = head[s];
  head[s] = ecnt;
}
inline void findEC(const int u, std::vector<int>& res) {
  if (u <= n) vis[u] = true;
  for (int &i = head[u], v; i;) {
    v = graph[i].to, i = graph[i].nxt;
    findEC(v, res);
  }
  if (u <= n) res.push_back(u);
}
inline void printEC(const std::vector<int>& path) {
  for (int i = path.size() - 1; ~i; --i) {
    wint(path[i]);
    if (i) putchar(' ');
  }
}
int main() {
  n = rint(), s = rint();
  for (int i = 1; i <= n; ++i) a[i] = tmp[i] = rint();
  std::sort(tmp + 1, tmp + n + 1);
  int mx = std::unique(tmp + 1, tmp + n + 1) - tmp - 1;
  for (int i = 1; i <= n; ++i) {
    a[i] = std::lower_bound(tmp + 1, tmp + mx + 1, a[i]) - tmp;
    ++rk[a[i]];
  }
  for (int i = 2; i <= mx; ++i) rk[i] += rk[i - 1];
  int cnt = 0;
  for (int i = 1; i <= n; ++i) {
    if (rk[a[i] - 1] < i && i <= rk[a[i]]) continue;
    link(i, n + a[i]), ++cnt;
  }
  if ((s -= cnt) < 0) return puts("-1"), 0;
  for (int i = 1; i <= mx; ++i) {
    for (int j = rk[i - 1] + 1; j <= rk[i]; ++j) {
      if (a[j] == i) continue;
      link(n + i, j);
    }
  }
  std::vector<int> tmp;
  for (int i = 1; i <= n; ++i) {
    if (!vis[i]) {
      tmp.clear();
      findEC(i, tmp);
      if (tmp.size() == 1) continue;
      tmp.pop_back();
      ans.push_back(tmp);
    }
  }
  int sz = ans.size();
  if (s > sz) s = sz;
  int norid = 0;
  if (s > 2) sz += 2 - s;
  wint(sz), putchar('\n');
  if (s > 2) {
    int firs = 0;
    for (int i = 0; i < s; ++i) firs += ans[i].size();
    wint(firs), putchar('\n');
    for (int i = 0; i < s; ++i) {
      printEC(ans[i]), putchar(i + 1 < s ? ' ' : '\n');
    }
    wint(s), putchar('\n');
    wint(ans[0].back());
    for (int i = s - 1; i; --i) {
      putchar(' '), wint(ans[i].back());
    }
    putchar('\n');
    norid = s;
  }
  for (; norid ^ ans.size(); ++norid) {
    wint(ans[norid].size()), putchar('\n');
    printEC(ans[norid]), putchar('\n');
  }
  return 0;
}
