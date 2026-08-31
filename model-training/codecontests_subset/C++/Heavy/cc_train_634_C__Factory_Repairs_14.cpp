#include <bits/stdc++.h>
using namespace std;
long long power(long long a, long long b) {
  long long rs = 1, cr = a;
  while (b) {
    if (b & 1) rs = (rs * cr) % 1000000007;
    cr = (cr * cr) % 1000000007;
    b >>= 1;
  }
  return rs;
}
long long a[212345], b[212345], cnt[212345];
void update(long long ar[], int idx, int vl) {
  while (idx < 212345) {
    ar[idx] += vl;
    idx += (idx & -idx);
  }
}
long long read(long long ar[], int idx) {
  long long rs = 0;
  while (idx) {
    rs += ar[idx];
    idx -= (idx & -idx);
  }
  return rs;
}
void solve() {
  int n, k, q, d, ch;
  long long o;
  long long c1, c2;
  scanf("%d", &n);
  scanf("%d", &k);
  scanf("%lld", &c1);
  scanf("%lld", &c2);
  scanf("%d", &q);
  while (q--) {
    scanf("%d", &ch);
    if (ch == 1) {
      scanf("%d", &d);
      scanf("%lld", &o);
      update(a, d, min(max(0ll, c1 - cnt[d]), o));
      update(b, d, min(max(0ll, c2 - cnt[d]), o));
      cnt[d] += o;
    } else {
      scanf("%d", &d);
      long long rs = read(b, d - 1);
      d += k - 1;
      rs += read(a, 212345 - 1);
      rs -= read(a, d);
      printf("%lld\n", rs);
    }
  }
}
int main() {
  int t = 1;
  while (t--) {
    solve();
  }
}
