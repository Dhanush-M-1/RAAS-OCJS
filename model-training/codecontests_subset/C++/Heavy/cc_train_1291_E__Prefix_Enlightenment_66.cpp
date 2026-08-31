#include <bits/stdc++.h>
using namespace std;
template <class T>
bool umin(T& a, const T& b) {
  return a > b ? a = b, true : false;
}
template <class T>
bool umax(T& a, const T& b) {
  return a < b ? a = b, true : false;
}
template <long long sz>
using tut = array<long long, sz>;
const long long N = 3e5 + 5;
const long long mod = 1e9 + 7;
const long long inf = 1e18;
const long double Pi = acos(-1);
const long long MX = 2e16;
long long n, m, k, t, q, ans, res, a[N];
long long in[N][2], cc[N], cnt[N][2];
long long par[N], sz[N];
vector<long long> edges[N];
string s;
void dfs(long long u) {
  cnt[u][cc[u]]++;
  for (auto x : edges[u]) {
    if (in[x][1] == -1) continue;
    long long to = in[x][0] + in[x][1] - u;
    if (~cc[to]) continue;
    cc[to] = cc[u] ^ (s[x] == '0');
    dfs(to);
  }
}
long long f(long long x) { return (par[x] == x ? x : par[x] = f(par[x])); }
void add(long long a, long long s0, long long s1) {
  a = f(a);
  res -= min(cnt[a][0], cnt[a][1]);
  cnt[a][0] += s0, cnt[a][1] += s1;
  res += min(cnt[a][0], cnt[a][1]);
}
void merge(long long a, long long b) {
  a = f(a), b = f(b);
  if (a == b) return;
  if (sz[b] > sz[a]) swap(a, b);
  add(a, cnt[b][0], cnt[b][1]);
  add(b, -cnt[b][0], -cnt[b][1]);
  sz[a] += sz[b], par[b] = a;
}
void solve(long long t_case) {
  cin >> n >> k >> s;
  s = '$' + s;
  memset(in, -1, sizeof in), memset(cc, -1, sizeof cc);
  for (long long i = 0; i < k; i++) {
    sz[i] = 1, par[i] = i;
    long long c;
    cin >> c;
    for (long long j = 0; j < c; j++) {
      long long x;
      cin >> x, edges[i].push_back(x);
      if (~in[x][0])
        in[x][1] = i;
      else
        in[x][0] = i;
    }
  }
  for (long long i = 0; i < k; i++) {
    if (~cc[i]) continue;
    cc[i] = 0, dfs(i);
  }
  for (long long i = 1; i <= n; i++) {
    long long c0 = in[i][0], c1 = in[i][1];
    if (~c0 && c1 == -1) {
      if (s[i] == '0') {
        if (cc[c0])
          add(c0, mod, 0);
        else
          add(c0, 0, mod);
      } else {
        if (cc[c0])
          add(c0, 0, mod);
        else
          add(c0, mod, 0);
      }
    }
    if (~c0 && ~c1) {
      merge(c0, c1);
    }
    cout << res << "\n";
  }
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  if (0) {
    long long t;
    cin >> t;
    for (long long t_case = 1; t_case <= t; t_case++) solve(t_case);
  } else
    solve(1);
  return 0;
}
