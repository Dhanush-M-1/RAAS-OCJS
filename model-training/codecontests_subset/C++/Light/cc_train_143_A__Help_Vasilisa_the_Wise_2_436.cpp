#include <bits/stdc++.h>
using namespace std;
int r, c, d, a, b, R, C, D, A, B;
int main() {
  cin >> r >> R >> c >> C >> d >> D;
  a = (r + c - D) / 2;
  A = (r + C - d) / 2;
  b = (R + c - d) / 2;
  B = (R + C - D) / 2;
  if (a > 0 && b > 0 && A > 0 && B > 0 && a < 10 && A < 10 && b < 10 &&
      B < 10 && a != b && b != B && B != A && A != a && A != b && a != B &&
      b + B == R && A + B == C && b + A == D)
    cout << a << " " << A << endl << b << " " << B;
  else
    cout << -1;
}
