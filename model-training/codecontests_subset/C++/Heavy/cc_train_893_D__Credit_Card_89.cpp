#include <bits/stdc++.h>
using namespace std;
class SegTree_Max {
  vector<int> st, st2, id;
  vector<int> lazy;
  int n;
  void prop(int p, int L, int R) {
    if (lazy[p]) {
      st[p] += lazy[p];
      lazy[2 * p] += lazy[p];
      lazy[2 * p + 1] += lazy[p];
      lazy[p] = 0;
    }
  }
  void upd(int p, int L, int R, int i, int j, int v) {
    prop(p, L, R);
    if (j < L || i > R) {
      return;
    }
    if (i <= L && R <= j) {
      lazy[p] = v;
      prop(p, L, R);
      return;
    }
    int mid = (L + R) / 2;
    upd(2 * p, L, mid, i, j, v);
    upd(2 * p + 1, mid + 1, R, i, j, v);
    st[p] = max(st[2 * p], st[2 * p + 1]);
  }
  int qry(int p, int L, int R, int i, int j) {
    prop(p, L, R);
    if (j < L || i > R) {
      return -1e9;
    }
    if (i <= L && R <= j) {
      return st[p];
    }
    int mid = (L + R) / 2;
    return max(qry(2 * p, L, mid, i, j), qry(2 * p + 1, mid + 1, R, i, j));
  }

 public:
  SegTree_Max(int sz) {
    n = sz;
    st.assign(9 * (n + 1), 0);
    lazy.assign(9 * (n + 1), 0);
  }
  int qry(int i, int j) { return qry(1, 1, n, i, j); }
  void upd(int i, int j, int v) { upd(1, 1, n, i, j, v); }
};
class SegTree_Sum {
  vector<int> st, st2, id;
  vector<int> lazy;
  int n;
  void prop(int p, int L, int R) {
    if (lazy[p]) {
      st[p] += lazy[p];
      lazy[2 * p] += lazy[p];
      lazy[2 * p + 1] += lazy[p];
      lazy[p] = 0;
    }
  }
  void upd(int p, int L, int R, int i, int j, int v) {
    prop(p, L, R);
    if (j < L || i > R) return;
    if (i <= L && R <= j) {
      lazy[p] = v;
      prop(p, L, R);
      return;
    }
    int mid = (L + R) / 2;
    upd(2 * p, L, mid, i, j, v);
    upd(2 * p + 1, mid + 1, R, i, j, v);
    int qryLo = st[2 * p];
    int qryHi = st[2 * p + 1];
    st[p] = qryLo + qryHi;
  }
  int qry(int p, int L, int R, int i, int j) {
    prop(p, L, R);
    if (j < L || i > R) return 0;
    if (i <= L && R <= j) return st[p];
    int mid = (L + R) / 2;
    int qryLo = qry(2 * p, L, mid, i, j);
    int qryHi = qry(2 * p + 1, mid + 1, R, i, j);
    return qryLo + qryHi;
  }

 public:
  SegTree_Sum(int sz) {
    n = sz;
    st.assign(9 * (n + 1), 0);
    lazy.assign(9 * (n + 1), 0);
  }
  int qry(int i, int j) { return qry(1, 1, n, i, j); }
  void upd(int i, int j, int v) { upd(1, 1, n, i, j, v); }
};
int main() {
  ios::sync_with_stdio(false);
  int n, d, x, tot = 0;
  cin >> n >> d;
  SegTree_Sum st_sum(n);
  SegTree_Max st_max(n);
  vector<int> v(n + 1);
  for (int(i) = (1), _MAX = (n + 1); (i) < _MAX; (i)++) {
    cin >> x;
    v[i] = x;
    st_sum.upd(i, i, x);
    st_max.upd(i, i, st_sum.qry(1, i));
    if (st_sum.qry(1, i) > d) {
      cout << -1 << endl;
      return 0;
    }
  }
  for (int(i) = (1), _MAX = (n + 1); (i) < _MAX; (i)++) {
    int val = st_sum.qry(1, i);
    if (v[i] == 0 && val < 0) {
      int mx = st_max.qry(i, n);
      mx = d - mx;
      if (val + mx < 0) {
        cout << -1 << endl;
        return 0;
      }
      st_sum.upd(i, i, mx);
      st_max.upd(i, n, mx);
      tot++;
    }
  }
  cout << tot << endl;
  return 0;
}
