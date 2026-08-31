#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long n, m, e = 0;
    cin >> n >> m;
    long long a[n], b[m];
    for (long long i = 0; i < n; i++) cin >> a[i];
    for (long long i = 0; i < m; i++) cin >> b[i];
    for (long long i = 0; i < n; i++) {
      for (long long j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          e = a[i];
          break;
        }
      }
      if (e) break;
    }
    if (e) {
      cout << "YES\n";
      cout << 1 << " " << e << "\n";
    } else
      cout << "NO\n";
  }
}
