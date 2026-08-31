#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    bool cnt = 0;
    set<int> x;
    int n, m, ans;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
      int a;
      cin >> a;
      x.insert(a);
    }
    for (int i = 0; i < m; i++) {
      int b;
      cin >> b;
      if (x.find(b) != x.end() && !cnt) {
        cnt = 1;
        ans = b;
      }
    }
    if (!cnt) {
      cout << "NO\n";
    } else {
      cout << "YES\n";
      cout << 1 << " " << ans << endl;
    }
  }
  return 0;
}
