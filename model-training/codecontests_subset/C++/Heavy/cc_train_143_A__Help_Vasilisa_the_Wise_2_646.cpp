#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (long long int i = 1; i < 10; ++i) {
    for (long long int j = 1; j < 10; ++j) {
      for (long long int k = 1; k < 10; ++k) {
        for (long long int l = 1; l < 10; ++l) {
          if (i + k == c1 && i + j == r1 && i + l == d1 && j + k == d2 &&
              k + l == r2 && j + l == c2 && i != j && i != k && i != l &&
              j != k && j != l && k != l) {
            cout << i << " " << j << " " << '\n' << k << " " << l;
            return 0;
          }
        }
      }
    }
  }
  cout << -1 << '\n';
  return 0;
}
