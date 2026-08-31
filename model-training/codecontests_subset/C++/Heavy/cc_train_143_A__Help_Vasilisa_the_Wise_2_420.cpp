#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2;
  cin >> c1 >> c2;
  cin >> d1 >> d2;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      for (int k = 1; k <= 9; k++) {
        for (int l = 1; l <= 9; l++) {
          if (i != j && i != k && i != l && j != k && j != l && k != l) {
            if (i + j == c1 && k + l == c2 && i + k == r1 && j + l == r2 &&
                i + l == d1 && k + j == d2) {
              cout << i << " " << k << "\n" << j << " " << l << "\n";
              return 0;
            }
          }
        }
      }
    }
  }
  cout << "-1" << endl;
  return 0;
}
