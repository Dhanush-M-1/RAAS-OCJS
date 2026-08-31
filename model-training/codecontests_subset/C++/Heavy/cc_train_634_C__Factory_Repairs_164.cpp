#include <bits/stdc++.h>
using namespace std;
long long unsigned arb[200005], arb1[200005], A[200005], B[200005], n, k, a, b,
    q, tip, d, x, xx, p, y;
void upd1(long long unsigned poz, long long unsigned x) {
  long long unsigned bit;
  for (; poz <= n;) {
    bit = (poz & (-poz));
    arb1[poz] += x;
    poz += bit;
  }
}
void upd(long long unsigned poz, long long unsigned x) {
  long long unsigned bit;
  for (; poz <= n;) {
    bit = (poz & (-poz));
    arb[poz] += x;
    poz += bit;
  }
}
long long unsigned query1(long long unsigned poz) {
  long long unsigned bit, sol = 0;
  for (; poz;) {
    bit = (poz & (-poz));
    sol += arb1[poz];
    poz -= bit;
  }
  return sol;
}
long long unsigned query(long long unsigned poz) {
  long long unsigned bit, sol = 0;
  for (; poz;) {
    bit = (poz & (-poz));
    sol += arb[poz];
    poz -= bit;
  }
  return sol;
}
int main() {
  cin.sync_with_stdio(0);
  cout.sync_with_stdio(0);
  cin >> n >> k >> a >> b >> q;
  for (; q; q--) {
    cin >> tip;
    if (tip == 1) {
      cin >> d >> x;
      xx = min(b - A[d], x);
      A[d] += xx;
      upd1(d, xx);
      xx = min(a - B[d], x);
      B[d] += xx;
      upd(d, xx);
    } else {
      cin >> p;
      x = y = 0;
      if (p > 1) x = query1(p - 1);
      if (p + k <= n) y = query(n) - query(p + k - 1);
      cout << x + y << '\n';
    }
  }
  return 0;
}
