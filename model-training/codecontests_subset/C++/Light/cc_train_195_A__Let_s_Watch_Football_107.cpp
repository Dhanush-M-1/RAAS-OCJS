#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int l = 1, r = 1e6 + 6, ans = 0;
  while (l <= r) {
    int mid = (l + r) / 2;
    bool z = true;
    int k = b * mid;
    int w = 0;
    for (int i = 1; i <= c; i++) {
      k += b;
      k -= a;
      if (k < 0) {
        z = false;
      }
    }
    if (z) {
      r = mid - 1;
    } else {
      ans = mid;
      l = mid + 1;
    }
  }
  if (ans == 0)
    cout << 1;
  else
    cout << ans + 1;
}
