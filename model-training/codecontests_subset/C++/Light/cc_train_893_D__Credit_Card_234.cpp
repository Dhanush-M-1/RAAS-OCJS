#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, d;
  cin >> n >> d;
  long long a[n];
  for (int i = 0; i < n; i++) cin >> a[i];
  int ans = 0;
  long long l = 0, r = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] > 0) {
      if (a[i] + l > d) {
        cout << -1;
        return 0;
      }
      l = min(d, l + a[i]);
      r = min(d, r + a[i]);
    } else if (a[i] == 0) {
      if (r < 0) {
        ans++;
        l = 0, r = d;
      } else {
        l = max(l, 0LL);
        r = max(r, 0LL);
      }
    } else {
      l += a[i];
      r += a[i];
    }
  }
  cout << ans;
}
