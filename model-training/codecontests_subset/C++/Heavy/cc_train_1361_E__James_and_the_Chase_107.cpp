#include <bits/stdc++.h>
using namespace std;
int read() {
  int x = 0;
  bool flg = false;
  char ch = getchar();
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') flg = true;
  for (; isdigit(ch); ch = getchar()) x = (x << 3) + (x << 1) + (ch ^ 48);
  return flg ? -x : x;
}
unsigned getrand() {
  static unsigned sd = time(0);
  return sd ^= sd >> 13, sd ^= sd << 28, sd ^= sd >> 24, sd ^= sd << 7;
}
const int INF = 1e9;
int n, m;
vector<int> e[100010];
bool inq[100010], vis[100010];
bool dfs0(int x) {
  inq[x] = vis[x] = 1;
  for (const int &y : e[x]) {
    if (vis[y] && !inq[y]) return 0;
    if (!vis[y] && !dfs0(y)) return 0;
  }
  inq[x] = 0;
  return 1;
}
int lk[100010];
bool ok[100010];
inline void check(pair<int, int> &x, const pair<int, int> &y) {
  if (y.first < x.first)
    x.second = x.first, x.first = y.first;
  else if (y.first < x.second)
    x.second = y.first;
  if (y.second < x.first)
    x.second = x.first, x.first = y.second;
  else if (y.second < x.second)
    x.second = y.second;
}
inline void check(pair<int, int> &x, const int &y) {
  if (y < x.first)
    x.second = x.first, x.first = y;
  else if (y < x.second)
    x.second = y;
}
int dep[100010];
void dfs1(int x, int d) {
  dep[x] = d;
  vis[x] = 1;
  for (const int &y : e[x])
    if (!vis[y]) dfs1(y, d + 1);
}
pair<int, int> dfs2(int x) {
  vis[x] = 1;
  ok[x] = 1, lk[x] = -1;
  pair<int, int> z(INF, INF);
  for (const int &y : e[x]) {
    if (vis[y])
      check(z, dep[y]);
    else {
      check(z, dfs2(y));
    }
  }
  assert(z.first < dep[x]);
  if (z.second < dep[x])
    ok[x] = 0;
  else
    lk[x] = z.first;
  return z;
}
int stk[100010], top;
vector<int> S;
void dfs3(int x) {
  stk[++top] = x;
  vis[x] = 1;
  if (~lk[x]) ok[x] = ok[stk[lk[x]]];
  if (ok[x]) S.push_back(x);
  for (const int &y : e[x])
    if (!vis[y]) dfs3(y);
  --top;
}
void check(int x) {
  for (int i(1); i <= int(n); i++) vis[i] = 0;
  dfs1(x, 1);
  ok[x] = 1, lk[x] = -1;
  for (int i(1); i <= int(n); i++) vis[i] = 0;
  vis[x] = 1;
  for (const int &y : e[x]) dfs2(y);
  for (int i(1); i <= int(n); i++) vis[i] = 0;
  S.clear();
  top = 0;
  dfs3(x);
  if (S.size() * 5 < n)
    puts("-1");
  else {
    sort((S).begin(), (S).end());
    for (int x : S) printf("%d ", x);
    puts("");
  }
}
void solve() {
  n = read(), m = read();
  for (int i(1); i <= int(n); i++) e[i].clear();
  while (m--) {
    int u = read(), v = read();
    e[u].push_back(v);
  }
  for (int T(1); T <= int(100); T++) {
    int x = getrand() % n + 1;
    for (int i(1); i <= int(n); i++) inq[i] = vis[i] = 0;
    if (dfs0(x) == 0) continue;
    check(x);
    return;
  }
  puts("-1");
}
int main() {
  for (int T = read(); T--;) solve();
  return 0;
}
