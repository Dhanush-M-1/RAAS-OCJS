#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t, i, n, m, j, a;
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> t;
  while (t--) {
    vector<long long> a, b, c;
    long long g, h;
    cin >> n >> m;
    for (i = 0; i < n; i++) {
      cin >> g;
      a.push_back(g);
    }
    for (i = 0; i < m; i++) {
      cin >> h;
      b.push_back(h);
    }
    for (i = 0; i < n; i++) {
      for (j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          c.push_back(a[i]);
          break;
        }
      }
    }
    if (c.size() >= 1) {
      cout << "YES" << '\n';
      cout << 1 << " " << c[0] << '\n';
      ;
      cout << '\n';
    } else {
      cout << "NO" << '\n';
    }
  }
}
