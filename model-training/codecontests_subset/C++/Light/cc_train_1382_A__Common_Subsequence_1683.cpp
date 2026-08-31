#include <bits/stdc++.h>
using namespace std;
const int N = 1e3 + 5;
int main() {
  long long tst;
  cin >> tst;
  while (tst--) {
    long long n, m;
    cin >> n >> m;
    map<long long, long long> was;
    for (long long i = 0; i < n; i++) {
      long long x;
      cin >> x;
      was[x] = 1;
    }
    bool ok = true;
    long long ans;
    for (long long i = 0; i < m; i++) {
      long long x;
      cin >> x;
      if (was[x] && ok) {
        ok = false;
        ans = x;
      }
    }
    if (ok)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      cout << 1 << ' ' << ans << endl;
    }
  }
}
