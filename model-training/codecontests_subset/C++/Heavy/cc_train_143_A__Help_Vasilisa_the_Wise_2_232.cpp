#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  bool eshta = false;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      if (i == j) continue;
      for (int c = 1; c <= 9; c++) {
        if (i == c || j == c) continue;
        for (int l = 1; l <= 9; l++) {
          if (i == l || c == l || j == l) continue;
          if (i + j == r1 && c + l == r2 && i + c == c1 && l + j == c2 &&
              i + l == d1 && c + j == d2) {
            eshta = true;
            cout << i << " " << j << endl << c << " " << l;
          }
        }
      }
    }
  }
  if (eshta == false) {
    cout << -1;
  }
}
