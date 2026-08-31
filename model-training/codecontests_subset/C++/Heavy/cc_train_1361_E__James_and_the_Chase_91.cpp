#include <bits/stdc++.h>
const int max_N = 102401;
int n, m, dfn[max_N], Idfn[max_N], fa[max_N], dep[max_N];
std::vector<int> G[max_N], ans;
bool ok, ins[max_N];
int read() {
  char c = getchar();
  int ans = 0;
  bool flag = true;
  while (!isdigit(c)) flag &= (c != '-'), c = getchar();
  while (isdigit(c)) ans = 10 * ans + c - '0', c = getchar();
  return flag ? ans : -ans;
}
void Write(int x) {
  if (x < 0) putchar('-'), x = -x;
  if (x < 10)
    putchar(x + '0');
  else
    Write(x / 10), putchar(x % 10 + '0');
}
int min(int x, int y) { return x < y ? x : y; }
int max(int x, int y) { return x > y ? x : y; }
void _min(int &x, int y) {
  if (x > y) x = y;
}
void _max(int &x, int y) {
  if (x < y) x = y;
}
std::mt19937_64 rnd(
    std::chrono::steady_clock::now().time_since_epoch().count());
int Random(int l, int r) { return rnd() % (r - l + 1) + l; }
void dfs1(int x) {
  Idfn[dfn[x] = ++*dfn] = x, ins[x] = true;
  for (auto i : G[x])
    if (!dfn[i])
      fa[i] = x, dep[i] = dep[x] + 1, dfs1(i);
    else if (dfn[i] && !ins[i])
      ok = false;
  ins[x] = false;
}
bool check(int x) {
  ok = true;
  std::fill(dfn + 1, dfn + n + 1, 0);
  for (int i = 1; i <= n; i++) assert(!ins[i]);
  if (*dfn = 0, dep[x] = 0, dfs1(x), *dfn < n) return false;
  for (int i = 1; i <= n; i++)
    for (auto j : G[i])
      if (dfn[i] < dfn[j] && fa[j] != i) return false;
  return ok;
}
void solve(int x) {
  static bool flag[max_N];
  static int num[max_N], link[max_N];
  for (int i = 1; i <= n; i++) flag[i] = false, num[i] = link[i] = 0;
  flag[x] = true, ans.push_back(x);
  for (int i = n; i > 1; i--) {
    for (auto j : G[Idfn[i]])
      if (dfn[j] > i) {
        num[Idfn[i]] += num[j];
        if (!link[Idfn[i]] || dep[link[Idfn[i]]] > dep[link[j]])
          link[Idfn[i]] = link[j];
      }
    for (auto j : G[Idfn[i]])
      if (dfn[j] < i) {
        num[Idfn[i]]++, num[j]--;
        if (!link[Idfn[i]] || dep[link[Idfn[i]]] > dep[j]) link[Idfn[i]] = j;
      }
  }
  for (int i = 2; i <= n; i++)
    if (num[Idfn[i]] == 1 && flag[link[Idfn[i]]])
      flag[Idfn[i]] = true, ans.push_back(Idfn[i]);
  std::sort(ans.begin(), ans.end());
}
void clear() {
  for (int i = 1; i <= n; i++)
    G[i].clear(), dfn[i] = Idfn[i] = dep[i] = fa[i] = 0;
  ans.clear();
}
int main() {
  int q = read();
  while (q--) {
    n = read(), m = read();
    for (int i = 1, u, v; i <= m; i++)
      u = read(), v = read(), G[u].push_back(v);
    for (int _ = 1; _ <= 100; _++) {
      int x = Random(1, n);
      if (check(x)) {
        solve(x);
        break;
      }
    }
    if (ans.size() >= (n + 4) / 5)
      for (auto i : ans) Write(i), putchar(' ');
    else
      putchar('-'), putchar('1');
    putchar('\n');
    clear();
  }
  return 0;
}
