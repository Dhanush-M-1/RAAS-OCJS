#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t, n, i, j, k, x, flag;
  long long* a;
  cin >> t;
  while (t--) {
    cin >> n;
    a = new long long[n];
    for (i = 0; i < n; i++) {
      cin >> a[i];
    }
    if (a[0] + a[1] <= a[n - 1]) {
      cout << "1 2 " << n << "\n";
    } else {
      cout << "-1"
           << "\n";
    }
  }
}
