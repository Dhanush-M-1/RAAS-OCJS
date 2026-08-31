#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, m;
  cin >> n >> m;
  vector<long long> t(m), l(m), r(m), d(m);
  for (long long i = 0; i < m; i++) {
    cin >> t[i] >> l[i] >> r[i] >> d[i];
    l[i]--;
    r[i]--;
  }
  vector<long long> cur(n, 0), base(n, 0);
  for (long long i = 0; i < m; i++) {
    if (t[i] == 1) {
      for (long long j = l[i]; j <= r[i]; j++) cur[j] += d[i];
    } else {
      long long maxidx = -1, maxx = INT_MIN;
      for (long long j = l[i]; j <= r[i]; j++) {
        long long nbase = d[i] - (cur[j]);
        if (nbase <= base[j] || base[j] == 0) base[j] = nbase;
      }
    }
  }
  long long f = 1;
  vector<long long> ans = base;
  for (long long i = 0; i < m; i++) {
    if (t[i] == 1) {
      for (long long j = l[i]; j <= r[i]; j++) base[j] += d[i];
    } else {
      long long maxx = INT_MIN;
      for (long long j = l[i]; j <= r[i]; j++) {
        maxx = max(maxx, base[j]);
      }
      if (maxx != d[i]) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (long long i = 0; i < n; i++) cout << ans[i] << " ";
  return 0;
}
