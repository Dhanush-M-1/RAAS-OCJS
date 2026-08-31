#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    set<int> a;
    for (__typeof(n) i = (0) - ((0) > (n)); i != (n) - ((0) > (n));
         i += 1 - 2 * ((0) > (n))) {
      int x;
      cin >> x;
      a.insert(x);
    }
    int brr[m];
    int ans = -1;
    for (__typeof(m) i = (0) - ((0) > (m)); i != (m) - ((0) > (m));
         i += 1 - 2 * ((0) > (m))) {
      cin >> brr[i];
      if (a.find(brr[i]) != a.end()) {
        ans = brr[i];
      }
    }
    if (ans == -1) {
      cout << "NO" << '\n';
    } else {
      cout << "YES" << '\n';
      cout << 1 << " " << ans << '\n';
    }
  }
}
