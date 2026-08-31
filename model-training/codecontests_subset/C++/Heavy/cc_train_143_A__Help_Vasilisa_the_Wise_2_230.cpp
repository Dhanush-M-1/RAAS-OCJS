#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2, ans = 0, i, j, k, l;
int main() {
  cin >> r1 >> r2;
  cin >> c1 >> c2;
  cin >> d1 >> d2;
  for (i = 1; i < 10; i++) {
    for (j = 1; j < 10; j++) {
      for (k = 1; k < 10; k++) {
        for (l = 1; l < 10; l++) {
          if (i + k == c1 && j + l == c2 && i + j == r1 && k + l == r2 &&
              i + l == d1 && k + j == d2) {
            ans = 1;
            break;
          }
        }
        if (ans == 1) break;
      }
      if (ans == 1) break;
    }
    if (ans == 1) break;
  }
  if (ans == 1 && i != j && i != k && i != l && j != k && j != l && k != l)
    cout << i << " " << j << endl << k << " " << l << endl;
  else
    cout << "-1" << endl;
  return 0;
}
