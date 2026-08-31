#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  cin >> n;
  long long int x[n], h[n];
  for (i = 0; i < n; i++) {
    scanf("%lld%lld", &x[i], &h[i]);
  }
  if (n == 1) {
    cout << 1 << endl;
    return 0;
  }
  int ans = 2;
  bool fl = true;
  for (i = 1; i < n - 1; i++) {
    if (fl) {
      if ((x[i] - h[i]) > x[i - 1]) {
        ans++;
      } else {
        fl = false;
      }
    } else {
      if ((x[i - 1] + h[i - 1] + h[i]) < x[i]) {
        ans += 2;
        fl = true;
      } else if ((x[i - 1] + h[i - 1]) < x[i]) {
        ans++;
      } else if ((x[i] - h[i]) > x[i - 1]) {
        ans++;
        fl = true;
      }
    }
  }
  if (!fl) {
    if ((x[i - 1] + h[i - 1]) < x[i]) {
      ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
