#include <bits/stdc++.h>
using namespace std;
void aps554(long long int n = 10) {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cout << setprecision(n) << fixed;
}
long long int M = 1e9 + 7;
long long int M1 = 998244353;
vector<long long int> v;
struct info {
  long long int x, lazy;
  info() {
    x = 0;
    lazy = 0;
  }
};
struct SegTree {
  long long int N;
  vector<info> st;
  void init(long long int n) {
    N = n;
    st.resize(4 * N + 5, info());
  }
  void merge(info &cur, info &l, info &r) { cur.x = l.x + r.x; }
  void Build(long long int node, long long int L, long long int R) {
    if (L == R) {
      st[node].x = v[L - 1];
      return;
    }
    long long int MM = (L + R) / 2;
    Build(node * 2, L, MM);
    Build(node * 2 + 1, MM + 1, R);
    merge(st[node], st[node * 2], st[node * 2 + 1]);
  }
  info Query(long long int node, long long int L, long long int R,
             long long int i, long long int j) {
    if (j < L || i > R) return info();
    if (i <= L && R <= j) return st[node];
    long long int MM = (L + R) / 2;
    info left = Query(node * 2, L, MM, i, j);
    info right = Query(node * 2 + 1, MM + 1, R, i, j);
    info cur;
    merge(cur, left, right);
    return cur;
  }
  void Update(long long int node, long long int L, long long int R,
              long long int ind, long long int limit, long long int val) {
    if (L > ind || R < ind) return;
    if (L == ind && R == ind) {
      st[node].x = min(val + st[node].x, limit);
      return;
    }
    long long int MM = (L + R) / 2;
    Update(node * 2, L, MM, ind, limit, val);
    Update(node * 2 + 1, MM + 1, R, ind, limit, val);
    merge(st[node], st[node * 2], st[node * 2 + 1]);
  }
  info query(long long int l, long long int r) { return Query(1, 1, N, l, r); }
  void update(long long int ind, long long int val, long long int limit) {
    Update(1, 1, N, ind, limit, val);
  }
  void build() { Build(1, 1, N); }
};
int32_t main() {
  aps554();
  long long int n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  SegTree segm, segM;
  v.resize(n);
  segm.init(n);
  segM.init(n);
  while (q--) {
    long long int t;
    cin >> t;
    if (t == 1) {
      long long int aa, bb;
      cin >> aa >> bb;
      segm.update(aa, bb, a);
      segM.update(aa, bb, b);
    } else {
      long long int ind;
      cin >> ind;
      cout << segM.query(1, ind - 1).x + segm.query(ind + k, n).x << "\n";
    }
  }
}
