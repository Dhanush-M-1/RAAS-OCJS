#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long int n;
  cin >> n;
  long long int f[n], b[n];
  long long int ans = -1;
  for (long long int i = 0; i < n; i++) {
    long long int x;
    cin >> x;
    f[i] = x - 1;
    b[i] = 1000000 - x;
    ans = max(ans, min(f[i], b[i]));
  }
  cout << ans << "\n";
}
