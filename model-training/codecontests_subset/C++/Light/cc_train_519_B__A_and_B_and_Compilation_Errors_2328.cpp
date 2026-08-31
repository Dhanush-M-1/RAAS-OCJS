#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a[100000], b[100000], c[100000], i, p[2];
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> a[i];
  }
  sort(a, a + n);
  for (i = 0; i < n - 1; i++) {
    cin >> b[i];
  }
  sort(b, b + n - 1);
  for (i = 0; i < n - 2; i++) {
    cin >> c[i];
  }
  sort(c, c + n - 2);
  for (i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      p[0] = a[i];
      break;
    }
  }
  for (i = 0; i < n; i++) {
    if (b[i] != c[i]) {
      p[1] = b[i];
      break;
    }
  }
  cout << p[0] << endl;
  cout << p[1] << endl;
  return 0;
}
