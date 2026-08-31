#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d, e, f;
  cin >> a >> b >> c >> d >> e >> f;
  for (int i = 1; i <= 9; i++) {
    for (int j = 1; j <= 9; j++) {
      for (int k = 1; k <= 9; k++) {
        for (int g = 1; g <= 9; g++) {
          if (i + j == a && k + g == b && i + k == c && j + g == d &&
              i + g == e && j + k == f && i != j && i != k && i != g &&
              j != k && j != g && k != g) {
            cout << i << " " << j << endl;
            cout << k << " " << g << endl;
            return 0;
          }
        }
      }
    }
  }
  cout << -1;
}
