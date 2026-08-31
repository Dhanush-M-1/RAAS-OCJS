#include <bits/stdc++.h>
using namespace std;
signed main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  long long n;
  cin >> n;
  long long a, b, c;
  for (long long i = 0; i < n; i++) {
    cin >> a >> b >> c;
    long long ans = 0;
    ans += min(b, c / 2);
    b -= ans;
    ans += min(a, b / 2);
    cout << ans * 3 << "\n";
  }
  return 0;
}
