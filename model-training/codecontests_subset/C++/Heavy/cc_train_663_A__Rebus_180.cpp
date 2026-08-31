#include <bits/stdc++.h>
using namespace std;
int l, i, a[10000], t, tot, p, ans, c[10000], cc, d[10000], dd, ccc, ddd, q;
bool bo;
string s;
int main() {
  cin >> s;
  l = s.length();
  bo = true;
  while (l == 1 && (s[0] < 48 || s[0] > 57)) {
    if (s[0] == '?') {
      a[++t] = bo ? 1 : -1;
      if (bo)
        c[++cc] = t;
      else
        d[++dd] = t;
    }
    if (s[0] == '-') bo = false;
    if (s[0] == '+') bo = true;
    cin >> s;
    l = s.length();
  }
  p = 1;
  for (i = l - 1; i >= 0; i--) {
    tot = tot + p * (s[i] - 48);
    p = p * 10;
  }
  for (i = 1; i <= t; i++) ans = ans + a[i];
  if (cc * tot - dd < tot || cc - tot * dd > tot) {
    printf("Impossible");
    return 0;
  }
  ccc = 1;
  ddd = 1;
  while (ans != tot) {
    if (ans < tot) {
      q = tot - ans;
      if (tot - a[c[ccc]] >= q) {
        a[c[ccc]] += q;
        ans += q;
      } else {
        ans = ans + (tot - a[c[ccc]]);
        a[c[ccc]] = a[c[ccc]] + (tot - a[c[ccc]]);
        ccc++;
      }
    }
    if (ans > tot) {
      q = ans - tot;
      if (tot - abs(a[d[ddd]]) >= q) {
        a[d[ddd]] -= q;
        ans -= q;
      } else {
        ans = ans - (tot - abs(a[d[ddd]]));
        a[d[ddd]] = a[d[ddd]] - (tot - abs(a[d[ddd]]));
        ddd++;
      }
    }
    if (ccc > cc && ans < tot) break;
    if (ddd > dd && ans > tot) break;
  }
  if (ans != tot)
    printf("Impossible");
  else {
    printf("Possible\n");
    printf("%d ", a[1]);
    for (i = 2; i <= t; i++) {
      if (a[i] > 0)
        printf("+ ");
      else
        printf("- ");
      printf("%d ", abs(a[i]));
    }
    printf("= %d", tot);
  }
}
