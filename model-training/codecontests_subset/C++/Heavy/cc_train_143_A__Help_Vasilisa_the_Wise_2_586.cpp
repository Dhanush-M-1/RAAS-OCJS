#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  bool flag = true;
  int A, B, C, D;
  if ((r1 - c2 + d1) % 2 == 0) {
    A = (r1 - c2 + d1) / 2;
    D = (d1 - r1 + c2) / 2;
  } else {
    flag = false;
  }
  if ((c2 - r2 + d2) % 2 == 0) {
    B = (c2 - r2 + d2) / 2;
    C = (d2 - c2 + r2) / 2;
  } else {
    flag = false;
  }
  if (flag &&
      (0 < A && A < 10 && 0 < B && B < 10 && 0 < C && C < 10 && 0 < D &&
       D < 10) &&
      !(A == B || B == C || C == D || A == D || A == C || B == D) &&
      ((A + C) == c1 && (B + D) == c2 && (A + B) == r1 && (C + D) == r2 &&
       (A + D) == d1 && (B + C) == d2)) {
    cout << A << " " << B << endl;
    cout << C << " " << D << endl;
  } else {
    cout << -1 << endl;
  }
  return 0;
}
