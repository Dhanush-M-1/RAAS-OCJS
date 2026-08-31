#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t, a, b, ans = 0;
  vector<int> home;
  vector<int> away;
  cin >> t;
  while (t--) {
    cin >> a >> b;
    home.push_back(a);
    away.push_back(b);
  }
  for (int i = 0; i < home.size(); i++) {
    for (int j = 0; j < away.size(); j++) {
      if (home[i] == away[j]) ans++;
    }
  }
  cout << ans << "\n";
  return 0;
}
