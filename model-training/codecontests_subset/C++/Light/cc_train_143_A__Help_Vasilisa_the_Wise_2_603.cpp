#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a11, a12, a21, a22;
  a11 = (r1 + c1 - d2) / 2;
  a21 = c1 - a11;
  a12 = r1 - a11;
  a22 = r2 - a21;
  if (a11 != a22 && a11 != a12 && a11 != a21 && a12 != a21 && a12 != a22 &&
      a21 != a22 && d2 == a21 + a12 && c2 == a12 + a22 && r2 == a21 + a22 &&
      a11 > 0 && a11 <= 9 && a12 > 0 && a12 <= 9 && a21 > 0 && a21 <= 9 &&
      a22 > 0 && a22 <= 9) {
    cout << a11 << " " << a12 << endl;
    cout << a21 << " " << a22 << endl;
  } else {
    cout << "-1" << endl;
  }
}
