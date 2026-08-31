#include <bits/stdc++.h>
using namespace std;
long long n, a[200000], b[200000], c[200000];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  sort(a + 1, a + 1 + n);
  for (int i = 1; i < n; i++) {
    cin >> b[i];
  }
  sort(b + 1, b + n);
  b[n] = 999999999;
  for (int i = 1; i < n - 1; i++) {
    cin >> c[i];
  }
  sort(c + 1, c + n - 1);
  c[n - 1] = 999999999;
  for (int i = 1; i <= n; i++) {
    if (a[i] != b[i]) {
      cout << a[i] << "\n";
      break;
    }
  }
  for (int i = 1; i < n; i++) {
    if (c[i] != b[i]) {
      cout << b[i] << "\n";
      break;
    }
  }
  return 0;
}
