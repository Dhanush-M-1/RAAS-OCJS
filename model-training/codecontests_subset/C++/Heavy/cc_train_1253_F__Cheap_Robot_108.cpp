#include <bits/stdc++.h>
using namespace std;
template <class S, class T>
ostream& operator<<(ostream& os, const pair<S, T>& p) {
  return os << "(" << p.first << ", " << p.second << ")";
}
template <class T>
ostream& operator<<(ostream& os, const vector<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
ostream& operator<<(ostream& os, const unordered_set<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class S, class T>
ostream& operator<<(ostream& os, const unordered_map<S, T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
ostream& operator<<(ostream& os, const set<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
ostream& operator<<(ostream& os, const multiset<T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class S, class T>
ostream& operator<<(ostream& os, const map<S, T>& p) {
  os << "[ ";
  for (auto& it : p) os << it << " ";
  return os << "]";
}
template <class T>
void dbs(string str, T t) {
  cerr << str << " : " << t << "\n";
}
template <class T, class... S>
void dbs(string str, T t, S... s) {
  long long idx = str.find(',');
  cerr << str.substr(0, idx) << " : " << t << ",";
  dbs(str.substr(idx + 1), s...);
}
template <class T>
void prc(T a, T b) {
  cerr << "[";
  for (T i = a; i != b; ++i) {
    if (i != a) cerr << ", ";
    cerr << *i;
  }
  cerr << "]\n";
}
long long power(long long x, long long y) {
  long long res = 1;
  while (y) {
    if (y & 1) res = (res * x) % 1000000007;
    y = y / 2, x = (x * x) % 1000000007;
  }
  return res % 1000000007;
}
struct UnionFind {
  long long n, set_size, *parent, *rank;
  UnionFind() {}
  UnionFind(long long a) {
    n = set_size = a;
    parent = new long long[n + 1];
    rank = new long long[n + 1];
    for (long long i = 1; i <= n; ++i) parent[i] = i, rank[i] = 1;
  }
  long long find(long long x) {
    if (x != parent[x]) return parent[x] = find(parent[x]);
    return x;
  }
  void merge(long long x, long long y) {
    long long xroot = find(x), yroot = find(y);
    if (xroot != yroot) {
      if (rank[xroot] >= rank[yroot]) {
        parent[yroot] = xroot;
        rank[xroot] += rank[yroot];
      } else {
        parent[xroot] = yroot;
        rank[yroot] += rank[xroot];
      }
      set_size -= 1;
    }
  }
  void reset() {
    set_size = n;
    for (long long i = 1; i <= n; i++) parent[i] = i, rank[i] = 1;
  }
  long long size() { return set_size; }
  void prll() {
    for (long long i = 1; i <= n; ++i) cout << i << " -> " << parent[i] << "\n";
  }
};
vector<vector<pair<long long, long long>>> g;
bool vis[100001];
long long dis[100001];
long long col[100001];
class prioritize {
 public:
  bool operator()(pair<long long, long long>& p1,
                  pair<long long, long long>& p2) {
    return p1.second > p2.second;
  }
};
vector<vector<pair<long long, long long>>> kconnect;
long long par[100100][19];
long long depth[100100];
long long dp[100100][19];
void dfs(long long nn, long long pp, long long dd, long long mm) {
  par[nn][0] = pp;
  dp[nn][0] = mm;
  depth[nn] = dd;
  for (long long i = 1; i <= 18; i++) {
    par[nn][i] = par[par[nn][i - 1]][i - 1];
    dp[nn][i] = max(dp[nn][i - 1], dp[par[nn][i - 1]][i - 1]);
  }
  for (auto v : kconnect[nn]) {
    if (v.first == pp) continue;
    dfs(v.first, nn, dd + 1, v.second);
  }
}
long long lcalol(long long u, long long v) {
  if (depth[u] < depth[v]) swap(u, v);
  long long ans = 0;
  for (long long i = 18; i >= 0; i--) {
    if (depth[u] - depth[v] >= (1LL << i))
      ans = max(ans, dp[u][i]), u = par[u][i];
  }
  if (u == v) return ans;
  for (long long i = 18; i >= 0; i--) {
    if (par[u][i] != par[v][i]) {
      ans = max(ans, max(dp[u][i], dp[v][i]));
      u = par[u][i];
      v = par[v][i];
    }
  }
  ans = max(ans, max(dp[u][0], dp[v][0]));
  return ans;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n, m, k, q, i;
  cin >> n >> m >> k >> q;
  g.resize(n + 1);
  set<pair<long long, pair<long long, long long>>> edges;
  for (long long i = 0; i < m; i++) {
    long long a, b, c;
    cin >> a >> b >> c;
    g[a].emplace_back(b, c);
    g[b].emplace_back(a, c);
  }
  for (long long i = 1; i <= n; i++) {
    vis[i] = 0;
    dis[i] = 1e18;
  }
  priority_queue<pair<long long, long long>, vector<pair<long long, long long>>,
                 prioritize>
      pq;
  for (i = 1; i <= k; i++) {
    pq.push(make_pair(i, 0));
    dis[i] = 0;
    col[i] = i;
  }
  while (!pq.empty()) {
    pair<long long, long long> top = pq.top();
    pq.pop();
    long long uu = top.first;
    long long vv = top.second;
    if (vis[uu]) continue;
    vis[uu] = 1;
    for (auto v : g[uu]) {
      if (vis[v.first]) {
        if (col[v.first] != col[uu]) {
          edges.insert(make_pair(dis[v.first] + dis[uu] + v.second,
                                 make_pair(min(col[uu], col[v.first]),
                                           max(col[uu], col[v.first]))));
        }
      } else {
        if (vv + v.second < dis[v.first]) {
          dis[v.first] = vv + v.second;
          col[v.first] = col[uu];
          pq.push(make_pair(v.first, dis[v.first]));
        }
      }
    }
  }
  kconnect.resize(k + 1);
  UnionFind uf(k);
  long long sz = k;
  for (auto v : edges) {
    if (uf.find(v.second.first) != uf.find(v.second.second)) {
      kconnect[v.second.first].emplace_back(v.second.second, v.first);
      kconnect[v.second.second].emplace_back(v.second.first, v.first);
      uf.merge(v.second.first, v.second.second);
      sz--;
    }
    if (sz == 1) break;
  }
  dfs(1, 0, 0, 0);
  for (long long i = 0; i < q; i++) {
    long long a, b;
    cin >> a >> b;
    cout << lcalol(a, b) << "\n";
  }
}
