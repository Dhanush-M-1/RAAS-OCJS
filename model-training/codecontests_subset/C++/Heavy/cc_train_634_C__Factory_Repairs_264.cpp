#include <bits/stdc++.h>
using namespace std;
long long rdtsc() {
  long long tmp;
  asm("rdtsc" : "=A"(tmp));
  return tmp;
}
inline int myrand() { return abs((rand() << 15) ^ rand()); }
inline int rnd(int x) { return myrand() % x; }
void precalc() {}
const int maxn = 2e5 + 10;
struct tree {
  int x[4 * maxn];
  int mx;
  int n;
  void build(int _n, int _mx) {
    for (n = 1; n < _n; n <<= 1)
      ;
    mx = _mx;
    memset(x, 0, sizeof(x));
  }
  void set(int pos, int val) {
    int j = n + pos;
    x[j] = min(mx, x[j] + val);
    for (j >>= 1; j > 0; j >>= 1) {
      x[j] = x[2 * j] + x[2 * j + 1];
    }
  }
  int get(int v, int L, int R, int l, int r) {
    if (L >= r || l >= R) {
      return 0;
    }
    if (l <= L && R <= r) {
      return x[v];
    }
    int M = (L + R) / 2;
    return get(2 * v, L, M, l, r) + get(2 * v + 1, M, R, l, r);
  }
  int get(int l, int r) {
    if (l >= r) {
      return 0;
    }
    return get(1, 0, n, l, r);
  }
} ta, tb;
int n, k, a, b, q;
bool read() {
  if (scanf("%d%d%d%d%d", &n, &k, &a, &b, &q) < 5) {
    return false;
  }
  return true;
}
void solve() {
  ta.build(n, a);
  tb.build(n, b);
  for (int i = 0; i < q; ++i) {
    int tp;
    scanf("%d", &tp);
    if (tp == 1) {
      int d, x;
      scanf("%d%d", &d, &x);
      d--;
      ta.set(d, x);
      tb.set(d, x);
    } else {
      assert(tp == 2);
      int p;
      scanf("%d", &p);
      --p;
      int res = tb.get(0, p) + ta.get(p + k, n);
      printf("%d\n", res);
    }
  }
}
int main() {
  srand(rdtsc());
  precalc();
  while (true) {
    if (!read()) {
      break;
    }
    solve();
  }
  return 0;
}
