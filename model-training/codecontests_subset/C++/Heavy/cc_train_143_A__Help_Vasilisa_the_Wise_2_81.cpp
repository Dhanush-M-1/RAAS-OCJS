#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2, i, j, k, l, flag = 0;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (i = 1; i <= 9; i++) {
    for (j = 1; j <= 9; j++) {
      for (k = 1; k <= 9; k++) {
        for (l = 1; l <= 9; l++) {
          if (i + k == r1 and i + j == c1 and j + l == r2 and k + l == c2 and
              k + j == d2 and i + l == d1) {
            if (i != j and i != k and i != l and j != k and j != l and k != l) {
              flag = 1;
              cout << i << " " << k << endl;
              cout << j << " " << l;
              break;
            }
          }
        }
      }
    }
  }
  if (flag == 0) {
    cout << -1;
  }
}
