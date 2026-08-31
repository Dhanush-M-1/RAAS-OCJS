#include <bits/stdc++.h>
using namespace std;
void smain();
clock_t start;
int main() {
  ios_base::sync_with_stdio(0);
  cout.precision(12);
  cout << fixed;
  smain();
  return 0;
}
long long n, k, a, b, q;
long long c[2][200002];
long long tr[2][4 * 200002];
void upd(long long t, long long v, long long l, long long r, long long pos,
         long long val) {
  if (l == r) return void(tr[t][v] = val);
  long long m = (l + r) / 2;
  if (pos <= m)
    upd(t, 2 * v, l, m, pos, val);
  else
    upd(t, 2 * v + 1, m + 1, r, pos, val);
  tr[t][v] = tr[t][2 * v] + tr[t][2 * v + 1];
}
long long query(long long t, long long v, long long l, long long r,
                long long ql, long long qr) {
  if (l == ql && r == qr) return tr[t][v];
  long long m = (l + r) / 2, r1 = 0, r2 = 0;
  if (ql <= m) r1 = query(t, 2 * v, l, m, ql, min(qr, m));
  if (qr > m) r2 = query(t, 2 * v + 1, m + 1, r, max(m + 1, ql), qr);
  return r1 + r2;
}
void smain() {
  for (; cin >> n >> k >> a >> b >> q;) {
    for (long long _ = 0; _ < q; _++) {
      long long t;
      cin >> t;
      if (t == 1) {
        long long d, v;
        cin >> d >> v;
        c[0][d] = min(a, c[0][d] + v);
        c[1][d] = min(b, c[1][d] + v);
        for (long long i = 0; i < 2; i++) upd(i, 1, 1, n, d, c[i][d]);
      } else {
        long long p;
        cin >> p;
        long long res = 0;
        if (p > 1) res += query(1, 1, 1, n, 1, p - 1);
        if (p + k <= n) res += query(0, 1, 1, n, p + k, n);
        cout << res << '\n';
      }
    }
  }
}
