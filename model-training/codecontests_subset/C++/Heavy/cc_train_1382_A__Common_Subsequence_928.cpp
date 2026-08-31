#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
const char nl = '\n';
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    vector<int> a(n), b(m), c;
    for (int i{}; i < n; i++) cin >> a[i];
    for (int i{}; i < m; i++) cin >> b[i];
    if (n <= m) {
      for (int i{}; i < n; i++) {
        if (b.end() != find(b.begin(), b.end(), a[i])) {
          c.push_back(a[i]);
          break;
        }
      }
    } else {
      for (int i{}; i < m; i++) {
        if (a.end() != find(a.begin(), a.end(), b[i])) {
          c.push_back(b[i]);
          break;
        }
      }
    }
    if (c.size() != 0) {
      cout << "YES"
           << "\n";
      cout << c.size() << " " << c[0] << "\n";
    } else {
      cout << "NO"
           << "\n";
    }
  }
}
