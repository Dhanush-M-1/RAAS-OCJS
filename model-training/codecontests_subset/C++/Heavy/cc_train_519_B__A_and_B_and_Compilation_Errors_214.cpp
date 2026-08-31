#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  int a[n], b[n], c[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  bool f = false;
  bool s = false;
  for (int i = 0; i < n - 1; i++) {
    if (b[i] != a[i]) {
      cout << a[i] << "\n";
      f = true;
      break;
    }
  }
  if (!f) {
    cout << a[n - 1] << "\n";
  }
  for (int i = 0; i < n - 2; i++) {
    if (b[i] != c[i]) {
      cout << b[i] << "\n";
      s = true;
      break;
    }
  }
  if (!s) {
    cout << b[n - 2] << "\n";
  }
  return 0;
}
