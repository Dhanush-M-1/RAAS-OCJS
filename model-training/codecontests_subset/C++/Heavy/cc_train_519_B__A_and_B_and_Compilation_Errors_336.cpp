#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  int a[n], b[n - 1], c[n - 2], ch = 0;
  for (int i = 0; i < n; i++) cin >> a[i];
  sort(a, a + n);
  for (int i = 0; i < n - 1; i++) cin >> b[i];
  sort(b, b + (n - 1));
  for (int j = 0; j < n - 1; j++) {
    if (a[j] != b[j]) {
      cout << a[j] << endl;
      ch = 1;
      break;
    }
  }
  if (ch != 1) cout << a[n - 1] << endl;
  ch = 0;
  for (int i = 0; i < n - 2; i++) cin >> c[i];
  sort(c, c + (n - 2));
  for (int j = 0; j < n - 2; j++) {
    if (b[j] != c[j]) {
      cout << b[j] << endl;
      ch = 1;
      break;
    }
  }
  if (ch != 1) cout << b[n - 2] << endl;
}
