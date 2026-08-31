#include <bits/stdc++.h>
using namespace std;
int main() {
  int k, a[100][100], i, j, s[1000], z, m, n, h;
  while (cin >> k) {
    for (i = 1; i < k; i++) {
      for (j = 1; j < k; j++) {
        a[i][j] = i * j;
      }
    }
    for (i = 1; i < k; i++) {
      for (j = 1; j < k; j++) {
        z = a[i][j];
        m = 0;
        if (j != 1) cout << " ";
        while (z) {
          n = z % k;
          s[m++] = n;
          z = z / k;
        }
        if (z != 0) s[m++] = z;
        for (h = m - 1; h >= 0; h--) cout << s[h];
        memset(s, 0, sizeof(h));
      }
      cout << endl;
    }
  }
  return 0;
}
