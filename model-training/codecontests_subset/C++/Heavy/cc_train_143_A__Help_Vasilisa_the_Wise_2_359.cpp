#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2;
int checker(int a, int b, int c, int d) {
  if ((a + c == c1) && (c + b == d2) && (c + d == r2) && (a + b == r1) &&
      (a + d == d1) && (b + d == c2)) {
    if (a != b && b != c && c != d && a != d && a != c && b != d) {
      return 1;
    } else
      return 0;
  } else
    return 0;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int flag = 0;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      for (int k = 1; k <= 9; k++) {
        for (int l = 1; l <= 9; l++) {
          if (checker(i, j, k, l)) {
            cout << i << " " << j << endl << k << " " << l << endl;
            flag = 1;
            break;
          }
        }
      }
    }
  }
  if (flag == 0) cout << "-1" << endl;
  return 0;
}
