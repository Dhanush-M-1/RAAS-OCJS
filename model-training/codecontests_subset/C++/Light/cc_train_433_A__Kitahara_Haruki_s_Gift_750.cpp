#include <bits/stdc++.h>
using namespace std;
long long i, j, k, a[300000], b[100000] = {0}, c[100000] = {0}, x, y, xx, yy, t,
                              p, q, n, ll, rr, r, cap, cap2;
char l[1000], lll[1000], bb[200000], tt[1000];
int main() {
  cin >> x;
  p = 0;
  q = 0;
  y = 0;
  for (i = 0; i < x; i++) {
    cin >> a[i];
    y = y + a[i];
    if (a[i] == 100)
      p++;
    else
      q++;
  }
  if (p % 2 != 0) {
    cout << "NO\n";
    return 0;
  } else if (p == 0) {
    if (q % 2 == 0)
      cout << "YES\n";
    else
      cout << "NO\n";
  } else
    cout << "YES\n";
}
