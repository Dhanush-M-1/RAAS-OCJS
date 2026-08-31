#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, d, k;
  cin >> n;
  int a[n], b[n - 1], c[n - 2];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  for (int i = 0; i < (n - 1); i++) {
    cin >> b[i];
  }
  sort(b, b + n - 1);
  for (int i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      k = a[i];
      break;
    }
  }
  for (int i = 0; i < (n - 2); i++) {
    cin >> c[i];
  }
  sort(c, c + n - 2);
  for (int i = 0; i < n - 1; i++) {
    if (b[i] != c[i]) {
      d = b[i];
      break;
    }
  }
  cout << k << endl << d << endl;
  return 0;
}
