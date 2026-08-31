#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2, flag;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      for (int k = 1; k <= 9; k++) {
        for (int n = 1; n <= 9; n++) {
          if (i != j && i != k && i != n && j != k && j != n && k != n) {
            flag++;
            if (i + j == r1 && k + n == r2 && i + k == c1 && j + n == c2 &&
                i + n == d1 && j + k == d2) {
              cout << i << " " << j << endl << k << " " << n << endl;
              return 0;
            } else if (flag == 3024)
              cout << "-1" << endl;
          }
        }
      }
    }
  }
  return 0;
}
