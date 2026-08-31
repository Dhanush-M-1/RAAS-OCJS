#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, m, x, y, z, k, l;
  int a[100001], b[100001], c[100001];
  while (cin >> n) {
    for (i = 0; i < n; i++) {
      cin >> a[i];
    }
    for (i = 0; i < n - 1; i++) {
      cin >> b[i];
    }
    for (i = 0; i < n - 2; i++) {
      cin >> c[i];
    }
    sort(a, a + n);
    sort(b, b + n - 1);
    sort(c, c + n - 2);
    k = l = 1;
    for (i = 0; i < n - 1; i++) {
      if (a[i] != b[i]) {
        k = 0;
        cout << a[i] << endl;
        break;
      }
    }
    if (k) cout << a[i] << endl;
    for (i = 0; i < n - 2; i++) {
      if (b[i] != c[i]) {
        l = 0;
        cout << b[i] << endl;
        break;
      }
    }
    if (l) cout << b[i] << endl;
  }
  return 0;
}
