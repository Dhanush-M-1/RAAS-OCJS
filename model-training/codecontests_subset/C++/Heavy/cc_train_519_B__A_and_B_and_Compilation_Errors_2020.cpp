#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  int b[n - 1];
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  int c[n - 2];
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  bool bf = false;
  for (int i = 0; i < n - 1; i++) {
    if (a[i] == b[i])
      continue;
    else {
      bf = true;
      cout << a[i] << endl;
      break;
    }
  }
  if (!bf) {
    cout << a[n - 1] << endl;
  }
  bool cf = false;
  for (int i = 0; i < n - 2; i++) {
    if (b[i] == c[i])
      continue;
    else {
      cf = true;
      cout << b[i] << endl;
      break;
    }
  }
  if (!cf) {
    cout << b[n - 2] << endl;
  }
  return 0;
}
