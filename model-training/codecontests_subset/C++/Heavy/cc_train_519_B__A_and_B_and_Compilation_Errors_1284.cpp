#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n];
  int b[n - 1];
  int c[n - 2];
  int i;
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
  sort(b, b + (n - 1));
  sort(c, c + (n - 2));
  int f = 0;
  for (i = 0; i < n - 1; i++) {
    if (a[i] == b[i]) {
      f = 0;
      continue;
    } else {
      f = 1;
      cout << a[i] << endl;
      break;
    }
  }
  if (f == 0) {
    cout << a[n - 1] << endl;
  }
  int g = 0;
  for (i = 0; i < n - 2; i++) {
    if (b[i] == c[i]) {
      g = 0;
      continue;
    } else {
      g = 1;
      cout << b[i] << endl;
      break;
    }
  }
  if (g == 0) {
    cout << b[n - 2] << endl;
  }
}
