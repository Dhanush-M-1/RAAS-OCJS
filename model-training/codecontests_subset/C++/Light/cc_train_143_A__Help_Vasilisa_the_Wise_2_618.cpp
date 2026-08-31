#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2;
int main() {
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (int i = 1; i < 10; i++)
    for (int j = 1; j < 10; j++)
      for (int k = 1; k < 10; k++)
        for (int z = 1; z < 10; z++) {
          if (i == j || i == k || i == z || j == k || j == z || k == z)
            continue;
          if (i + j == r1 && k + z == r2 && i + k == c1 && j + z == c2 &&
              i + z == d1 && j + k == d2) {
            cout << i << " " << j << endl << k << " " << z;
            return 0;
          }
        }
  cout << -1;
  return 0;
}
