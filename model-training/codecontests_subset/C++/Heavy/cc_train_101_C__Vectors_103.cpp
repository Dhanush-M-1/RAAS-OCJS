#include <bits/stdc++.h>
using namespace std;
long long X1, Y1;
long long A, B;
long long x, y;
int main() {
  while (cin >> X1 >> Y1) {
    cin >> A >> B >> x >> y;
    string res = "NO";
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (x == 0 && y == 0) {
          if (X1 == A && Y1 == B) res = "YES";
        } else {
          bool good = true;
          long long c1 = A - X1;
          long long c2 = B - Y1;
          long long soor = c1 * x + c2 * y;
          long long makh = x * x + y * y;
          if (soor % makh) good = false;
          long long a = soor / makh;
          if (y == 0) {
            soor = c2;
            makh = -x;
          } else {
            soor = c1 - a * x;
            makh = y;
          }
          if (soor % makh) good = false;
          long long b = soor / makh;
          if (good) {
            res = "YES";
          }
        }
        swap(A, B);
        A *= -1;
      }
      swap(X1, Y1);
      X1 *= -1;
    }
    cout << res << endl;
  }
  return 0;
}
