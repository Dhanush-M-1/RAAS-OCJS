#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  int a[n], b[n - 1], c[n - 2];
  for (int i = 0; i < n; i++) cin >> a[i];
  for (int i = 0; i < n - 1; i++) cin >> b[i];
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (int i = 0; i < n; i++) {
    if (i == n - 1) {
      cout << a[n - 1] << endl;
      break;
    } else if (a[i] != b[i]) {
      cout << a[i] << endl;
      break;
    }
  }
  for (int i = 0; i < n - 1; i++) {
    if (i == n - 2) {
      cout << b[n - 2] << endl;
      break;
    } else if (b[i] != c[i]) {
      cout << b[i] << endl;
      break;
    }
  }
  return 0;
}
