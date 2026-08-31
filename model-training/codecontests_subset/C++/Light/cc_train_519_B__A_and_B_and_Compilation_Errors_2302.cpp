#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  long f = 0, k = 0, p = 0;
  cin >> n;
  int a[n], b[n - 1], c[n - 2];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    f += a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
    k += b[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
    p += c[i];
  }
  cout << f - k << endl << k - p;
  return 0;
}
