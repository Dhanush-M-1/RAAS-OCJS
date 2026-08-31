#include <bits/stdc++.h>
using namespace std;
int r[2], c[2], d[2];
int n[3];
int cntn = 0;
int main() {
  cin >> r[0] >> r[1] >> c[0] >> c[1] >> d[0] >> d[1];
  for (int i = 1; i <= 9; i++)
    for (int j = 1; j <= 9; j++)
      if (i + j == r[0] && i != j)
        for (int q = 1; q <= 9; q++)
          if (i != q && j != q && i + q == c[0] && j + q == d[1])
            for (int k = 1; k <= 9; k++)
              if (i != k && j != k && q != k && i + k == d[0] &&
                  j + k == c[1] && q + k == r[1]) {
                cout << i << " " << j << endl << q << " " << k << endl;
                return 0;
              }
  cout << -1 << endl;
  return 0;
}
