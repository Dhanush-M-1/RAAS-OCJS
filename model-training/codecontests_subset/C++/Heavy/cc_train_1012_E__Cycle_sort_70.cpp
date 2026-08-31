#include <bits/stdc++.h>
using namespace std;
const long long N = 200005;
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
long long read() {
  long long x;
  cin >> x;
  return x;
}
struct dsu {
  vector<long long> par, sz;
  long long cc;
  void init(long long n) {
    par.assign(n + 5, 0);
    sz.assign(n + 5, 0);
    cc = n;
    for (long long i = 0; i < n + 5; i++) par[i] = i, sz[i] = 1;
  }
  long long find(long long x) {
    if (par[x] == x) return x;
    return par[x] = find(par[x]);
  }
  void uni(long long x, long long y) {
    x = find(x);
    y = find(y);
    if (x != y) {
      sz[y] += sz[x];
      sz[x] = 0;
      par[x] = y;
      cc--;
    }
  }
} d;
long long n, m;
vector<pair<long long, long long> > a, b;
long long out[N], in[N];
void addEdge(long long u, long long v) {
  out[u] = v;
  in[v] = u;
  d.uni(u, v);
}
void con(long long u, long long v) {
  long long outu = out[u], outv = out[v];
  addEdge(u, outv);
  addEdge(v, outu);
}
void noAnswer() {
  cout << -1 << '\n';
  exit(0);
}
vector<vector<long long> > ans;
void makeAns() {
  vector<bool> used(N, 0);
  for (long long i = (long long)0; i <= (long long)n - 1; i++) {
    long long u = d.find(i);
    if (d.sz[u] == 1 || used[u]) continue;
    used[u] = true;
    long long root = u;
    vector<long long> cur;
    cur.push_back(u);
    while (out[u] != root) {
      u = out[u];
      cur.push_back(u);
    }
    ans.push_back(cur);
  }
  cout << ans.size() << '\n';
  for (auto &it : ans) {
    cout << it.size() << '\n';
    for (auto &it2 : it) cout << it2 + 1 << ' ';
    cout << '\n';
  }
  exit(0);
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m;
  d.init(n);
  set<pair<long long, long long> > st;
  vector<long long> _a;
  for (long long i = (long long)1; i <= (long long)n; i++) {
    pair<long long, long long> it = make_pair(read(), i - 1);
    a.push_back(it);
    st.insert(it);
    _a.push_back(it.first);
  }
  sort(_a.begin(), _a.end());
  for (long long i = (long long)0; i <= (long long)n - 1; i++)
    if (_a[i] == a[i].first) st.erase(a[i]);
  for (long long i = (long long)0; i <= (long long)n - 1; i++) {
    if (_a[i] == a[i].first)
      b.push_back(a[i]);
    else {
      auto it = st.lower_bound(make_pair(_a[i], -1));
      b.push_back(*it);
      st.erase(it);
      addEdge(b[i].second, i);
    }
  }
  pair<long long, long long> last = make_pair(-1, -1);
  for (long long i = (long long)0; i <= (long long)b.size() - 1; i++) {
    auto &it = b[i];
    if (d.sz[d.find(it.second)] == 1) continue;
    if (last.first != -1 && last.first == it.first &&
        d.find(last.second) != d.find(it.second))
      con(last.second, it.second);
    last = it;
  }
  vector<bool> used(N, 0);
  vector<long long> all;
  long long sz = 0;
  for (long long i = (long long)0; i <= (long long)n - 1; i++) {
    long long u = d.find(i);
    if (d.sz[u] == 1 || used[u]) continue;
    used[u] = true;
    sz += d.sz[u];
    all.push_back(u);
  }
  if (sz > m) noAnswer();
  m -= sz;
  m = min(m, (long long)all.size());
  if (m >= 3) {
    vector<long long> cur;
    for (long long i = (long long)0; i <= (long long)m - 1; i++) {
      if (!cur.empty()) con(cur.front(), all[i]);
      cur.push_back(all[i]);
    }
    ans.push_back(cur);
  }
  makeAns();
}
