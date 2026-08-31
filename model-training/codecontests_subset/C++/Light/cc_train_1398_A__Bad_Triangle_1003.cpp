#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long t;
  cin >> t;
  for (long long test = 0; test < t; test++) {
    long long n;
    cin >> n;
    vector<long long> lst(n);
    for (long long i = 0; i < n; i++) cin >> lst[i];
    bool ok = false;
    for (long long i = 0; i < n - 2; i++) {
      if (lst[i] + lst[i + 1] <= lst.back()) {
        cout << i + 1 << " " << i + 2 << " " << n << "\n";
        ok = true;
        break;
      }
    }
    if (!ok) {
      cout << -1 << "\n";
    }
  }
  return 0;
}
