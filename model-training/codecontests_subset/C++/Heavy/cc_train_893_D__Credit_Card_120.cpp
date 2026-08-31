#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout << fixed << setprecision(20);
  long long n, d;
  cin >> n >> d;
  long long a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  long long now = 0;
  long long ans = 0;
  long long pot = 0;
  long long sum = 0;
  for (int i = 0; i < n; i++) {
    now += a[i];
    pot = min(pot, d - now);
    if (now > d) {
      cout << -1 << endl;
      return 0;
    }
    if (a[i] == 0 && now < 0) {
      if (ans) {
        if (-now > pot || -now > sum) {
          ans++;
          sum = d;
        } else {
          sum += now;
        }
        pot = d;
      } else {
        ans++;
        sum = d;
        pot = d;
      }
      now = 0;
    }
  }
  cout << ans << endl;
}
