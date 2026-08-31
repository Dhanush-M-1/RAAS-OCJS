#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e17;
struct node {
  long long ans, sub;
  node() : ans(0), sub(0){};
};
struct SegmentTree {
  long long N;
  vector<node> st;
  vector<long long> a;
  long long left(long long p) { return p << 1; }
  long long right(long long p) { return (p << 1) + 1; }
  void push(long long p) {
    st[left(p)].sub += st[p].sub;
    st[right(p)].sub += st[p].sub;
    st[left(p)].ans -= st[p].sub;
    st[right(p)].ans -= st[p].sub;
    st[p].sub = 0;
  }
  void merge(long long p) {
    st[p].ans = min(st[left(p)].ans, st[right(p)].ans);
  }
  void build(long long p, long long l, long long r) {
    if (l == r) {
      st[p].ans = a[l];
    } else {
      long long mid = l + r >> 1;
      build(left(p), l, mid);
      build(right(p), mid + 1, r);
      merge(p);
    }
  }
  SegmentTree(long long N, vector<long long>& a) : N(N), st(4 * N), a(a) {
    build(1, 0, N - 1);
  }
  void setElem(long long p, long long l, long long r, long long i) {
    if (l == r) {
      st[p].ans = inf;
    } else {
      long long mid = l + r >> 1;
      push(p);
      if (i > mid)
        setElem(right(p), mid + 1, r, i);
      else
        setElem(left(p), l, mid, i);
      merge(p);
    }
  }
  void update(long long p, long long l, long long r, long long i, long long j,
              long long val) {
    if (l == i && r == j) {
      st[p].sub += val;
      st[p].ans -= val;
    } else {
      long long mid = l + r >> 1;
      push(p);
      if (i > mid)
        update(right(p), mid + 1, r, i, j, val);
      else if (j <= mid)
        update(left(p), l, mid, i, j, val);
      else {
        update(left(p), l, mid, i, mid, val);
        update(right(p), mid + 1, r, mid + 1, j, val);
      }
      merge(p);
    }
  }
  void update(long long i, long long val) {
    if (i + 1 < N) update(1, 0, N - 1, i + 1, N - 1, val);
    setElem(1, 0, N - 1, i);
  }
  long long query(long long p, long long l, long long r) {
    if (l == r) {
      return l;
    } else {
      long long mid = l + r >> 1;
      push(p);
      if (st[right(p)].ans == 0)
        return query(right(p), mid + 1, r);
      else
        return query(left(p), l, mid);
    }
  }
  long long query() { return query(1, 0, N - 1); }
};
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  long long n;
  cin >> n;
  vector<long long> s(n);
  for (long long i = 0; i < n; i++) cin >> s[i];
  vector<int> ans(n);
  SegmentTree st(n, s);
  for (long long i = 0; i < n; i++) {
    long long idx = st.query();
    ans[idx] = i + 1;
    st.update(idx, i + 1);
  }
  for (int i = 0; i < n; i++) cout << ans[i] << " ";
  cout << endl;
  return 0;
}
