#include <bits/stdc++.h>
using namespace std;
const int MAX = 100007;
int a[MAX], b[MAX], c[MAX];
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; ++i) cin >> a[i];
  for (int i = 0; i < n - 1; ++i) cin >> b[i];
  for (int i = 0; i < n - 2; ++i) cin >> c[i];
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (int i = 0; i < n - 1; ++i) {
    if (a[i] != b[i]) {
      cout << a[i] << endl;
      break;
    }
    if (i == n - 2) {
      cout << a[n - 1] << endl;
    }
  }
  for (int i = 0; i < n - 2; ++i) {
    if (b[i] != c[i]) {
      cout << b[i] << endl;
      break;
    }
    if (i == n - 3) {
      cout << b[n - 2] << endl;
    }
  }
}
