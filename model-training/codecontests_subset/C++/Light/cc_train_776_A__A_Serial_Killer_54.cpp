#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k, l, m, n;
  string a[1010], b[1010], x, y;
  cin >> a[0] >> b[0] >> n;
  for (i = 1; i <= n; i++) {
    cin >> x >> y;
    if (x == a[i - 1]) {
      a[i] = y;
      b[i] = b[i - 1];
    } else {
      a[i] = a[i - 1];
      b[i] = y;
    }
  }
  for (i = 0; i <= n; i++) {
    cout << a[i] << " " << b[i] << endl;
  }
  return 0;
}
