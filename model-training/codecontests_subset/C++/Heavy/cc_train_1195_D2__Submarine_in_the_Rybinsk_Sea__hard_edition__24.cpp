#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
const long long int maxn = 5e5 + 1;
void solve() {
  long long int n;
  cin >> n;
  long long int a[n], len[11];
  memset(len, 0, sizeof(len));
  for (long long int i = 0; i < n; i++) {
    cin >> a[i];
    long long int d = a[i];
    long long int k = 0;
    while (d) {
      d /= 10;
      k++;
    }
    len[k]++;
  }
  long long int power[30];
  power[0] = 1;
  for (long long int i = 1; i < 30; i++) {
    power[i] = power[i - 1] * 10;
    power[i] %= (long long int)(998244353);
  }
  long long int ans = 0;
  for (long long int i = 0; i < n; i++) {
    long long int d = a[i];
    long long int k = 0;
    vector<long long int> v;
    while (d) {
      long long int r = d % 10;
      d /= 10;
      k++;
      for (long long int l = 1; l <= 10; l++) {
        if (l >= k) {
          long long int aa = power[2 * k - 1];
          aa *= r;
          aa %= (long long int)(998244353);
          aa *= len[l];
          aa %= (long long int)(998244353);
          ans += aa;
          ans %= (long long int)(998244353);
        } else {
          long long int aa = power[l + k - 1];
          aa *= len[l];
          aa %= (long long int)(998244353);
          aa *= r;
          aa %= (long long int)(998244353);
          ans += aa;
          ans %= (long long int)(998244353);
        }
        if (l >= k - 1) {
          long long int aa = power[2 * (k - 1)];
          aa *= len[l];
          aa %= (long long int)(998244353);
          aa *= r;
          aa %= (long long int)(998244353);
          ans += aa;
          ans %= (long long int)(998244353);
        } else {
          long long int aa = power[l + k - 1];
          aa *= len[l];
          aa %= (long long int)(998244353);
          aa *= r;
          aa %= (long long int)(998244353);
          ans += aa;
          ans %= (long long int)(998244353);
        }
      }
    }
  }
  cout << ans << endl;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t;
  t = 1;
  for (long long int i = 0; i < t; i++) {
    solve();
  }
  return 0;
}
