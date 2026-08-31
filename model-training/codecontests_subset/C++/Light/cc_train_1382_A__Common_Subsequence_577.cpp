#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int ans = -1;
    int n, m, x;
    cin >> n >> m;
    set<int> S;
    for (int i = 0; i < n; i++) {
      cin >> x;
      S.insert(x);
    }
    for (int i = 0; i < m; i++) {
      cin >> x;
      if (S.count(x)) ans = x;
    }
    if (ans != -1)
      cout << "YES\n1 " << ans << endl;
    else
      cout << "NO\n";
  }
  return 0;
}
