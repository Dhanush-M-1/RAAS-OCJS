#include <bits/stdc++.h>
using namespace std;
long long int n;
void solve() {
  cin >> n;
  long long int x[n], h[n];
  for (long long int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  long long int curr[n];
  memset(curr, 0, sizeof(curr));
  long long int ans = min(2ll, n);
  curr[0] = -1;
  for (long long int i = 1; i < n - 1; i++) {
    if (curr[i - 1] != 1) {
      if (x[i] - h[i] > x[i - 1]) {
        ans++;
        curr[i] = -1;
      } else if (x[i] + h[i] < x[i + 1]) {
        ans++;
        curr[i] = 1;
      }
    } else if (x[i - 1] + h[i - 1] < x[i] - h[i]) {
      ans++;
      curr[i] = -1;
    } else if (x[i] + h[i] < x[i + 1]) {
      ans++;
      curr[i] = 1;
    }
  }
  cout << ans;
}
int32_t main() {
  {
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
  };
  long long int t = 1;
  while (t--) {
    solve();
    cout << "\n";
  }
  return 0;
}
