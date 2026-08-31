#include <bits/stdc++.h>
using namespace std;
struct tree {
  vector<long long> a;
  int N;
  tree(int size) {
    for (N = 1; N < size; N <<= 1)
      ;
    a.resize(N << 1);
  }
  void update(int ind, long long val, long long bound) {
    ind += N;
    a[ind] = min(val + a[ind], bound);
    for (int k = ind >> 1; k >= 1; k >>= 1) {
      a[k] = a[k << 1] + a[k << 1 | 1];
    }
  }
  int query(int v, int L, int R, int l, int r) {
    if (l > r) {
      return 0;
    }
    if (l == L && r == R) {
      return a[v];
    }
    int mid = (L + R) / 2;
    return query(v << 1, L, mid, l, min(r, mid)) +
           query(v << 1 | 1, mid + 1, R, max(l, mid + 1), r);
  }
  int call_query(int l, int r) { return query(1, 0, N - 1, l, r); }
  void print() {
    for (int k = 0; k < (int)a.size(); k++) {
      cout << a[k] << " ";
    }
    cout << '\n';
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  int n, m, a, b, q;
  cin >> n >> m >> a >> b >> q;
  tree A(n), B(n);
  for (int k = 0; k < q; k++) {
    int mode;
    cin >> mode;
    if (mode == 1) {
      int day, ai;
      cin >> day >> ai;
      A.update(day - 1, ai, a);
      B.update(day - 1, ai, b);
    } else {
      int x;
      cin >> x;
      cout << B.call_query(0, x - 2) + A.call_query(x + m - 1, n - 1) << '\n';
    }
  }
  return 0;
}
