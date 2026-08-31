#include <bits/stdc++.h>
using namespace std;
double aux(long long x) {
  long long ans = 0;
  while (x) ans = ans * 10 + x % 10, x /= 10;
  return (double)ans;
}
map<double, long long> mp1, mp2;
double f[200005];
long long n, m, w;
signed main() {
  scanf("%I64d%I64d%I64d", &n, &m, &w);
  for (long long i = 1; i <= n; i++) f[i] = i / aux(i), mp1[f[i]]++;
  long long tot = 0;
  for (long long i = 1; i <= m; i++) tot += mp1[aux(i) / i];
  if (tot < w) return puts("-1"), 0;
  long long xx = n, yy = 1;
  long long ansx, ansy, plk = 1e18;
  long long sum = mp1[1.0];
  mp2[1.0]++;
  while (xx >= 1 && yy <= m) {
    if (sum >= w) {
      if (xx * yy < plk) plk = xx * yy, ansx = xx, ansy = yy;
      double pl = 1.0 * xx / aux(xx);
      mp1[pl]--;
      sum -= mp2[pl];
      xx--;
    } else {
      yy++;
      double pl = aux(yy) / yy;
      sum += mp1[pl];
      mp2[pl]++;
    }
  }
  cout << ansx << " " << ansy;
  return 0;
}
