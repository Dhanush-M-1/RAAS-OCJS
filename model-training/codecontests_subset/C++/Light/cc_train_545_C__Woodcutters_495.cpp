#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, i, x = 2, p;
  cin >> n;
  long long a[n], h[n];
  for (i = 0; i < n; i++) cin >> a[i] >> h[i];
  if (n == 1) x = 1;
  p = a[0];
  for (i = 1; i < n - 1; i++) {
    if (h[i] < a[i] - p) {
      p = a[i];
      x++;
    } else if (h[i] < a[i + 1] - a[i]) {
      p = a[i] + h[i];
      x++;
    } else
      p = a[i];
  }
  cout << x;
}
