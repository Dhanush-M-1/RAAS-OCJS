#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int T = 1;
  cin >> T;
  while (T--) {
    int n, m, te, f = 0, ans;
    cin >> n >> m;
    map<int, int> ma;
    for (int i = 0; i < n; i++) {
      cin >> te;
      if (ma[te] == 0) ma[te]++;
    }
    for (int i = 0; i < m; i++) {
      cin >> te;
      if (ma[te]) ma[te]++;
      if (ma[te] >= 2 && !f) {
        f = 1;
        ans = te;
      }
    }
    if (f) {
      cout << "YES\n1 " << ans << "\n";
    } else
      cout << "NO\n";
  }
  return 0;
}
