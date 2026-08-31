#include <bits/stdc++.h>
using namespace std;
int main() {
  long int n, i;
  cin >> n;
  long int a[n], b[n - 1], c[n - 2];
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
  int t = 0;
  for (i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) {
      t = 1;
      cout << a[i] << "\n";
      break;
    }
  }
  if (t == 0) cout << a[n - 1] << "\n";
  int l = 0;
  for (i = 0; i < n - 2; i++) {
    if (b[i] != c[i]) {
      l = 1;
      cout << b[i] << "\n";
      break;
    }
  }
  if (l == 0) cout << b[n - 2] << "\n";
}
