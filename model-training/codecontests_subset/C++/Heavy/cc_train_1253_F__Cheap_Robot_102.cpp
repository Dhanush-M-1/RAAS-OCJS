#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 100;
const long long M = 21;
const long long mod = 1e9 + 7;
const long long MOD = 998244353;
const long long P = 1336;
const long double eps = 0.000000001;
const long long inf = 1e16 + 7;
mt19937 gen(chrono::high_resolution_clock::now().time_since_epoch().count());
vector<pair<long long, long long> > g[N], ng[N];
long long sz[N], pr[N], tin[N], tout[N];
long long tim = 0;
pair<long long, long long> w[N][M];
long long r[N];
long long get(long long v) {
  if (pr[v] == v) return v;
  return pr[v] = get(pr[v]);
}
void unite(long long a, long long b) {
  a = get(a);
  b = get(b);
  if (a == b) return;
  if (sz[a] < sz[b]) swap(a, b);
  sz[a] += sz[b];
  pr[b] = a;
}
void DFS(long long v, long long pr, long long zn) {
  w[v][0].first = pr;
  w[v][0].second = zn;
  for (long long i = 1; i < M; i++) {
    w[v][i].first = w[w[v][i - 1].first][i - 1].first;
    w[v][i].second =
        max(w[v][i - 1].second, w[w[v][i - 1].first][i - 1].second);
  }
  tim++;
  tin[v] = tim;
  for (auto to : ng[v]) {
    if (to.first == pr) continue;
    DFS(to.first, v, to.second);
  }
  tim++;
  tout[v] = tim;
}
bool upper(long long a, long long b) {
  return ((tin[a] <= tin[b]) && (tout[a] >= tout[b]));
}
long long LCA(long long a, long long b) {
  if (upper(b, a)) swap(a, b);
  long long mx = 0;
  for (long long i = M - 1; i >= 0; i--) {
    if (!upper(w[b][i].first, a)) {
      mx = max(mx, w[b][i].second);
      b = w[b][i].first;
    }
  }
  mx = max(mx, w[b][0].second);
  b = w[b][0].first;
  for (long long i = M - 1; i >= 0; i--) {
    if (!upper(w[a][i].first, b)) {
      mx = max(mx, w[a][i].second);
      a = w[a][i].first;
    }
  }
  if (a != b) mx = max(mx, w[a][0].second);
  return mx;
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  srand(time(0));
  long long n, m, k, T;
  cin >> n >> m >> k >> T;
  for (long long i = 0; i < m; i++) {
    long long x, y, z;
    cin >> x >> y >> z;
    x--;
    y--;
    g[x].push_back({y, z});
    g[y].push_back({x, z});
  }
  for (long long i = 0; i < n; i++) {
    r[i] = inf;
  }
  priority_queue<pair<long long, long long> > q;
  for (long long i = 0; i < k; i++) {
    q.push({0, i});
  }
  while (!q.empty()) {
    long long v = q.top().second;
    long long ra = q.top().first;
    ra = -ra;
    q.pop();
    if (ra > r[v]) continue;
    r[v] = ra;
    for (auto to : g[v]) {
      if (r[to.first] > r[v] + to.second) {
        r[to.first] = r[v] + to.second;
        q.push({-r[to.first], to.first});
      }
    }
  }
  vector<pair<long long, pair<long long, long long> > > e;
  for (long long i = 0; i < n; i++) {
    for (auto to : g[i]) {
      e.push_back({r[i] + r[to.first] + to.second, {i, to.first}});
    }
  }
  for (long long i = 0; i < n; i++) {
    pr[i] = i;
    sz[i] = 1;
  }
  sort(e.begin(), e.end());
  for (auto to : e) {
    if (get(to.second.first) != get(to.second.second)) {
      unite(to.second.first, to.second.second);
      ng[to.second.first].push_back({to.second.second, to.first});
      ng[to.second.second].push_back({to.second.first, to.first});
    }
  }
  DFS(0, 0, 0);
  while (T--) {
    long long a, b;
    cin >> a >> b;
    a--;
    b--;
    cout << LCA(a, b) << '\n';
  }
}
