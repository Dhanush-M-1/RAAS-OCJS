#include <bits/stdc++.h>
using namespace std;
const int nax = 1e5 + 5;
int a[nax];
int b[nax];
int c[nax];
int main() {
  int n;
  cin >> n;
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
  sort(b, b + (n - 1));
  sort(c, c + (n - 2));
  int f = 0;
  for (int i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) {
      f = 1;
      cout << a[i] << endl;
      break;
    }
  }
  if (f == 0) {
    cout << a[n - 1] << endl;
  }
  f = 0;
  for (int i = 0; i < n - 2; i++) {
    if (c[i] != b[i]) {
      f = 1;
      cout << b[i] << endl;
      break;
    }
  }
  if (f == 0) {
    cout << b[n - 2] << endl;
  }
  return 0;
}
