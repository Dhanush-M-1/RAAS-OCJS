#include <bits/stdc++.h>
using namespace std;
int main() {
  bool ff = false;
  int a, b, c, d, e, f;
  cin >> a >> b >> c >> d >> e >> f;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      for (int k = 1; k <= 9; k++) {
        for (int l = 1; l <= 9; l++) {
          if (i + j == a && k + l == b && i + k == c && j + l == d &&
              i + l == e && j + k == f && i != j && i != k && i != l &&
              j != k && j != l && k != l) {
            ff = true;
            cout << i << " " << j << endl << k << " " << l << endl;
            break;
          }
        }
        if (ff == true) break;
      }
      if (ff == true) break;
    }
    if (ff == true) break;
  }
  if (ff == false) cout << -1 << endl;
  return 0;
}
