#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, x, y;
  cin >> n;
  long long a[n], b[n - 1], c[n - 2];
  for (i = 0; i < n; i++) cin >> a[i];
  sort(a, a + n);
  for (i = 0; i < n - 1; i++) cin >> b[i];
  sort(b, b + (n - 1));
  for (i = 0; i < n - 2; i++) cin >> c[i];
  sort(c, c + (n - 2));
  for (i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      x = a[i];
      break;
    }
  }
  for (i = 0; i < n - 1; i++) {
    if (b[i] != c[i]) {
      y = b[i];
      break;
    }
  }
  cout << x << endl;
  cout << y << endl;
}
