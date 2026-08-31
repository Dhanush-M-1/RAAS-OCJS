#include <bits/stdc++.h>
using namespace std;
int main() {
  long long r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  long long num1, num2, num3, num4;
  int f = 0;
  for (num1 = 1; num1 <= 9; num1++) {
    for (num2 = 1; num2 <= 9; num2++) {
      if (num2 == num1) continue;
      for (num3 = 1; num3 <= 9; num3++) {
        if (num3 == num1 || num3 == num2) continue;
        for (num4 = 1; num4 <= 9; num4++) {
          if (num4 == num1 || num4 == num2 || num4 == num3) continue;
          if (num1 + num2 == r1 && num3 + num4 == r2 && num1 + num3 == c1 &&
              num2 + num4 == c2 && num1 + num4 == d1 && num2 + num3 == d2) {
            f = 1;
            break;
          }
        }
        if (f) break;
      }
      if (f) break;
    }
    if (f) break;
  }
  if (f) {
    cout << num1 << " " << num2 << "\n";
    cout << num3 << " " << num4;
  } else
    cout << -1;
}
