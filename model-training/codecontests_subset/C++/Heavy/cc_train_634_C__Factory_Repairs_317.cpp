#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200200;
int n;
const long long neutro = 0;
struct RMQ {
  int sz;
  long long tope;
  long long t[4 * MAXN];
  long long &operator[](int p) { return t[sz + p]; }
  void init(int n, long long tope_) {
    sz = 1 << (32 - __builtin_clz(n));
    tope = tope_;
    for (int i = (0); i < (2 * sz); i++) t[i] = neutro;
  }
  void updall() {
    for (int i = sz - 1; i >= 0; i--) t[i] = (t[2 * i] + t[2 * i + 1]);
  }
  long long get(int i, int j) {
    if (j <= i) return 0;
    return get(i, j, 1, 0, sz);
  }
  long long get(int i, int j, int n, int a, int b) {
    if (j <= a || i >= b) return neutro;
    if (i <= a && b <= j) return t[n];
    int c = (a + b) / 2;
    return (get(i, j, 2 * n, a, c) + get(i, j, 2 * n + 1, c, b));
  }
  void set(int p, long long val) {
    p += sz;
    val = min(tope, t[p] + val);
    for (; p > 0 && t[p] != val;) {
      t[p] = val;
      p /= 2;
      val = (t[p * 2] + t[p * 2 + 1]);
    }
  }
} rmqa, rmqb;
int k, a, b, q;
int main() {
  ios::sync_with_stdio(0);
  while (cin >> n >> k >> a >> b >> q) {
    rmqa.init(n, a);
    rmqb.init(n, b);
    for (int _ = (0); _ < (q); _++) {
      int t;
      cin >> t;
      if (t == 1) {
        int d, a;
        cin >> d >> a;
        rmqa.set(d - 1, a);
        rmqb.set(d - 1, a);
      } else {
        int p;
        cin >> p;
        p--;
        cout << rmqb.get(0, p) + rmqa.get(p + k, n) << endl;
      }
    }
  }
  return 0;
}
