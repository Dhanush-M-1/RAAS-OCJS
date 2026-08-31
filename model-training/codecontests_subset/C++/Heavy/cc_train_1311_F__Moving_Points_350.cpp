#include <bits/stdc++.h>
using namespace std;
using ll = long long;
template <class T, class U>
using Pa = pair<T, U>;
template <class T>
using vec = vector<T>;
template <class T>
using vvec = vector<vec<T>>;
template <typename Monoid, typename F>
class SegmentTree {
 private:
  int sz;
  vector<Monoid> seg;
  const F op;
  const Monoid e;

 public:
  SegmentTree(int n, const F op, const Monoid &e) : op(op), e(e) {
    sz = 1;
    while (sz <= n) sz <<= 1;
    seg.assign(2 * sz, e);
  }
  void set(int k, const Monoid &x) { seg[k + sz] = x; }
  void build() {
    for (int i = sz - 1; i > 0; i--) {
      seg[i] = op(seg[2 * i], seg[2 * i + 1]);
    }
  }
  void update(int k, const Monoid &x) {
    k += sz;
    seg[k] = x;
    while (k >>= 1) {
      seg[k] = op(seg[2 * k], seg[2 * k + 1]);
    }
  }
  Monoid query(int l, int r) {
    Monoid L = e, R = e;
    for (l += sz, r += sz; l < r; l >>= 1, r >>= 1) {
      if (l & 1) L = op(L, seg[l++]);
      if (r & 1) R = op(seg[--r], R);
    }
    return op(L, R);
  }
  Monoid operator[](const int &k) const { return seg[k + sz]; }
};
template <class T>
class Compress {
  map<T, int> idx;
  map<int, T> value;
  vector<T> cmp;

 public:
  int N;
  Compress(vector<T> v) {
    for (auto &x : v) cmp.push_back(x);
    sort(cmp.begin(), cmp.end());
    cmp.erase(unique(cmp.begin(), cmp.end()), cmp.end());
    N = cmp.size();
    for (int i = 0; i < N; i++) idx[cmp[i]] = i;
  }
  int id(T val) { return idx[val]; }
  T val(int id) { return cmp[id]; }
};
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int N;
  cin >> N;
  vec<ll> X(N), V(N);
  for (int i = 0; i < N; i++) cin >> X[i];
  for (int i = 0; i < N; i++) cin >> V[i];
  Compress<ll> cmp(X);
  vec<ll> P(N + 1), M(N + 1), Z(N + 1);
  vec<ll> PC(N + 1), MC(N + 1), ZC(N + 1);
  for (int i = 0; i < N; i++) {
    if (V[i] > 0) {
      P[cmp.id(X[i])] += X[i];
      PC[cmp.id(X[i])]++;
    } else if (V[i] < 0) {
      M[cmp.id(X[i])] += X[i];
      MC[cmp.id(X[i])]++;
    } else {
      Z[cmp.id(X[i])] += X[i];
      ZC[cmp.id(X[i])]++;
    }
  }
  for (int i = 0; i < N; i++) {
    M[i + 1] += M[i];
    MC[i + 1] += MC[i];
    Z[i + 1] += Z[i];
    ZC[i + 1] += ZC[i];
  }
  for (int i = N - 1; i >= 0; i--) {
    P[i] += P[i + 1];
    PC[i] += PC[i + 1];
  }
  struct state {
    ll sum, cnt;
  };
  auto op = [](state L, state R) {
    return (state){L.sum + R.sum, L.cnt + R.cnt};
  };
  SegmentTree<state, decltype(op)> seg(N, op, (state){0, 0});
  vec<int> idx(N);
  iota(idx.begin(), idx.end(), 0);
  sort(idx.begin(), idx.end(), [&](int i, int j) {
    return (V[i] != V[j] ? V[i] > V[j] : X[i] > X[j]);
  });
  ll ans = 0;
  for (int i = 0; i < N; i++) {
    int id = idx[i];
    if (V[id] <= 0) break;
    int xid = cmp.id(X[id]);
    ans += MC[xid] * X[id] - M[xid];
    state res = seg.query(xid, N);
    ans += res.sum - X[id] * res.cnt;
    seg.update(xid, {X[id], 1});
  }
  sort(idx.begin(), idx.end(), [&](int i, int j) {
    return (V[i] != V[j] ? V[i] < V[j] : X[i] < X[j]);
  });
  for (int i = 0; i < N; i++) seg.set(i, {0, 0});
  seg.build();
  for (int i = 0; i < N; i++) {
    int id = idx[i];
    if (V[id] >= 0) continue;
    int xid = cmp.id(X[id]);
    state res = seg.query(0, xid);
    ans += X[id] * res.cnt - res.sum;
    seg.update(xid, {X[id], 1});
  }
  for (int i = 0; i < N; i++)
    if (V[i] == 0) {
      int xid = cmp.id(X[i]);
      ans += MC[xid] * X[i] - M[xid];
      ans += P[xid] - PC[xid] * X[i];
      ans += ZC[xid] * X[i] - Z[xid];
    }
  cout << ans << "\n";
}
