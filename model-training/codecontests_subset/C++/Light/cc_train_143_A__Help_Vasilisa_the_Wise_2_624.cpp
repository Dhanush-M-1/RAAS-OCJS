#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int c1, c2, d1, d2, r1, r2, i, j, k, l;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (i = 1; i < 10; i++) {
    j = r1 - i;
    k = c1 - i;
    l = d1 - i;
    if (i != j && i != k && i != l && j != k && j != l && k != l && j < 10 &&
        k < 10 && l < 10 && j > 0 && k > 0 && l > 0) {
      if (c2 == j + l && r2 == k + l && d2 == k + j) {
        cout << i << " " << j << "\n" << k << " " << l;
        return 0;
      }
    }
  }
  cout << "-1";
  return 0;
}
