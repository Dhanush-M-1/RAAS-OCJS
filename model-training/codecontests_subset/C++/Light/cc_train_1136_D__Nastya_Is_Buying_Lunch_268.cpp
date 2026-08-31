#include <bits/stdc++.h>
using namespace std;
const int MAXN = 6e5 + 5;
set<int> s1[MAXN];
set<int> s2;
int p[MAXN];
int main() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> p[i];
  }
  for (int i = 1; i <= m; i++) {
    int x, y;
    cin >> x >> y;
    s1[x].insert(y);
  }
  s2.insert(p[n]);
  int ans = 0;
  for (int i = n - 1; i >= 0; i--) {
    bool ok = true;
    for (auto x : s2) {
      if (s1[p[i]].find(x) == s1[p[i]].end()) {
        ok = false;
        break;
      }
    }
    if (ok) {
      ans++;
    } else {
      s2.insert(p[i]);
    }
  }
  cout << ans << endl;
}
