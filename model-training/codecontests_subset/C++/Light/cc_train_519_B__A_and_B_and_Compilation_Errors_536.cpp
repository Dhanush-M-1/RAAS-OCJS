#include <bits/stdc++.h>
using namespace std;
int main() {
  int no1, no2, i, n, a[100000], b[100000], c[100000];
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i];
  for (i = 0; i < n - 1; i++) cin >> b[i];
  for (i = 0; i < n - 2; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      no1 = a[i];
      break;
    }
  }
  for (i = 0; i < n - 1; i++) {
    if (b[i] != c[i]) {
      no2 = b[i];
      break;
    }
  }
  cout << no1 << endl;
  cout << no2;
  return 0;
}
