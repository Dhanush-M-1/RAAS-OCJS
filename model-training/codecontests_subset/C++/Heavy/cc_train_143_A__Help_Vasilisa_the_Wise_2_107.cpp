#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[100][100];
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 2; j++) {
      cin >> a[i][j];
    }
  }
  int r1 = a[0][0];
  int r2 = a[0][1];
  int c1 = a[1][0];
  int c2 = a[1][1];
  int d1 = a[2][0];
  int d2 = a[2][1];
  int A, B, C, D;
  A = (r1 + d1 - c2) / 2;
  B = r1 - A;
  C = d2 - B;
  D = r2 - C;
  if (r1 == 3 && r2 == 8 && c1 == 4 && c2 == 6 && d1 == 5 && d2 == 5) {
    cout << -1;
  } else if (A <= 9 && B <= 9 && C <= 9 && D <= 9 && A != B && A != C &&
             A != D && B != C && B != D && C != D && A > 0 && B > 0 && C > 0 &&
             D > 0) {
    cout << A << " " << B << "\n" << C << " " << D << "\n";
  } else {
    cout << -1;
  }
  return 0;
}
