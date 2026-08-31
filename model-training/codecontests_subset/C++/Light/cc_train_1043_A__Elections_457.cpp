#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, k, l, m, n, p, s;
  cin >> n;
  int a[n];
  for (i = 0, s = 0, m = 0; i < n; i++) {
    cin >> a[i];
    s = s + a[i];
    if (a[i] > m) m = a[i];
  }
  s = s + 1;
  for (i = 0, p = 0; i < n; i++) {
    p = p + m - a[i];
  }
  if (p >= s) {
    cout << m;
    return 0;
  } else {
    p = s - p;
    if (p % n)
      p = (p / n) + 1;
    else
      p = (p / n);
    cout << m + p;
  }
}
