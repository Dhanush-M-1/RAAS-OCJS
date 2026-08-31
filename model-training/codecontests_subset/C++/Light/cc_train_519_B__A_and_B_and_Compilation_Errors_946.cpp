#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n], b[n], c[n], active = 0;
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) cin >> b[i];
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + (n - 1));
  sort(c, c + (n - 2));
  b[n - 1] = -2;
  c[n - 2] = -2;
  c[n - 1] = -2;
  for (int i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      cout << a[i] << "\n";
      active = i;
      break;
    }
  }
  for (int i = 0; i < n; i++) {
    if (b[i] != c[i]) {
      cout << b[i] << "\n";
      break;
    }
  }
  return 0;
}
