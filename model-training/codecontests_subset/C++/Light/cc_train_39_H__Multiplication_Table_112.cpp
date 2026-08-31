#include <bits/stdc++.h>
using namespace std;
int main() {
  int k;
  cin >> k;
  int tabla[k - 1][k - 1];
  int i, j;
  for (i = 0; i < k - 1; i++) {
    for (j = 0; j < k - 1; j++) {
      int M = (i + 1) * (j + 1);
      int p = 0, q = 1;
      while (M >= k) {
        p = p + (M % k) * (q);
        q = 10 * q;
        M = M / k;
      }
      p = p + (M) * (q);
      tabla[i][j] = p;
    }
  }
  for (i = 0; i < k - 1; i++) {
    for (j = 0; j < k - 1; j++) {
      cout << tabla[i][j] << " ";
    }
    cout << "\n";
  }
  return 0;
}
