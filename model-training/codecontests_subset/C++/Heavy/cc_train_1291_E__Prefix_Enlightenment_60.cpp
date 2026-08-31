#include <bits/stdc++.h>
using namespace std;
const long long llINF = 2e18, llMOD = 1e9 + 7;
const int INF = 2e9, MOD = 1e9 + 7, P = 179, N = 2e3 + 1, K = 23000, L = 18;
const long double EPS = 1e-6, ldINF = 1e18, PI = acos(-1);
template <typename T>
inline void sort_uniq(vector<T>& v) {
  sort(v.begin(), v.end());
  v.resize(unique(v.begin(), v.end()) - v.begin());
}
template <typename T>
inline int sign(T a) {
  if (a > 0) {
    return 1;
  } else if (a == 0) {
    return 0;
  } else {
    return -1;
  }
}
template <typename T, typename P>
bool eq(T a, P b) {
  return abs(a - b) <= EPS;
}
const char sep[] = " ";
template <typename T, typename P>
istream& operator>>(istream& in, pair<T, P>& p) {
  in >> p.first >> p.second;
  return in;
}
template <typename T>
void in_seg(istream& in, T* dst_begin, T* dst_end) {
  while (dst_begin != dst_end) {
    in >> (*dst_begin);
    ++dst_begin;
  }
}
template <typename T>
istream& operator>>(istream& in, vector<T>& v) {
  for (T& i : v) {
    in >> i;
  }
  return in;
}
template <typename T, typename P>
ostream& operator<<(ostream& out, pair<T, P> const& p) {
  out << p.first << ' ' << p.second;
  return out;
}
template <typename T>
ostream& operator<<(ostream& out, vector<T> const& v) {
  for (T const& i : v) {
    out << i << sep;
  }
  if (!v.empty()) {
    out << '\n';
  }
  return out;
}
template <typename T>
ostream& operator<<(ostream& out, vector<vector<T>> const& v) {
  for (vector<T> const& i : v) {
    out << i;
  }
  return out;
}
void set_precision(ostream& out, int val) {
  out.setf(out.fixed, out.floatfield);
  out.precision(val);
}
struct edge {
  int v, u, x;
};
class Dsu {
  int n;
  vector<int> p, sz, p_xor, r_st, ans;
  int cur_ans = 0;
  int dsu_get(int v) {
    if (v == p[v]) {
      return v;
    }
    int par = p[v], res = dsu_get(p[v]);
    p_xor[v] ^= p_xor[par];
    p[v] = res;
    return res;
  }
  int get_vrt_ans(int v) {
    v = dsu_get(v);
    if (r_st[v] == 0) {
      return ans[v];
    } else if (r_st[v] == 1) {
      return sz[v] - ans[v];
    } else {
      return min(ans[v], sz[v] - ans[v]);
    }
  }
  void dsu_unite(int v, int u, int x) {
    int p_v = dsu_get(v);
    int p_u = dsu_get(u);
    if (p_v == p_u) {
      assert(x == (p_xor[u] ^ p_xor[v]));
      return;
    }
    cur_ans -= get_vrt_ans(p_v);
    cur_ans -= get_vrt_ans(p_u);
    if (sz[p_v] < sz[p_u]) {
      swap(v, u);
      swap(p_v, p_u);
    }
    p_xor[p_u] = p_xor[u] ^ p_xor[v] ^ x;
    if (r_st[p_u] != 2) {
      if (r_st[p_v] == 2) {
        r_st[p_v] = r_st[p_u] ^ p_xor[p_u];
      } else {
        assert(r_st[p_v] == (r_st[p_u] ^ p_xor[p_u]));
      }
    }
    if (p_xor[p_u]) {
      ans[p_v] += sz[p_u] - ans[p_u];
    } else {
      ans[p_v] += ans[p_u];
    }
    p[p_u] = p_v;
    sz[p_v] += sz[p_u];
    cur_ans += get_vrt_ans(p_v);
  }

 public:
  Dsu(vector<int> r_st)
      : n(r_st.size()), p(n), sz(n, 1), p_xor(n), r_st(r_st), ans(n) {
    for (int i = 0; i < n; i++) {
      p[i] = i;
    }
  }
  int get_ans() { return cur_ans; }
  void set_rst(int v, int st) {
    int p_v = dsu_get(v);
    if (r_st[p_v] != 2) {
      assert(r_st[p_v] == (st ^ p_xor[v]));
      return;
    }
    cur_ans -= get_vrt_ans(p_v);
    r_st[p_v] = st ^ p_xor[v];
    cur_ans += get_vrt_ans(p_v);
  }
  void unite(int v, int u, int x) { dsu_unite(v, u, x); }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  string s;
  vector<vector<int>> v_mask(n);
  vector<int> mask_st(k, 2);
  vector<vector<edge>> e(n);
  cin >> s;
  for (int i = 0, c; i < k; i++) {
    cin >> c;
    for (int j = 0, x; j < c; j++) {
      cin >> x;
      v_mask[x - 1].push_back(i);
    }
  }
  int ban_bit = n;
  for (int i = 0; i < n; i++) {
    if (v_mask[i].size() == 1) {
      if (s[i] == '0') {
        mask_st[v_mask[i][0]] = 1;
      } else {
        mask_st[v_mask[i][0]] = 0;
      }
    } else if (v_mask[i].size() == 2) {
      int v = v_mask[i][0];
      int u = v_mask[i][1];
      if (s[i] == '0') {
        e[i].push_back({v, u, 1});
      } else {
        e[i].push_back({v, u, 0});
      }
    } else {
      assert(v_mask[i].size() == 0);
    }
  }
  Dsu dsu(vector<int>(k, 2));
  for (int i = 0; i < n; i++) {
    for (auto [v, u, x] : e[i]) {
      dsu.unite(v, u, x);
    }
    if (v_mask[i].size() == 1) {
      dsu.set_rst(v_mask[i][0], mask_st[v_mask[i][0]]);
    }
    cout << dsu.get_ans() << '\n';
  }
}
