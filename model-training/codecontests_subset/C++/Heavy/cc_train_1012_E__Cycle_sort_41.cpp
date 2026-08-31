#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using vi = vector<int>;
using vvi = vector<vi>;
using vll = vector<ll>;
using vvll = vector<vll>;
using vb = vector<bool>;
using vd = vector<double>;
using vs = vector<string>;
using pii = pair<int, int>;
using pll = pair<ll, ll>;
using pdd = pair<double, double>;
using vpii = vector<pii>;
using vvpii = vector<vpii>;
using vpll = vector<pll>;
using vvpll = vector<vpll>;
using vpdd = vector<pdd>;
using vvpdd = vector<vpdd>;
template <typename T>
void ckmin(T& a, const T& b) {
  a = min(a, b);
}
template <typename T>
void ckmax(T& a, const T& b) {
  a = max(a, b);
}
mt19937_64 rng(chrono::steady_clock::now().time_since_epoch().count());
namespace __input {
template <class T1, class T2>
void re(pair<T1, T2>& p);
template <class T>
void re(vector<T>& a);
template <class T, size_t SZ>
void re(array<T, SZ>& a);
template <class T>
void re(T& x) {
  cin >> x;
}
void re(double& x) {
  string t;
  re(t);
  x = stod(t);
}
template <class Arg, class... Args>
void re(Arg& first, Args&... rest) {
  re(first);
  re(rest...);
}
template <class T1, class T2>
void re(pair<T1, T2>& p) {
  re(p.first, p.second);
}
template <class T>
void re(vector<T>& a) {
  for (int i = 0; i < (int((a).size())); i++) re(a[i]);
}
template <class T, size_t SZ>
void re(array<T, SZ>& a) {
  for (int i = 0; i < (SZ); i++) re(a[i]);
}
}  // namespace __input
using namespace __input;
namespace __output {
template <class T1, class T2>
void pr(const pair<T1, T2>& x);
template <class T, size_t SZ>
void pr(const array<T, SZ>& x);
template <class T>
void pr(const vector<T>& x);
template <class T>
void pr(const deque<T>& x);
template <class T>
void pr(const set<T>& x);
template <class T1, class T2>
void pr(const map<T1, T2>& x);
template <class T>
void pr(const T& x) {
  cout << x;
}
template <class Arg, class... Args>
void pr(const Arg& first, const Args&... rest) {
  pr(first);
  pr(rest...);
}
template <class T1, class T2>
void pr(const pair<T1, T2>& x) {
  pr("{", x.first, ", ", x.second, "}");
}
template <class T, bool pretty = true>
void prContain(const T& x) {
  if (pretty) pr("{");
  bool fst = 1;
  for (const auto& a : x) pr(!fst ? pretty ? ", " : " " : "", a), fst = 0;
  if (pretty) pr("}");
}
template <class T>
void pc(const T& x) {
  prContain<T, false>(x);
  pr("\n");
}
template <class T, size_t SZ>
void pr(const array<T, SZ>& x) {
  prContain(x);
}
template <class T>
void pr(const vector<T>& x) {
  prContain(x);
}
template <class T>
void pr(const deque<T>& x) {
  prContain(x);
}
template <class T>
void pr(const set<T>& x) {
  prContain(x);
}
template <class T1, class T2>
void pr(const map<T1, T2>& x) {
  prContain(x);
}
void ps() { pr("\n"); }
template <class Arg>
void ps(const Arg& first) {
  pr(first);
  ps();
}
template <class Arg, class... Args>
void ps(const Arg& first, const Args&... rest) {
  pr(first, " ");
  ps(rest...);
}
}  // namespace __output
using namespace __output;
namespace __algorithm {
template <typename T>
void dedup(vector<T>& v) {
  sort((v).begin(), (v).end());
  v.erase(unique((v).begin(), (v).end()), v.end());
}
template <typename T>
typename vector<T>::iterator find(vector<T>& v, const T& x) {
  auto it = lower_bound((v).begin(), (v).end(), x);
  return it != v.end() && *it == x ? it : v.end();
}
template <typename T>
size_t index(vector<T>& v, const T& x) {
  auto it = find(v, x);
  assert(it != v.end() && *it == x);
  return it - v.begin();
}
template <typename C, typename T, typename OP>
vector<T> prefixes(const C& v, T id, OP op) {
  vector<T> r(int((v).size()) + 1, id);
  for (int i = 0; i < (int((v).size())); i++) r[i + 1] = op(r[i], v[i]);
  return r;
}
template <typename C, typename T, typename OP>
vector<T> suffixes(const C& v, T id, OP op) {
  vector<T> r(int((v).size()) + 1, id);
  for (int i = (int((v).size())) - 1; i >= 0; i--) r[i] = op(v[i], r[i + 1]);
  return r;
}
}  // namespace __algorithm
using namespace __algorithm;
struct monostate {
  friend istream& operator>>(istream& is,
                             const __attribute__((unused)) monostate& ms) {
    return is;
  }
  friend ostream& operator<<(ostream& os,
                             const __attribute__((unused)) monostate& ms) {
    return os;
  }
} ms;
template <typename W = monostate>
struct wedge {
  int u, v, i;
  W w;
  wedge<W>(int _u = -1, int _v = -1, int _i = -1) : u(_u), v(_v), i(_i) {}
  int operator[](int loc) const { return u ^ v ^ loc; }
  friend void re(wedge& e) {
    re(e.u, e.v, e.w);
    --e.u, --e.v;
  }
  friend void pr(const wedge& e) { pr(e.u, "<-", e.w, "->", e.v); }
};
namespace __io {
void setIn(string second) { freopen(second.c_str(), "r", stdin); }
void setOut(string second) { freopen(second.c_str(), "w", stdout); }
void setIO(string second = "") {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.precision(15);
  if (int((second).size())) {
    setIn(second + ".in"), setOut(second + ".out");
  }
}
}  // namespace __io
using namespace __io;
struct uf_monostate {
  uf_monostate(__attribute__((unused)) int id) {}
  void merge(__attribute__((unused)) uf_monostate& o,
             __attribute__((unused)) const monostate& e) {}
};
template <typename T = uf_monostate, typename E = monostate>
struct union_find {
  struct node {
    int par, rnk, size;
    T state;
    node(int id = 0) : par(id), rnk(0), size(1), state(id) {}
    void merge(node& o, E& e) {
      if (rnk == o.rnk) rnk++;
      if (size < o.size) swap(state, o.state);
      size += o.size;
      state.merge(o.state, e);
    }
  };
  int cc;
  vector<node> uf;
  union_find(int N = 0) : uf(N), cc(N) {
    for (int i = 0; i < N; i++) uf[i] = node(i);
  }
  int rep(int i) {
    if (i != uf[i].par) uf[i].par = rep(uf[i].par);
    return uf[i].par;
  }
  bool unio(int a, int b, E& e = ms) {
    a = rep(a), b = rep(b);
    if (a == b) return false;
    if (uf[a].rnk < uf[b].rnk) swap(a, b);
    uf[a].merge(uf[b], e);
    uf[b].par = a;
    cc--;
    return true;
  }
  T& state(int i) { return uf[rep(i)].state; }
};
int main() {
  setIO();
  int N, S;
  re(N, S);
  vi a(N);
  re(a);
  vi ti(N);
  vi st = a, did(N);
  sort((st).begin(), (st).end());
  vvi occ(N);
  for (int i = 0; i < (N); i++)
    if (a[i] != st[i]) {
      int w = index(st, a[i]);
      while (a[w + did[w]] == st[w + did[w]]) did[w]++;
      ti[i] = w + did[w]++;
      occ[w].push_back(i);
    } else
      ti[i] = i;
  vb vis(N);
  union_find<> uf(N);
  for (int i = 0; i < (N); i++)
    if (!vis[i]) {
      vis[i] = true;
      for (int t = ti[i]; t != i; t = ti[t]) {
        uf.unio(i, t);
        vis[t] = true;
      }
    }
  for (int i = 0; i < (N); i++)
    for (int j = 0; j < (int((occ[i]).size()) - 1); j++) {
      if (uf.unio(occ[i][j], occ[i][j + 1])) {
        swap(ti[occ[i][j]], ti[occ[i][j + 1]]);
      }
    }
  int wr = 0;
  for (int i = 0; i < (N); i++)
    if (a[i] != st[i]) wr++;
  if (wr > S) {
    ps(-1);
    return 0;
  }
  if (a == st) {
    ps(0);
    return 0;
  }
  vvi cyc;
  for (int i = 0; i < (N); i++)
    if (i == uf.rep(i) && i != ti[i]) {
      cyc.push_back({i + 1});
      for (int t = ti[i]; t != i; t = ti[t]) cyc.back().push_back(t + 1);
    }
  int merge = min(S - wr, int((cyc).size()));
  if (merge > 2) {
    vi loop, fix;
    for (int c = (int((cyc).size()) - merge); c < (int((cyc).size())); c++) {
      loop.insert(loop.end(), (cyc[c]).begin(), (cyc[c]).end());
      fix.push_back(cyc[c].front());
    }
    reverse((fix).begin(), (fix).end());
    cyc.erase(cyc.end() - merge, cyc.end());
    cyc.push_back(loop);
    cyc.push_back(fix);
  }
  ps(int((cyc).size()));
  for (auto& c : cyc) ps(int((c).size())), pc(c);
  return 0;
}
