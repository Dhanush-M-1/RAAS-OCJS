#include <bits/stdc++.h>
using namespace std;
const long long INF = (1000000007LL);
long long n, m, i, j;
long long st[6000], cst[6000];
long long t[6000], l[6000], r[6000], s[6000];
int main(int argc, char** argv) {
  cin >> n >> m;
  for (i = 1; i <= n; ++i) st[i] = 1000000000LL;
  for (i = 0; i < m; ++i) cin >> t[i] >> l[i] >> r[i] >> s[i];
  for (i = m - 1; i >= 0; --i) {
    if (t[i] == 1)
      for (j = l[i]; j <= r[i]; ++j) st[j] -= s[i];
    else
      for (j = l[i]; j <= r[i]; ++j) st[j] = min(st[j], s[i]);
  }
  for (i = 1; i <= n; ++i) cst[i] = st[i];
  int bad = 0;
  for (i = 0; i < m; ++i) {
    if (t[i] == 1)
      for (j = l[i]; j <= r[i]; ++j) cst[j] += s[i];
    else {
      long long mmax = cst[l[i]];
      for (j = l[i]; j <= r[i]; ++j) mmax = max(mmax, cst[j]);
      if (mmax != s[i]) bad = 1;
    }
  }
  if (bad == 1)
    cout << "NO" << endl;
  else {
    cout << "YES" << endl;
    for (i = 1; i <= n; ++i) cout << min(1000000000LL, st[i]) << " ";
    cout << endl;
  }
  return 0;
}
