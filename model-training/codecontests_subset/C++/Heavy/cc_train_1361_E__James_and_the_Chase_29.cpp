#include <bits/stdc++.h>
using namespace std;
const long long maxn = 2e5 + 100;
const long long inf = 0x3f3f3f3f;
const long long iinf = 1 << 30;
const long long linf = 2e18;
const long long mod = 998244353;
const double eps = 1e-7;
template <class T = long long>
T chmin(T &a, T b) {
  return a = min(a, b);
}
template <class T = long long>
T chmax(T &a, T b) {
  return a = max(a, b);
}
template <class T = long long>
inline void red(T &x) {
  x -= mod, x += x >> 31 & mod;
}
template <class T = long long>
T read() {
  T f = 1, a = 0;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    a = (a << 3) + (a << 1) + ch - '0';
    ch = getchar();
  }
  return a * f;
}
mt19937 mrand(chrono::high_resolution_clock::now().time_since_epoch().count());
long long rnd(long long x) { return mrand() % x + 1; }
long long rnd(long long l, long long r) { return l + rnd(r - l) - 1; }
long long t, n, m, flag;
vector<long long> edge[maxn], ans;
long long vis[maxn];
void dfs(long long now) {
  vis[now] = 1;
  for (long long to : edge[now]) {
    if (!vis[to])
      dfs(to);
    else if (vis[to] == 2)
      flag = 0;
  }
  vis[now] = 2;
}
long long bad[maxn];
long long dep[maxn], top[maxn], cnt[maxn];
void dfs2(long long now) {
  vis[now] = 1, top[now] = now;
  for (long long to : edge[now]) {
    if (vis[to]) {
      ++cnt[now], --cnt[to];
      if (dep[to] < dep[top[now]]) top[now] = to;
    } else {
      dep[to] = dep[now] + 1;
      dfs2(to);
      cnt[now] += cnt[to];
      if (dep[top[to]] < dep[top[now]]) top[now] = top[to];
    }
  }
  if (cnt[now] > 1) bad[now] = 1;
}
void dfs3(long long now) {
  vis[now] = 1;
  if (!bad[now] && bad[top[now]]) bad[now] = 1;
  for (long long to : edge[now]) {
    if (vis[to]) continue;
    dfs3(to);
  }
}
void solve() {
  for (long long i = (1); i <= (n); ++i)
    vis[i] = bad[i] = dep[i] = top[i] = cnt[i] = 0,
    vector<long long>().swap(edge[i]);
  n = read(), m = read();
  for (long long i = (1); i <= (m); ++i) {
    long long u = read(), v = read();
    edge[u].push_back(v);
  }
  long long rt = -1;
  for (long long i = (1); i <= (100); ++i) {
    long long now = rnd(n);
    for (long long j = (1); j <= (n); ++j) vis[j] = 0;
    flag = 1;
    dfs(now);
    if (flag) {
      rt = now;
      break;
    }
  }
  if (rt == -1) return (void)(puts("-1"));
  for (long long i = (1); i <= (n); ++i) vis[i] = 0;
  dfs2(rt);
  for (long long i = (1); i <= (n); ++i) vis[i] = 0;
  dfs3(rt);
  vector<long long>().swap(ans);
  for (long long i = (1); i <= (n); ++i)
    if (!bad[i]) ans.push_back(i);
  if (5 * ((long long)ans.size()) >= n) {
    for (long long i : ans) printf("%lld ", i);
    putchar('\n');
    return;
  }
  puts("-1");
}
signed main() {
  t = read();
  while (t--) solve();
  return 0;
}
