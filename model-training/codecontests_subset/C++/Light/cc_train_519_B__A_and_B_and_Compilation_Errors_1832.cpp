#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  int a[n], b[n - 1], c[n - 2], i;
  for (i = 0; i < n; i++) cin >> a[i];
  for (i = 0; i < n - 1; i++) cin >> b[i];
  for (i = 0; i < n - 2; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (i = 0; i < n; i++) {
    if (a[i] != b[i]) {
      cout << a[i] << "\n";
      break;
    }
  }
  for (i = 0; i < n - 1; i++)
    if (b[i] != c[i]) {
      cout << b[i];
      break;
    }
  return 0;
}
