#include <bits/stdc++.h>
using namespace std;
long long t[200000 + 5];
struct Fenwick_tree {
  long long bit[200000 + 5];
  void upd(int x, long long v) {
    for (; x <= 200000; x += x & (-x)) bit[x] += v;
  }
  long long get(int x) {
    long long ret = 0;
    for (; x > 0; x -= x & (-x)) ret += bit[x];
    return ret;
  }
};
Fenwick_tree fwt0, fwt1;
int n, k, a, b, q;
int main() {
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  while (q > 0) {
    int tt;
    scanf("%d", &tt);
    if (tt == 1) {
      int d, x;
      scanf("%d %d", &d, &x);
      fwt0.upd(d, -min(1ll * b, t[d]));
      fwt1.upd(d, -min(1ll * a, t[d]));
      t[d] += x;
      fwt0.upd(d, min(1ll * b, t[d]));
      fwt1.upd(d, min(1ll * a, t[d]));
    } else {
      int p;
      scanf("%d", &p);
      cout << fwt0.get(p - 1) + fwt1.get(n) - fwt1.get(p + k - 1) << '\n';
    }
    q--;
  }
}
