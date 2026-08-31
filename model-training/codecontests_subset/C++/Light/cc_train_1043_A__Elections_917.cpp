#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n];
  int s = 0;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    s += a[i];
  }
  for (int ans = 1; ans <= 1000; ans++) {
    int cur = 0;
    bool ok = 0;
    for (int i = 0; i < n; i++) {
      if (ans - a[i] < 0) {
        ok = 1;
        break;
      }
      int t = ans - a[i];
      cur += t;
    }
    if (ok) continue;
    if (cur > s) {
      cout << ans << endl;
      return 0;
    }
  }
}
