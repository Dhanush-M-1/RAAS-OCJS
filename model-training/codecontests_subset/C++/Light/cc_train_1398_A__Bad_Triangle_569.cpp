#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t, k;
  cin >> t;
  for (k = 1; k <= t; k++) {
    long long int n, i, s = 0, f = 0;
    cin >> n;
    int a[n];
    for (i = 0; i < n; i++) {
      cin >> a[i];
    }
    s = a[0] + a[1];
    for (i = 2; i < n; i++) {
      if (a[i] >= s) {
        f = 1;
        cout << 1 << " " << 2 << " " << i + 1;
        break;
      }
    }
    if (f == 0) cout << -1;
    cout << endl;
  }
  return 0;
}
