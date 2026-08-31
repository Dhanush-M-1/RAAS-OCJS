#include <bits/stdc++.h>
using namespace std;
long long Bin_expo(long long n, long long b, long long m) {
  long long res = 1;
  while (b > 0) {
    if (b & 1) {
      res = (res * n) % m;
    }
    n = (n * n) % m;
    b /= 2;
  }
  return res % m;
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long tc;
  cin >> tc;
  while (tc--) {
    long long n;
    cin >> n;
    vector<long long> v(n);
    for (long long i = 0; i < n; i++) {
      cin >> v[i];
    }
    long long f = 0;
    for (long long i = 2; i < n; i++) {
      if (v[i] >= v[0] + v[1]) {
        cout << "1 2 " << i + 1 << "\n";
        f = 1;
        break;
      }
    }
    if (f) continue;
    cout << "-1\n";
  }
  return 0;
}
