#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
int a[N];
struct fenwick {
  long long fen[N];
  fenwick() { memset(fen, 0, sizeof fen); }
  void add(int x, int d) {
    for (int i = x + 1; i < N; i += i & -i) {
      fen[i] += d;
    }
  }
  long long sum(int x) {
    long long ans = 0;
    for (int i = x; i; i -= i & -i) {
      ans += fen[i];
    }
    return ans;
  }
  long long sum(int l, int r) { return sum(r) - sum(l); }
  int kth(int k) {
    int x = 0;
    for (int i = 17; ~i; i--) {
      if ((x | 1 << i) < N && fen[x | 1 << i] <= k) {
        x |= 1 << i;
        k -= fen[x];
      }
    }
    return x;
  }
} t1, t2;
int solve() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    a[x] = i;
  }
  long long rev = 0;
  for (int i = 1; i <= n; i++) {
    t1.add(a[i], 1);
    t2.add(a[i], a[i]);
    rev += t1.sum(a[i] + 1, 2e5 + 1);
    int t = i - 1 >> 1;
    int m = t1.kth(t);
    long long mv = 0;
    ++t;
    mv += t2.sum(m + 1, 2e5 + 1) - 1ll * (m + 1) * (i - t) -
          1ll * (i - t) * (i - t - 1) / 2;
    mv += 1ll * m * t - t2.sum(m + 1) - 1ll * t * (t - 1) / 2;
    printf("%lld ", mv + rev);
  }
  puts("");
  return 0;
}
signed main() {
  solve();
  return 0;
}
