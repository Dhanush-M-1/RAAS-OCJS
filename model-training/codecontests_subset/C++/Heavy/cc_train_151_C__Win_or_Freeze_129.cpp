#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC target("avx,avx2,fma")
using namespace std;
const long long MOD = 1e9 + 7;
const long long mxN = 2e5 + 3;
void solve() {
  long long n;
  cin >> n;
  long long cnt = 0;
  long long q = n;
  map<long long, long long> mp;
  for (long long i = 2; i * i <= n; ++i) {
    while (q % i == 0) {
      cnt++;
      mp[i]++;
      q /= i;
    }
  }
  if (q > 1) cnt++, mp[q]++;
  if (cnt < 2) {
    cout << 1 << "\n";
    cout << 0 << "\n";
  } else if (cnt == 2) {
    cout << 2 << "\n";
  } else {
    cout << 1 << "\n";
    long long ans = 1;
    bool fir = true;
    for (auto it : mp) {
      if (fir) {
        if (it.second > 1) {
          ans = (it.first * it.first);
          break;
        } else {
          ans = (it.first);
          fir = false;
        }
      } else {
        ans *= (it.first);
        break;
      }
    }
    cout << ans << "\n";
  }
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long nT = 1;
  for (long long i = 1; i <= nT; ++i) solve();
  return 0;
}
