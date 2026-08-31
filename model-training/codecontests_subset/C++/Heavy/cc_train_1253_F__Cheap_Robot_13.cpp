#include <bits/stdc++.h>
using namespace std;
const long double pi = 3.1415926535897932384626433832795l;
template <typename T>
inline auto sqr(T x) -> decltype(x * x) {
  return x * x;
}
template <typename T>
inline T abs(T x) {
  return x > T() ? x : -x;
}
template <typename T1, typename T2>
inline bool umx(T1& a, T2 b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <typename T1, typename T2>
inline bool umn(T1& a, T2 b) {
  if (b < a) {
    a = b;
    return 1;
  }
  return 0;
}
const int N = 300100;
const long long inf = (1ll << 60);
int p[N];
int sz[N];
int k;
bool out[N];
vector<pair<int, int> > a[N];
int get(int a) {
  if (a == p[a]) {
    return a;
  }
  return p[a] = get(p[a]);
}
bool uni(int l, int r) {
  l = get(l), r = get(r);
  if (l == r) {
    return false;
  }
  if (l >= k && r < k) {
    swap(l, r);
  } else {
    if (sz[l] < sz[r]) {
      swap(l, r);
    }
  }
  p[r] = l;
  sz[l] += sz[r];
  return true;
}
pair<long long, int> d[N];
set<pair<long long, int> > s;
vector<pair<long long, int> > b[N];
int tw[20][N];
long long maxx[20][N];
int h[N];
void dfs(int v, pair<long long, int> pr, int h1) {
  ;
  h[v] = h1;
  maxx[0][v] = pr.first;
  tw[0][v] = pr.second;
  for (int i = int(0); i < int(((int)(b[v]).size())); ++i) {
    int to = b[v][i].second;
    if (to == pr.second) {
      continue;
    }
    dfs(to, make_pair(b[v][i].first, v), h1 + 1);
  }
}
int up(int v, int h) {
  for (int i = int(0); i < int(20); ++i) {
    if (h & (1 << i)) {
      v = tw[i][v];
    }
  }
  return v;
}
int get_lca(int u, int v) {
  if (h[u] > h[v]) {
    swap(u, v);
  }
  v = up(v, h[v] - h[u]);
  if (u == v) {
    return u;
  }
  for (int i = int(20) - 1; i >= int(0); --i) {
    if (tw[i][v] != tw[i][u]) {
      v = tw[i][v];
      u = tw[i][u];
    }
  }
  return tw[0][v];
}
long long get_max_up(int v, int h) {
  long long result = 0ll;
  for (int i = int(0); i < int(20); ++i) {
    if (h & (1 << i)) {
      umx(result, maxx[i][v]);
      v = tw[i][v];
    }
  }
  return result;
}
long long get_maxx(int u, int v) {
  int lca = get_lca(u, v);
  ;
  ;
  return max(get_max_up(u, h[u] - h[lca]), get_max_up(v, h[v] - h[lca]));
}
void precalc() {
  for (int i = int(1); i < int(20); ++i) {
    for (int j = int(0); j < int(k); ++j) {
      int mid = tw[i - 1][j];
      tw[i][j] = tw[i - 1][mid];
      maxx[i][j] = max(maxx[i - 1][j], maxx[i - 1][mid]);
    }
  }
}
int main() {
  std::ios::sync_with_stdio(false);
  std::cin.tie(nullptr);
  cout.setf(ios::showpoint | ios::fixed);
  cout.precision(20);
  int n, m, q;
  cin >> n >> m >> k >> q;
  for (int i = int(0); i < int(m); ++i) {
    int u, v, c;
    cin >> u >> v >> c;
    --u, --v;
    a[u].push_back(make_pair(v, c));
    a[v].push_back(make_pair(u, c));
  }
  for (int i = int(0); i < int(n); ++i) {
    p[i] = i;
    sz[i] = 1;
    if (i < k) {
      d[i] = make_pair(0ll, i);
    } else {
      d[i] = make_pair(inf, inf);
    }
    s.insert(make_pair(d[i].first, i));
  }
  memset(out, 0, sizeof(out));
  while (!s.empty()) {
    pair<long long, int> k = *s.begin();
    s.erase(k);
    int v = k.second;
    out[v] = true;
    for (int i = int(0); i < int(((int)(a[v]).size())); ++i) {
      int to = a[v][i].first;
      long long cost = a[v][i].second;
      if (d[to].first > d[v].first + cost) {
        s.erase(make_pair(d[to].first, to));
        d[to].first = d[v].first + cost;
        d[to].second = d[v].second;
        s.insert(make_pair(d[to].first, to));
      }
    }
  }
  vector<pair<long long, pair<int, int> > > e;
  for (int i = int(0); i < int(n); ++i) {
    for (int j = int(0); j < int(((int)(a[i]).size())); ++j) {
      int to = a[i][j].first;
      long long cost = a[i][j].second;
      e.push_back(make_pair(d[i].first + d[to].first + cost,
                            make_pair(d[to].second, d[i].second)));
    }
  }
  sort((e).begin(), (e).end());
  for (int i = int(0); i < int(((int)(e).size())); ++i) {
    int u = e[i].second.first, v = e[i].second.second;
    if (uni(u, v)) {
      ;
      b[u].push_back(make_pair(e[i].first, v));
      b[v].push_back(make_pair(e[i].first, u));
    }
  }
  dfs(0, make_pair(0ll, 0), 0);
  precalc();
  for (int i = int(0); i < int(q); ++i) {
    int st, fn;
    cin >> st >> fn;
    --st, --fn;
    cout << get_maxx(st, fn) << "\n";
  }
  return 0;
}
