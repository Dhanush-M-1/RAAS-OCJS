#include <bits/stdc++.h>
using namespace std;
int a[1000001], b[1000001], c[1000001];
int main() {
  int n, i, x = 0, y = 0;
  cin >> n;
  for (i = 1; i <= n; i++) cin >> a[i];
  for (i = 1; i <= n - 1; i++) cin >> b[i];
  for (i = 1; i <= n - 2; i++) cin >> c[i];
  for (i = 1; i <= n; i++) {
    x += a[i];
    x -= b[i];
  }
  for (i = 1; i <= n - 1; i++) {
    y += b[i];
    y -= c[i];
  }
  cout << x << "\n" << y;
}
