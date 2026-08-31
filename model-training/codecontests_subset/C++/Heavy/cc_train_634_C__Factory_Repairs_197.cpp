#include <bits/stdc++.h>
using namespace std;
using i64 = long long;
using Pii = pair<int, int>;
constexpr int MAX = 1000100;
using namespace std;
struct SegTree {
  i64 sum[MAX];
  int M, LIM;
  void PushUp(int x) { sum[x] = sum[x << 1] + sum[(x << 1) | 1]; }
  void Init(int n, int m) {
    for (M = 1; M < n + 2; M <<= 1)
      ;
    memset(sum, 0, sizeof(sum));
    LIM = m;
  }
  void Update(int x, i64 add) {
    sum[x |= M] += add;
    if (sum[x] > LIM) sum[x] = LIM;
    for (x >>= 1; x; x >>= 1) PushUp(x);
  }
  i64 Query(int l, int r) {
    i64 ret = 0;
    for (l = (l | M) - 1, r = (r | M) + 1; l ^ r ^ 1; l >>= 1, r >>= 1) {
      if (~l & 1) ret += sum[l ^ 1];
      if (r & 1) ret += sum[r ^ 1];
    }
    return ret;
  }
} sta, stb;
int main() {
  int n, k, a, b, q;
  while (~scanf("%d%d%d%d%d", &n, &k, &a, &b, &q)) {
    sta.Init(n, b);
    stb.Init(n, a);
    int c, u, v;
    for (int i = 0; i < q; ++i) {
      scanf("%d", &c);
      if (c == 1) {
        scanf("%d%d", &u, &v);
        sta.Update(u, v);
        stb.Update(u, v);
      } else {
        scanf("%d", &u);
        i64 ans = 0;
        if (u > 1) ans += sta.Query(1, u - 1);
        if (u + k <= n) ans += stb.Query(u + k, n);
        cout << ans << endl;
      }
    }
  }
  return 0;
}
