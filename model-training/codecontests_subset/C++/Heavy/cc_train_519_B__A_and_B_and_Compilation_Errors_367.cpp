#include <bits/stdc++.h>
using namespace std;
int main() {
  long int n;
  cin >> n;
  long int a[n], b[n - 1], c[n - 2], x1, x2;
  for (long int i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  for (long int i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  sort(b, b + n - 1);
  for (long int i = 0; i < n - 1; i++) {
    if (a[i] != b[i]) {
      x1 = a[i];
      goto yy;
    }
  }
  x1 = a[n - 1];
yy:
  for (long int i = 0; i < n - 2; i++) cin >> c[i];
  sort(c, c + n - 2);
  for (long int i = 0; i < n - 2; i++) {
    if (b[i] != c[i]) {
      x2 = b[i];
      goto pp;
    }
  }
  x2 = b[n - 2];
pp:
  cout << x1 << endl << x2;
  return 0;
}
