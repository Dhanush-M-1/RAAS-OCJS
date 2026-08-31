#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, ans = 2, tmp;
  cin >> n;
  if (n == 1) {
    cout << 1;
  } else {
    long long x[n], h[n];
    for (int k = 0; k < n; k++) cin >> x[k] >> h[k];
    for (int k = 1; k < n - 1; k++) {
      if (x[k] - h[k] > x[k - 1]) {
        ans++;
      } else if (x[k] + h[k] < x[k + 1]) {
        ans++;
        x[k] += h[k];
      }
    }
    cout << ans;
  }
}
