#include <bits/stdc++.h>
using namespace std;
int main() {
  unsigned n;
  cin >> n;
  unsigned i, a[n];
  for (i = 0; i < n; i++) {
    cin >> a[i];
  }
  unsigned c = 0, t = 0;
  for (i = 0; i < n; i++) {
    if (a[i] <= 1000000 / 2) {
      c = a[i] - 1;
    } else {
      t = 1000000 - a[i];
      break;
    }
  }
  cout << max(c, t);
  return 0;
}
