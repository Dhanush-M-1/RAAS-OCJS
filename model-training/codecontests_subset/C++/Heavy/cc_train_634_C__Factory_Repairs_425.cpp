#include <bits/stdc++.h>
using namespace ::std;
class SegT {
 public:
  int op(int x, int y) { return (x + y); }
  int up(int n) {
    int m = 1;
    n--;
    while (n) {
      n >>= 1;
      m <<= 1;
    }
    return m;
  }
  SegT(int n) {
    ID = 0;
    sz = up(n);
    P = new int[2 * sz];
    for (int i = 0; i < 2 * sz; i++) P[i] = ID;
  }
  ~SegT() { delete[] P; }
  void update(int idx, int val) {
    idx += sz;
    P[idx] = val;
    idx >>= 1;
    while (idx) {
      P[idx] = op(P[2 * idx], P[2 * idx + 1]);
      idx >>= 1;
    }
  }
  void update_delta(int idx, int delta) {
    idx += sz;
    P[idx] = op(P[idx], delta);
    idx >>= 1;
    while (idx) {
      P[idx] = op(P[2 * idx], P[2 * idx + 1]);
      idx >>= 1;
    }
  }
  int range_val(int idx, int beg, int end, int s, int e) {
    if (s > end || e < beg) return ID;
    if (beg >= s && end <= e) return P[idx];
    int mid = (beg + end) / 2;
    return op(range_val(2 * idx, beg, mid, s, e),
              range_val(2 * idx + 1, mid + 1, end, s, e));
  }
  int range_val(int s, int e) { return range_val(1, 0, sz - 1, s, e); }

 private:
  int ID;
  int sz;
  int *P;
};
int main() {
  int n, k, a, b, q;
  scanf("%d", &n);
  scanf("%d", &k);
  scanf("%d", &a);
  scanf("%d", &b);
  scanf("%d", &q);
  SegT left(n + 5);
  SegT right(n + 5);
  vector<int> ord(n + 5, 0);
  for (int i = 0; i < q; i++) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int d, x;
      scanf("%d", &d);
      scanf("%d", &x);
      int prev = ord[d];
      if (prev < b) {
        int delta = min(x, b - prev);
        left.update_delta(d, delta);
      }
      if (prev < a) {
        int delta = min(x, a - prev);
        right.update_delta(d, delta);
      }
      ord[d] += x;
      if (ord[d] > a) ord[d] = a;
    } else {
      int p;
      scanf("%d", &p);
      int ans = left.range_val(0, p - 1);
      ans += right.range_val(p + k, n + 1);
      printf("%d\n", ans);
    }
  }
  return 0;
}
