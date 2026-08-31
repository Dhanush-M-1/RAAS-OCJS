#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(0);
  cin.exceptions(cin.failbit);
  int T;
  cin >> T;
  while (T--) {
    long long int t, n, i, j, x, y, m, l, d, k;
    cin >> n >> m;
    vector<int> a(n), b(m);
    for (i = 0; i < (n); ++i) cin >> a[i];
    for (i = 0; i < (m); ++i) cin >> b[i];
    for (i = 0; i < (n); ++i) {
      for (j = 0; j < (m); ++j) {
        if (a[i] == b[j]) {
          cout << "YES"
               << "\n"
               << 1 << " " << a[i] << "\n";
          x = 1;
          break;
        }
      }
      if (x == 1) break;
    }
    if (x == 0)
      cout << "NO"
           << "\n";
    else
      x = 0;
  }
}
