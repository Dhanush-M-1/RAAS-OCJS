#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      if (j == i) j++;
      if (j > 9) break;
      for (int k = 1; k <= 9; k++) {
        if (k == j || k == i) k++;
        if (k > 9) break;
        for (int l = 1; l <= 9; l++) {
          if (l == k || l == j || l == i) l++;
          if (l > 9) break;
          if (r1 == i + j && r2 == k + l && c1 == i + k && c2 == j + l &&
              d1 == i + l && d2 == j + k) {
            cout << i << " " << j << endl << k << " " << l << endl;
            return 0;
          }
        }
      }
    }
  }
  cout << -1 << endl;
  return 0;
}
