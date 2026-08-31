#include <bits/stdc++.h>
template <typename T>
bool ckmax(T &x, T y) {
  return x < y ? x = y, true : false;
}
template <typename T>
bool ckmin(T &x, T y) {
  return x > y ? x = y, true : false;
}
using namespace std;
const long long inf = 1000000000;
const double Pi = acos(-1);
const long long mod = 998244353;
const double eps = 1e-6;
inline long long fpow(long long a, long long b = mod - 2, long long p = mod) {
  a %= p;
  long long res = 1;
  while (b) {
    if (b & 1) res = 1ll * res * a % p;
    a = 1ll * a * a % p;
    b >>= 1;
  }
  return res;
}
inline long long read() {
  char c = getchar();
  long long x = 0;
  bool f = 0;
  for (; !isdigit(c); c = getchar()) f ^= !(c ^ 45);
  for (; isdigit(c); c = getchar()) x = (x << 1) + (x << 3) + (c ^ 48);
  if (f) x = -x;
  return x;
}
inline void write(long long x) {
  if (x < 0) {
    putchar('-');
    write(-x);
    return;
  }
  if (x >= 10) write(x / 10);
  putchar(x % 10 + '0');
}
inline void writesp(long long x) { write(x), putchar(' '); }
inline void writeln(long long x) {
  write(x);
  putchar('\n');
}
unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
mt19937 rand_num(seed);
uniform_int_distribution<long long> dist(0, 1223344556616251);
long long n, m, rt;
vector<long long> e[111111], g[111111], fz[111111], ans;
multiset<long long> st[111111];
long long fa[111111], bg[111111], en[111111], tim;
long long dp[111111], ffa[111111];
long long hson[111111];
void dfs1(long long u) {
  bg[u] = ++tim;
  for (long long v : e[u])
    if (!bg[v]) fa[v] = u, dfs1(v);
  en[u] = tim;
}
long long check(long long rt) {
  tim = fa[rt] = 0;
  for (long long i = (1), iE = (n); i <= iE; i++) bg[i] = 0;
  dfs1(rt);
  for (long long u = (1), uE = (n); u <= uE; u++) {
    for (long long v : e[u])
      if (fa[v] ^ u)
        if (bg[v] > bg[u] || en[v] < en[u]) return 0;
  }
  return 1;
}
void dfs2(long long u) {
  hson[u] = -1;
  for (long long v : g[u]) {
    dfs2(v);
    if (!~hson[u] || st[v].size() > st[hson[u]].size()) hson[u] = v;
  }
  if (~hson[u]) swap(st[u], st[hson[u]]);
  for (long long v : g[u])
    if (v ^ hson[u]) {
      for (auto it = st[v].begin(); it != st[v].end(); it++) st[u].insert(*it);
    }
  for (long long v : fz[u]) st[u].insert(v);
  while (st[u].find(u) != st[u].end()) st[u].erase(st[u].find(u));
  if ((long long)st[u].size() > 1)
    ffa[u] = 0;
  else if ((long long)st[u].size() == 1)
    ffa[u] = *st[u].begin();
}
void dfs3(long long u) {
  if (ffa[u] == -1)
    dp[u] = 1, ans.push_back(u);
  else if (!ffa[u])
    dp[u] = 0;
  else {
    dp[u] = dp[ffa[u]];
    if (dp[u]) ans.push_back(u);
  }
  for (long long v : g[u]) dfs3(v);
}
signed main() {
  for (long long _ = read(); _; _--) {
    n = read(), m = read();
    for (long long i = (1), iE = (n); i <= iE; i++) e[i].clear();
    long long u, v;
    for (long long i = (1), iE = (m); i <= iE; i++)
      u = read(), v = read(), e[u].push_back(v);
    rt = 0;
    for (long long i = 1; i <= 100 && (!rt); i++) {
      static long long u;
      u = dist(rand_num) % n + 1;
      if (check(u)) rt = u;
    }
    if (!rt) {
      puts("-1");
      continue;
    }
    ans.clear();
    for (long long i = (1), iE = (n); i <= iE; i++)
      g[i].clear(), fz[i].clear(), st[i].clear(), ffa[i] = -1, dp[i] = 0;
    for (long long u = (1), uE = (n); u <= uE; u++) {
      if (u ^ rt) g[fa[u]].push_back(u);
      for (long long v : e[u])
        if (fa[v] ^ u) fz[u].push_back(v);
    }
    dfs2(rt);
    dfs3(rt);
    if ((long long)ans.size() * 5 < n) {
      puts("-1");
      continue;
    }
    sort(ans.begin(), ans.end());
    for (long long x : ans) writesp(x);
    puts("");
  }
}
