#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-9;
const double pi = acos(-1.0);
int n, x[100011], h[100011];
int main() {
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> x[i] >> h[i];
  if (n == 1) {
    puts("1");
    return 0;
  }
  int ans = 2, last = x[0];
  for (int i = 1; i < n - 1; ++i) {
    if (x[i] - h[i] > last) {
      ans++;
      last = x[i];
    } else if (x[i] + h[i] < x[i + 1]) {
      ans++;
      last = x[i] + h[i];
    } else {
      last = x[i];
    }
  }
  cout << ans;
  return 0;
}
