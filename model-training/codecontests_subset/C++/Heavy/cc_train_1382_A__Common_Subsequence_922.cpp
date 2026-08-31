#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t;
  cin >> t;
  while (t--) {
    long long int x, y;
    cin >> x >> y;
    long long int b[y];
    set<long long int> s;
    for (long long int i = 0; i < x; i++) {
      long long int g;
      cin >> g;
      s.insert(g);
    }
    long long int ans = -1;
    for (long long int i = 0; i < y; i++) {
      cin >> b[i];
      auto it = s.find(b[i]);
      if (it != s.end()) {
        ans = b[i];
      }
    }
    if (ans != -1) {
      cout << "YES" << endl;
      cout << 1 << " " << ans << endl;
    } else {
      cout << "NO" << endl;
    }
  }
  return 0;
}
