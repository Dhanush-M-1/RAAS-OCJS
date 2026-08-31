#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n, m;
    cin >> n >> m;
    vector<long long> a(n);
    vector<long long> b(m);
    for (long long i = 0; i < n; i++) cin >> a[i];
    for (long long i = 0; i < m; i++) cin >> b[i];
    long long cnt = 0;
    long long ans = -1;
    for (long long i = 0; i < n; i++) {
      if (cnt == 1)
        break;
      else {
        for (long long j = 0; j < m; j++) {
          if (a[i] == b[j]) {
            cnt = 1;
            ans = a[i];
            break;
          }
        }
      }
    }
    if (cnt == 0) {
      cout << "NO\n";
    } else {
      cout << "YES\n"
           << "1 " << ans << "\n";
    }
  }
}
