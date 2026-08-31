#include <bits/stdc++.h>
using namespace std;
const long long mod = (long long)1e9 + 7;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    long long a[n], b[m];
    for (long long i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < (int)(m); ++i) cin >> b[i];
    map<long long, long long> mp;
    for (int i = 0; i < (int)(n); ++i) mp[a[i]] = 1;
    long long f = 0, in;
    for (int i = 0; i < (int)(m); ++i) {
      if (mp[b[i]]) {
        f = 1;
        in = i;
        break;
      }
    }
    if (f) {
      cout << "YES\n";
      cout << 1 << " " << b[in];
    } else
      cout << "NO";
    cout << "\n";
  }
  return 0;
}
