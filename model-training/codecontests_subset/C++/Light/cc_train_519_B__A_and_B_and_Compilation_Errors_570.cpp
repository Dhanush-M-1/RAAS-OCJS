#include <bits/stdc++.h>
using namespace std;
int n, a[100010], b[100010], c[100010];
int main() {
  cin >> n;
  for (int i = 0; i <= n - 1; i++) cin >> a[i];
  for (int i = 0; i <= n - 2; i++) cin >> b[i];
  for (int i = 0; i <= n - 3; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (int i = 0; i <= n - 1; i++) {
    if (a[i] != b[i]) {
      cout << a[i] << endl;
      break;
    }
  }
  for (int i = 0; i <= n - 2; i++) {
    if (b[i] != c[i]) {
      cout << b[i];
      break;
    }
  }
  return 0;
}
