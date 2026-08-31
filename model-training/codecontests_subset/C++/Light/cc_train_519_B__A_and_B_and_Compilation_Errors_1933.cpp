#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  int a[n + 1];
  int b[n];
  int c[n - 1];
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n - 1; i++) cin >> b[i];
  for (int i = 1; i <= n - 2; i++) cin >> c[i];
  sort(a + 1, a + n + 1);
  sort(b + 1, b + n);
  sort(c + 1, c + n - 1);
  for (int i = 1; i <= n; i++) {
    if (i == n || (a[i] != b[i])) {
      cout << a[i] << endl;
      break;
    }
  }
  for (int i = 1; i <= n - 1; i++) {
    if (i == n - 1 || (b[i] != c[i])) {
      cout << b[i] << endl;
      return 0;
    }
  }
  return 0;
}
