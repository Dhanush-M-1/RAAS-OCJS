#include <bits/stdc++.h>
using namespace std;
int main() {
  long long c1, c2, r1, r2, d1, d2;
  bool flag = false;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int i = 1; i <= 9; i++)
    for (int j = 1; j <= 9; j++)
      for (int k = 1; k <= 9; k++)
        for (int m = 1; m <= 9; m++) {
          if (i != j && i != k && i != m && j != k && j != m && k != m) {
            if (i + m == d1 && j + k == d2 && i + j == r1 && k + m == r2 &&
                i + k == c1 && j + m == c2) {
              if (flag) break;
              flag = true;
              cout << i << " " << j << endl;
              cout << k << " " << m << endl;
              break;
            }
          }
        }
  if (!flag) cout << "-1" << endl;
  return 0;
}
