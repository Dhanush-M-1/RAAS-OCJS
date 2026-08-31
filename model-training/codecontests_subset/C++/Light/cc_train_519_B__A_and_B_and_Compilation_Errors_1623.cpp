#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, x = 0, y = 0;
  cin >> n;
  int a[n], b[n - 1], c[n - 2];
  for (i = 0; i < n; i++) cin >> a[i];
  for (i = 0; i < n - 1; i++) cin >> b[i];
  for (i = 0; i < n - 2; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (i = 0; i < n; i++) {
    x++;
    if (a[i] != b[i]) {
      cout << a[i] << endl;
      break;
    }
    if (x == n) cout << a[n - 1] << endl;
  }
  for (i = 0; i < n - 1; i++) {
    y++;
    if (b[i] != c[i]) {
      cout << b[i];
      break;
    }
    if (y == n - 1) cout << b[n - 2] << endl;
  }
}
