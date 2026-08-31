#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
template <class T, class U>
inline void add_self(T &a, U b) {
  a += b;
  if (a >= mod) a -= mod;
  if (a < 0) a += mod;
}
template <class T, class U>
inline void min_self(T &x, U y) {
  if (y < x) x = y;
}
template <class T, class U>
inline void max_self(T &x, U y) {
  if (y > x) x = y;
}
template <class T, class U>
inline void mul_self(T &x, U y) {
  x *= y;
  x %= mod;
}
void _print() { cerr << "]\n"; }
template <typename T, typename... V>
void _print(T t, V... v) {
  cout << t;
  ;
  if (sizeof...(v)) cerr << ", ";
  _print(v...);
}
template <class T, class U>
void print_m(const map<T, U> &m, int w = 3) {
  if (m.empty()) {
    cout << "Empty" << endl;
    return;
  }
  for (auto x : m) cout << "(" << x.first << ": " << x.second << ")," << endl;
  cout << endl;
}
template <class T, class U>
void debp(const pair<T, U> &pr, bool end_line = 1) {
  cout << "{" << pr.first << " " << pr.second << "}";
  cout << (end_line ? "\n" : ", ");
}
template <class T>
void print_vp(const T &vp, int sep_line = 0) {
  if (vp.empty()) {
    cout << "Empty" << endl;
    return;
  }
  if (!sep_line) cout << "{ ";
  for (auto x : vp) debp(x, sep_line);
  if (!sep_line) cout << "}\n";
  cout << endl;
}
template <typename T>
void print(const T &v, bool show_index = false) {
  int w = 2;
  if (show_index) {
    for (int i = 0; i < int((v).size()); i++) cout << setw(w) << i << " ";
    cout << endl;
  }
  for (auto &el : v) cout << setw(w) << el << " ";
  cout << endl;
}
template <typename T>
void print_vv(const T &vv) {
  if (int((vv).size()) == 0) {
    cout << "Empty" << endl;
    return;
  }
  int w = 3;
  cout << setw(w) << " ";
  for (int j = 0; j < int((*vv.begin()).size()); j++)
    cout << setw(w) << j << " ";
  cout << endl;
  int i = 0;
  for (auto &v : vv) {
    cout << i++ << " {";
    for (auto &el : v) cout << setw(w) << el << " ";
    cout << "},\n";
  }
  cout << endl;
}
const long long inf = 1e15L;
struct node {
  bool clazy = 0;
  long long lazy = 0, mn = inf;
  node(){};
  node(long long v) : mn(v){};
};
class SegmentTree {
 public:
  int n;
  vector<node> st;
  SegmentTree(vector<long long> &a) {
    n = int((a).size());
    st.resize(8 * n);
    build(1, 0, n - 1, a);
  }
  node merge(node &l, node &r) {
    node cur;
    cur.mn = min(l.mn, r.mn);
    return cur;
  }
  void build(int pos, int l, int r, vector<long long> &a) {
    if (l == r) {
      st[pos] = node(a[l]);
      return;
    }
    int mid = (l + r) / 2;
    build(2 * pos, l, mid, a);
    build(2 * pos + 1, mid + 1, r, a);
    st[pos] = merge(st[2 * pos], st[2 * pos + 1]);
  }
  void update(int pos, int sl, int sr, int l, int r, long long val) {
    propagate(pos, sl, sr);
    if (r < sl || sr < l)
      return;
    else if (l <= sl && sr <= r) {
      st[pos].clazy = 1;
      st[pos].lazy = val;
      propagate(pos, sl, sr);
      return;
    }
    int mid = (sl + sr) / 2;
    update(2 * pos, sl, mid, l, r, val);
    update(2 * pos + 1, mid + 1, sr, l, r, val);
    st[pos] = merge(st[2 * pos], st[2 * pos + 1]);
  }
  int query(int pos, int sl, int sr) {
    propagate(pos, sl, sr);
    if (sl == sr) return sl;
    int mid = (sl + sr) / 2;
    propagate(2 * pos, sl, mid);
    propagate(2 * pos + 1, mid + 1, sr);
    if (st[2 * pos + 1].mn == 0) return query(2 * pos + 1, mid + 1, sr);
    return query(2 * pos, sl, mid);
  }
  void propagate(int pos, int sl, int sr) {
    if (!st[pos].clazy) return;
    if (sl != sr) {
      st[2 * pos].lazy += st[pos].lazy;
      st[2 * pos + 1].lazy += st[pos].lazy;
      st[2 * pos].clazy = st[2 * pos + 1].clazy = 1;
    }
    st[pos].mn += st[pos].lazy;
    st[pos].lazy = st[pos].clazy = 0;
  }
  void update(int l, int r, long long v) {
    if (l > r) return;
    update(1, 0, n - 1, l, r, v);
  }
  int query() { return query(1, 0, n - 1); }
};
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  while (cin >> n) {
    vector<long long> a(n);
    for (int i = 0; i < int(n); i++) cin >> a[i];
    SegmentTree st(a);
    vector<int> out(n);
    for (int i = int(1); i < int(n + 1); i++) {
      int idx = st.query();
      out[idx] = i;
      st.update(idx, idx, inf);
      st.update(idx + 1, n - 1, -i);
    }
    print(out);
  }
  return 0;
}
