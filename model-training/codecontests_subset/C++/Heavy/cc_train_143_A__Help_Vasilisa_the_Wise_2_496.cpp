#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int c1, c2, d1, d2, r1, r2, i, j, k, l, f = 0;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (i = 1; i < 10; i++) {
    for (j = 1; j < 10; j++) {
      if (j != i)
        for (k = 1; k < 10; k++) {
          if (k != j && k != i)
            for (l = 1; l < 10; l++) {
              if (l != k && l != j && l != i)
                if (i + j == r1 && k + l == r2 && i + k == c1 && j + l == c2 &&
                    i + l == d1 && j + k == d2) {
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
  if (f)
    cout << i << " " << j << endl << k << " " << l;
  else
    cout << -1;
  return 0;
}
