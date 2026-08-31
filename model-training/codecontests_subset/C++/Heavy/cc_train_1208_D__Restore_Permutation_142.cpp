#include <bits/stdc++.h>
using namespace std;
void rset();
void init_test();
void solve();
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout << fixed;
  cout.precision(20);
  init_test();
  return 0;
}
template <typename T>
void chmin(T& a, T b) {
  if (a > b) a = b;
}
template <typename T>
void chmax(T& a, T b) {
  if (a < b) a = b;
}
template <typename T>
void MACRO_rdv2_Init(long long n, T& t) {
  t.resize(n);
}
template <typename First, typename... Rest>
void MACRO_rdv2_Init(long long n, First& first, Rest&... rest) {
  first.resize(n);
  MACRO_rdv2_Init(n, rest...);
}
template <typename T>
void MACRO_rdv2_Scan(long long p, T& t) {
  std::cin >> t[p];
}
template <typename First, typename... Rest>
void MACRO_rdv2_Scan(long long p, First& first, Rest&... rest) {
  std::cin >> first[p];
  MACRO_rdv2_Scan(p, rest...);
}
template <typename T>
void wrv(const vector<T>& v) {
  for (long long(__ii) = (0); (__ii) < (((long long)v.size())); ++(__ii)) {
    if (__ii) cout << ' ';
    cout << v[__ii];
  }
  cout << '\n';
}
template <typename T>
void wrm(const vector<vector<T>>& v) {
  for (long long(__ii) = (0); (__ii) < (((long long)v.size())); ++(__ii)) {
    for (long long(__jj) = (0); (__jj) < (v[__ii].size()); ++(__jj)) {
      if (__jj) cout << ' ';
      cout << v[__ii][__jj];
    }
    cout << '\n';
  }
}
template <typename T>
void sc(T& x) {
  cin >> x;
}
template <typename Head, typename... Tail>
void sc(Head& head, Tail&... tail) {
  cin >> head;
  sc(tail...);
}
template <typename T>
void wr(const T& x) {
  cout << x << '\n';
}
template <typename Head, typename... Tail>
void wr(const Head& head, const Tail&... tail) {
  cout << head << ' ';
  wr(tail...);
}
template <typename T>
void wrf(const T& x) {
  cout << x << endl;
}
template <typename Head, typename... Tail>
void wrf(const Head& head, const Tail&... tail) {
  cout << head << ' ';
  wrf(tail...);
}
template <typename T>
void debug_out(const T& x) {
  cerr << x << '\n';
}
template <typename Head, typename... Tail>
void debug_out(const Head& head, const Tail&... tail) {
  cerr << head << ' ';
  debug_out(tail...);
}
template <typename... T>
void err(const T&... cod) {
  wr(cod...);
  exit(0);
}
const long long N = 2e5 + 10;
const long long inf = 1e12;
long long st_mn, st_mx;
class segtree {
 private:
  struct node {
    long long mn, mx;
    node(long long mn = inf, long long mx = -inf) : mn(mn), mx(mx){};
    node operator+(const node& rhs) const {
      node ans;
      ans.mn = min(mn, rhs.mn);
      ans.mx = max(mx, rhs.mx);
      return ans;
    }
  };
  long long n, ql, qr;
  vector<node> st;
  vector<long long> lazy;
  void push(long long sl, long long sr, long long at) {
    if (lazy[at] == 0) return;
    st[at].mn += lazy[at];
    st[at].mx += lazy[at];
    if (sl != sr) {
      lazy[at << 1] += lazy[at];
      lazy[at << 1 | 1] += lazy[at];
    }
    lazy[at] = 0;
  }
  void add_recur(long long sl, long long sr, long long at, long long delta) {
    push(sl, sr, at);
    if (qr < sl || ql > sr) return;
    if (ql <= sl && qr >= sr) {
      lazy[at] += delta;
      push(sl, sr, at);
      return;
    }
    long long mid = (sl + sr) >> 1;
    long long le = at << 1, ri = at << 1 | 1;
    add_recur(sl, mid, le, delta);
    add_recur(mid + 1, sr, ri, delta);
    st[at] = st[le] + st[ri];
  }
  node get_recur(long long sl, long long sr, long long at) {
    push(sl, sr, at);
    if (qr < sl || ql > sr) return node();
    if (ql <= sl && qr >= sr) return st[at];
    long long mid = (sl + sr) >> 1;
    return get_recur(sl, mid, at << 1) + get_recur(mid + 1, sr, at << 1 | 1);
  }

 public:
  segtree() {}
  segtree(long long _n) { init(_n); }
  void init(long long _n) {
    this->n = _n;
    st.assign(n << 2, node(0, 0));
    lazy.assign(n << 2, 0);
  }
  void add(long long l, long long r, long long delta) {
    ql = l, qr = r;
    if (l > r) return;
    add_recur(0, n - 1, 1, delta);
  }
  void get(long long l, long long r) {
    ql = l, qr = r;
    node tmp = get_recur(0, n - 1, 1);
    st_mn = tmp.mn, st_mx = tmp.mx;
  }
};
long long find_zero(long long n, segtree* st) {
  long long low = 0, high = n - 1;
  while (low < high) {
    long long mid = (low + high + 1) / 2;
    st->get(mid, high);
    if (st_mn == 0)
      low = mid;
    else
      high = mid - 1;
  }
  return low;
}
void solve() {
  long long n;
  sc(n);
  vector<long long> a(n);
  for (long long(__ii) = (0); (__ii) < (n); ++(__ii)) cin >> a[__ii];
  segtree* st = new segtree(n);
  for (long long(i) = (0); (i) < (n); ++(i)) st->add(i, i, a[i]);
  vector<long long> ans(n);
  for (long long(i) = (1); (i) < (n + 1); ++(i)) {
    long long at = find_zero(n, st);
    ans[at] = i;
    st->add(at, at, inf);
    st->add(at + 1, n - 1, -i);
  }
  wrv(ans);
}
void init_test() {
  long long qq = 1;
  while (qq--) solve();
}
