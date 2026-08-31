#include <bits/stdc++.h>
using namespace std;
int main() {
  long n, c;
  while (cin >> n >> c) {
    long i, a[100001] = {0}, d = 0, mx = 0;
    for (int i = 0, _n = n; i < _n; i++) {
      cin >> a[i];
    }
    for (i = 0; i < n - 1; i++) {
      if (a[i] > a[i + 1]) {
        d = a[i] - a[i + 1];
        mx = max(d, mx);
      }
    }
    if (mx - c >= 0)
      cout << mx - c;
    else
      cout << "0";
    cout << endl;
  }
  return 0;
}
