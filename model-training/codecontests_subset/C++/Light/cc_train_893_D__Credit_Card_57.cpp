#include <bits/stdc++.h>
using namespace std;
int n, d, usualusu, usu, sol, x;
int main() {
  cin >> n >> d;
  for (int i = 1; i <= n; ++i) {
    cin >> x;
    if (x) {
      usualusu += x;
      usu += x;
      if (usualusu > d) {
        cout << -1;
        return 0;
      }
      usu = min(usu, d);
    } else {
      if (usu >= 0)
        usualusu = max(usualusu, 0);
      else {
        ++sol;
        usualusu = 0;
        usu = d;
      }
    }
  }
  cout << sol;
  return 0;
}
