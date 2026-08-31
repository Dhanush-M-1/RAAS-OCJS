#include <bits/stdc++.h>
using namespace std;
int main() {
  int c1, c2, r1, r2, d1, d2, x[5], i, j;
  cin >> r1 >> r2;
  cin >> c1 >> c2;
  cin >> d1 >> d2;
  x[3] = ((r1 - d1) + c2) / 2;
  x[2] = d2 - x[3];
  x[4] = c2 - x[3];
  x[1] = d1 - x[4];
  if (x[1] + x[2] == c1 && x[3] + x[4] == c2 && x[1] + x[3] == r1 &&
      x[2] + x[4] == r2 && x[1] + x[4] == d1 && x[2] + x[3] == d2) {
    for (i = 1; i < 4; i++) {
      for (j = i + 1; j <= 4; j++)
        if (x[i] == x[j] || x[i] > 9 || x[j] > 9 || x[i] < 1 || x[j] < 1) {
          cout << -1;
          return 0;
        }
    }
    cout << x[1] << " " << x[3] << endl << x[2] << " " << x[4];
  } else
    cout << -1;
  return 0;
}
