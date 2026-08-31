#include <bits/stdc++.h>
using namespace std;
void fre() {
  freopen("c://test//input.in", "r", stdin);
  freopen("c://test//output.out", "w", stdout);
}
template <class T1, class T2>
inline void gmax(T1 &a, T2 b) {
  if (b > a) a = b;
}
template <class T1, class T2>
inline void gmin(T1 &a, T2 b) {
  if (b < a) a = b;
}
const int N = 2e5 + 10, M = 0, Z = 1e9 + 7, ms63 = 0x3f3f3f3f;
int n;
struct Bit {
  int a[N], b[N];
  void init() {
    memset(a, 0, sizeof(a));
    memset(b, 0, sizeof(b));
  }
  void add(int a[], int x, int val) {
    for (; x <= n; x += x & -x) a[x] += val;
  }
  int cnt(int a[], int x) {
    int ret = 0;
    for (; x; x -= x & -x) ret += a[x];
    return ret;
  }
} bit;
int k, a, b, q;
int nowa[N], nowb[N];
int main() {
  while (~scanf("%d%d%d%d%d", &n, &k, &a, &b, &q)) {
    bit.init();
    memset(nowa, 0, sizeof(nowa));
    memset(nowb, 0, sizeof(nowb));
    while (q--) {
      int op, d, x;
      scanf("%d", &op);
      if (op == 1) {
        scanf("%d%d", &d, &x);
        bit.add(bit.a, d, -nowa[d]);
        bit.add(bit.b, d, -nowb[d]);
        nowa[d] = min(nowa[d] + x, a);
        nowb[d] = min(nowb[d] + x, b);
        bit.add(bit.a, d, nowa[d]);
        bit.add(bit.b, d, nowb[d]);
      } else {
        scanf("%d", &d);
        int ansa = bit.cnt(bit.a, n) - bit.cnt(bit.a, d + k - 1);
        int ansb = bit.cnt(bit.b, d - 1);
        printf("%d\n", ansa + ansb);
      }
    }
  }
  return 0;
}
