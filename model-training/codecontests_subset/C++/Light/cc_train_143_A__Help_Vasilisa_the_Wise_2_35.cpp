#include <bits/stdc++.h>
using namespace std;
int main() {
  int a1, a2, b1, b2, c1, c2;
  cin >> a1 >> a2 >> b1 >> b2 >> c1 >> c2;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      for (int l = 1; l <= 9; l++) {
        for (int k = 1; k <= 9; k++) {
          if (a1 == i + j && a2 == l + k && b1 == i + l && b2 == j + k &&
              c1 == i + k && c2 == j + l && i != j && i != l && i != k &&
              j != l && j != k && l != k) {
            cout << i << " " << j << endl << l << " " << k << endl;
            return 0;
          }
        }
      }
    }
  }
  cout << -1 << endl;
  return 0;
}
