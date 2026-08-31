#include <bits/stdc++.h>
using namespace std;
struct edge {
  long long u, v, w;
};
bool cmp(const edge &x, const edge &y) { return x.w < y.w; }
const long long N = 1e5 + 5;
long long start[N];
vector<pair<long long, long long>> adj[N];
long long length[N];
long long res[3 * N];
vector<pair<long long, long long>> query[N];
vector<long long> p(N, -1);
set<long long> nodes[N];
long long globalWeight;
long long find(long long x) { return p[x] < 0 ? x : p[x] = find(p[x]); }
void merge(long long x, long long y) {
  if ((x = find(x)) == (y = find(y))) return;
  if (p[y] < p[x]) swap(x, y);
  p[x] += p[y];
  p[y] = x;
  for (long long node : nodes[y]) {
    for (auto &qu : query[node]) {
      const long long otherNode = qu.first;
      const long long index = qu.second;
      if (nodes[x].count(otherNode)) {
        if (res[index] == -1) {
          res[index] = globalWeight;
        }
      }
    }
  }
  for (long long node : nodes[y]) {
    nodes[x].insert(node);
  }
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n, m, k, Q;
  cin >> n >> m >> k >> Q;
  for (long long i = 0; i < m; ++i) {
    long long u, v, w;
    cin >> u >> v >> w;
    adj[u].push_back({v, w});
    adj[v].push_back({u, w});
  }
  for (long long i = 1; i <= n; ++i) {
    nodes[i].insert(i);
    length[i] = 1e18;
  }
  set<pair<long long, long long>> q;
  for (long long i = 1; i <= k; ++i) {
    length[i] = 0;
    q.insert({0, i});
    start[i] = i;
  }
  vector<edge> arr;
  while (!q.empty()) {
    auto it = q.begin();
    long long node = it->second;
    q.erase(it);
    for (auto &p : adj[node]) {
      long long to = p.first;
      long long weight = p.second;
      if (length[to] > weight + length[node]) {
        q.erase({length[to], to});
        start[to] = start[node];
        length[to] = weight + length[node];
        q.insert({length[to], to});
      } else if (start[to] != start[node]) {
        arr.push_back(
            {start[to], start[node], weight + length[to] + length[node]});
      }
    }
  }
  sort(arr.begin(), arr.end(), cmp);
  for (long long i = 0; i < Q; ++i) {
    res[i] = -1;
    long long u, v;
    cin >> u >> v;
    query[u].push_back({v, i});
    query[v].push_back({u, i});
  }
  for (auto &e : arr) {
    globalWeight = e.w;
    merge(e.u, e.v);
  }
  for (long long i = 0; i < Q; ++i) {
    cout << res[i] << '\n';
  }
}
