#include <bits/stdc++.h>
using namespace std;
long long n, k, a, b, q;
void pluss(vector<long long> &t, long long v, long long tl, long long tr,
           long long l, long long r, long long x, long long p) {
  if (l > tr || tl > r) return;
  if (tl >= l && tr <= r) {
    t[v] = min(t[v] + x, p ? b : a);
    return;
  }
  long long tm = (tl + tr) / 2;
  pluss(t, v * 2, tl, tm, l, r, x, p);
  pluss(t, v * 2 + 1, tm + 1, tr, l, r, x, p);
  t[v] = t[v * 2] + t[v * 2 + 1];
}
long long get_sum(vector<long long> &t, long long v, long long tl, long long tr,
                  long long l, long long r) {
  if (l > tr || tl > r) return 0;
  if (tl >= l && tr <= r) {
    return t[v];
  }
  long long tm = (tl + tr) / 2;
  return get_sum(t, v * 2, tl, tm, l, r) +
         get_sum(t, v * 2 + 1, tm + 1, tr, l, r);
}
signed main() {
  cin >> n >> k >> a >> b >> q;
  vector<long long> t(n * 4);
  vector<long long> tt(n * 4);
  while (q--) {
    long long c;
    scanf("%I64d", &c);
    if (c == 1) {
      long long num, cnt;
      scanf("%I64d %I64d", &num, &cnt);
      pluss(t, 1, 1, n, num, num, cnt, 0);
      pluss(tt, 1, 1, n, num, num, cnt, 1);
    } else {
      long long ind;
      scanf("%I64d", &ind);
      long long l = ind + k;
      long long ans;
      if (l > n)
        ans = 0;
      else {
        ans = get_sum(t, 1, 1, n, l, n);
      }
      ans += get_sum(tt, 1, 1, n, 1, ind - 1);
      printf("%I64d\n", ans);
    }
  }
}
