#include <bits/stdc++.h>
using namespace std;
int t, n, m, k, x;
int main() {
  cin >> t;
  while (t--) {
    k = -1;
    map<int, int> a;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
      cin >> x;
      a[x] = 1;
    }
    for (int i = 1; i <= m; i++) {
      cin >> x;
      if (a[x] == 1) k = x;
    }
    puts(k == -1 ? "NO" : "YES");
    if (k != -1) cout << 1 << ' ' << k << endl;
  }
}
