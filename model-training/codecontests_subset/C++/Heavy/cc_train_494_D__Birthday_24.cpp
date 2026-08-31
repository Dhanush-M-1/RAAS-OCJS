#include <bits/stdc++.h>
using namespace std;
const long long N = 100005;
template <class T1, class T2>
ostream &operator<<(ostream &os, const pair<T1, T2> &a) {
  return os << '(' << a.first << ", " << a.second << ')';
}
template <class T>
ostream &operator<<(ostream &os, const vector<T> &a) {
  os << '[';
  for (unsigned long long i = 0; i < a.size(); i++)
    os << a[i] << (i < a.size() - 1 ? ", " : "");
  os << ']';
  return os;
}
long long n;
vector<vector<pair<long long, long long> > > a(N);
const long long mod = 1e9 + 7;
void norm(long long &x) {
  x %= mod;
  x += (x < 0 ? mod : 0);
}
struct LCAOn {
  pair<long long, long long> tour[2 * N], rmq[2 * N][22];
  long long depth[N], par[N], dis[N], sta[N], en[N], lg2[2 * N], Time = 0;
  bool firstTime = true;
  void dfs(long long u, long long p) {
    tour[++Time] = {depth[u], u};
    sta[u] = Time;
    par[u] = p;
    for (auto v : a[u])
      if (v.first != p)
        depth[v.first] = depth[u] + 1, dis[v.first] = dis[u] + v.second,
        dfs(v.first, u);
    tour[++Time] = {depth[u], u};
    en[u] = Time;
  }
  void build_rmq() {
    for (long long i = 1; i <= Time; ++i) rmq[i][0] = tour[i];
    for (long long j = 1; (1 << j) <= Time; ++j)
      for (long long i = 1; i + (1 << j) - 1 <= Time; ++i)
        rmq[i][j] = min(rmq[i][j - 1], rmq[i + (1 << (j - 1))][j - 1]);
  }
  long long lca(long long u, long long v) {
    if (sta[v] < sta[u]) swap(u, v);
    if (en[u] >= en[v]) return u;
    long long dist = lg2[sta[v] - en[u] + 1];
    auto ans = min(rmq[en[u]][dist], rmq[sta[v] - (1 << dist) + 1][dist]);
    return par[ans.second];
  }
  long long distance(long long u, long long v) {
    long long p = lca(u, v);
    long long ret = dis[u] + dis[v] - 2 * dis[p];
    norm(ret);
    return ret;
  }
  void init() {
    if (firstTime)
      for (long long i = 1; i < 2 * N; i++) lg2[i] = log2(i);
    firstTime = false;
    Time = 0;
    dfs(1, 1);
    build_rmq();
  }
} LCA;
struct data {
  long long cnt, dis1, dis2;
  data(long long _cnt = 0, long long _dis1 = 0, long long _dis2 = 0)
      : cnt(_cnt), dis1(_dis1), dis2(_dis2){};
};
void norm(data &x) {
  norm(x.dis1);
  norm(x.dis2);
}
data up[N], down[N];
bool inSubtree(long long p, long long u) {
  if (LCA.lca(u, p) == p) return true;
  return false;
}
long long calAllTree(long long u) { return (up[u].dis2 + down[u].dis2) % mod; }
long long calInSub(long long root, long long u) {
  if (root == 1) return calAllTree(u);
  long long w = LCA.distance(root, u);
  long long ret =
      up[root].dis2 + 2 * w * up[root].dis1 + up[root].cnt * w % mod * w % mod;
  norm(ret);
  ret = calAllTree(u) - ret;
  norm(ret);
  return ret;
}
long long calOutSub(long long root, long long u) {
  long long w = LCA.distance(root, u);
  long long ret =
      down[root].dis2 + 2 * w * down[root].dis1 + down[root].cnt * w % mod * w;
  norm(ret);
  return ret;
}
void dfsUp(long long u, long long p) {
  auto cur = down[u];
  cur.cnt += up[u].cnt;
  cur.dis1 += up[u].dis1;
  cur.dis2 += up[u].dis2;
  norm(cur);
  for (auto it : a[u]) {
    long long v = it.first;
    long long w = it.second;
    if (v == p) continue;
    auto tmp = cur;
    tmp.cnt -= down[v].cnt;
    tmp.dis1 -= down[v].dis1 + w * down[v].cnt;
    tmp.dis2 -= down[v].dis2 + 2 * w * down[v].dis1 + down[v].cnt * w % mod * w;
    norm(tmp);
    up[v].cnt += tmp.cnt;
    up[v].dis1 += tmp.dis1 + w * tmp.cnt;
    up[v].dis2 += tmp.dis2 + 2 * w * tmp.dis1 + tmp.cnt * w % mod * w;
    norm(up[v]);
    dfsUp(v, u);
  }
}
void dfsDown(long long u, long long p) {
  for (auto it : a[u]) {
    long long v = it.first;
    long long w = it.second;
    if (v != p) {
      dfsDown(v, u);
      down[u].cnt += down[v].cnt;
      down[u].dis1 += down[v].dis1 + w * down[v].cnt;
      down[u].dis2 +=
          down[v].dis2 + 2 * w * down[v].dis1 + down[v].cnt * w % mod * w;
      norm(down[u]);
    }
  }
  down[u].cnt++;
}
void prepDis() {
  dfsDown(1, 1);
  dfsUp(1, 1);
}
void preCheck() {
  for (long long u = (long long)1; u <= (long long)n; u++) {
    long long tup = 0;
    long long tdown = 0;
    for (long long v = (long long)1; v <= (long long)n; v++) {
      if (inSubtree(u, v))
        tdown += LCA.distance(u, v) * LCA.distance(u, v) % mod;
      else
        tup += LCA.distance(u, v) * LCA.distance(u, v) % mod;
    }
    norm(tup);
    norm(tdown);
    assert(tup == up[u].dis2);
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (long long i = (long long)1; i <= (long long)n - 1; i++) {
    long long u, v, w;
    cin >> u >> v >> w;
    a[u].push_back(make_pair(v, w));
    a[v].push_back(make_pair(u, w));
  }
  LCA.init();
  prepDis();
  long long q;
  cin >> q;
  for (long long _ = (long long)1; _ <= (long long)q; _++) {
    long long u, v;
    cin >> u >> v;
    long long ret = 0;
    if (inSubtree(v, u))
      ret = 2 * calInSub(v, u) - calAllTree(u);
    else
      ret = 2 * calOutSub(v, u) - calAllTree(u);
    norm(ret);
    cout << ret << '\n';
  }
}
