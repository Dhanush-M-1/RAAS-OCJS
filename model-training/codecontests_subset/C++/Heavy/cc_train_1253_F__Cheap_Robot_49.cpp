#include <bits/stdc++.h>
using namespace std;
class DebugStream {
} LOG;
template <typename T>
DebugStream &operator<<(DebugStream &s, const T &) {
  return s;
}
mt19937 rnd(time(NULL));
const int maxN = 1e5 + 9, maxV = 1e6 + 9, MOD = 1e9 + 7, SQ = 335, lg = 20,
          bs = 29;
vector<pair<long long, long long>> adj[maxN];
vector<pair<long long, long long>> qrs[maxN];
int comp[maxN], n, k, m, q;
long long dst[maxN], ans[maxN * 3];
namespace DSU {
int comp[maxN];
void prepare() {
  for (int i = 0; i < n; i++) comp[i] = i;
}
int get(int u) {
  if (comp[u] != u) comp[u] = get(comp[u]);
  return comp[u];
}
void considerEdge(long long weight, int u, int v) {
  u = get(u), v = get(v);
  if (u == v) return;
  if (qrs[u].size() > qrs[v].size()) swap(u, v);
  for (auto el : qrs[u])
    if (get(el.second) == v)
      ans[el.first] = weight;
    else
      qrs[v].push_back(el);
  comp[u] = v;
}
}  // namespace DSU
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  priority_queue<pair<long long, pair<long long, long long>>,
                 vector<pair<long long, pair<long long, long long>>>,
                 greater<pair<long long, pair<long long, long long>>>>
      pq;
  cin >> n >> m >> k >> q;
  for (int i = 0; i < n; i++) {
    if (i < k)
      pq.push(pair<long long, pair<long long, long long>>(
          0, pair<long long, long long>(i, i)));
    comp[i] = -1;
  }
  for (long long i = 0, u, v, c; i < m; i++) {
    cin >> u >> v >> c, u--, v--;
    adj[u].push_back(pair<long long, long long>(c, v));
    adj[v].push_back(pair<long long, long long>(c, u));
  }
  for (int i = 0, u, v; i < q; i++) {
    cin >> u >> v;
    u--, v--;
    qrs[u].emplace_back(i, v);
    qrs[v].emplace_back(i, u);
  }
  while (pq.size()) {
    auto cr = pq.top();
    pq.pop();
    if (comp[cr.second.first] != -1) continue;
    comp[cr.second.first] = cr.second.second;
    dst[cr.second.first] = cr.first;
    for (auto sn : adj[cr.second.first])
      if (comp[sn.second] == -1)
        pq.push(pair<long long, pair<long long, long long>>(
            cr.first + sn.first,
            pair<long long, long long>(sn.second, cr.second.second)));
  }
  vector<pair<long long, pair<long long, long long>>> edg;
  DSU::prepare();
  for (int i = 0; i < n; i++)
    for (auto el : adj[i])
      if (comp[i] != comp[el.second])
        edg.emplace_back(dst[i] + dst[el.second] + el.first,
                         pair<long long, long long>(comp[i], comp[el.second]));
  sort(edg.begin(), edg.end());
  for (auto el : edg)
    DSU::considerEdge(el.first, el.second.first, el.second.second);
  for (int i = 0; i < q; i++) cout << ans[i] << '\n';
}
