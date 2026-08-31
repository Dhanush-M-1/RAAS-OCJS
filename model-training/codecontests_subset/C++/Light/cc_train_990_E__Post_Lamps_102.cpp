#include <bits/stdc++.h>
using namespace std;
const int maxN = 1000013;
int n, k, m;
long long a[maxN], s[maxN], pr[maxN], cnt[maxN];
int main() {
  cin >> n >> m >> k;
  for (int i = 0; i <= n; ++i) pr[i] = i;
  for (int i = 0; i < m; ++i) {
    cin >> s[i];
    if (s[i])
      pr[s[i]] = pr[s[i] - 1];
    else {
      cout << -1;
      return 0;
    }
  }
  for (int i = 1; i <= k; ++i) cin >> a[i];
  int mn = 1;
  for (int i = 1; i <= n; ++i)
    mn = (((mn) < (i - pr[i - 1])) ? (i - pr[i - 1]) : (mn));
  if (mn > k) {
    cout << -1;
    return 0;
  }
  for (int i = mn; i <= k; ++i) {
    int pos = 0, c = 0;
    while (pos < n) {
      pos += i;
      ++c;
      if (pos >= n) break;
      pos = pr[pos];
    }
    cnt[i] = c;
  }
  long long ans = cnt[mn] * a[mn];
  for (int i = mn; i <= k; ++i) {
    ans = (((ans) > (cnt[i] * a[i])) ? (cnt[i] * a[i]) : (ans));
  }
  cout << ans;
  getchar();
  getchar();
  return 0;
}
