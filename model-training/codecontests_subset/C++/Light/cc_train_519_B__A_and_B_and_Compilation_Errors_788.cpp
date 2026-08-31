#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, q = 0, y = 0, d = 0, w;
  cin >> n;
  int a[n], b[n - 1], c[n - 2];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    q += a[i];
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b[i];
    y += b[i];
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c[i];
    d += c[i];
  }
  cout << q - y << "  " << y - d;
}
