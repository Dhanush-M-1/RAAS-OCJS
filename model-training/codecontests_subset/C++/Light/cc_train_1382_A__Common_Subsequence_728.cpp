#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    vector<int> a(n), b(m);
    map<int, int> mp;
    vector<int> sol;
    for (int i = 0; i < n; i++) {
      cin >> a[i];
      mp[a[i]] = 1;
    }
    for (int j = 0; j < m; j++) {
      cin >> b[j];
      if (mp[b[j]] > 0) {
        sol.push_back(b[j]);
      }
    }
    if (sol.size() == 0)
      cout << "NO\n";
    else {
      cout << "YES\n" << 1 << " " << sol[0] << "\n";
    }
  }
  return 0;
}
