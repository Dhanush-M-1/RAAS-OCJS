#include <bits/stdc++.h>
using namespace std;
const int N = 44;
int main() {
  int r1, r2, c1, c2, d1, d2, a, b, c, d, f;
  while (cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2) {
    f = 0;
    for (a = 1; a < 10; a++)
      for (b = 1; b < 10; b++)
        if (b != a && a + b == r1)
          for (c = 1; c < 10; c++)
            if (c != a && c != b && a + c == c1 && c + b == d2)
              for (d = 1; d < 10; d++)
                if (d != a && d != b && d != c && c + d == r2 && b + d == c2 &&
                    a + d == d1) {
                  f = 1;
                  goto end;
                }
  end:
    if (f)
      cout << a << " " << b << endl << c << " " << d << endl;
    else
      cout << -1 << endl;
  }
}
