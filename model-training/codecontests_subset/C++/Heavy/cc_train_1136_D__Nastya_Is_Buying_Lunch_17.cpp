#include <bits/stdc++.h>
using namespace std;
const int N = 500005;
int p[N];
set<int> s[N];
vector<int> v;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> p[i];
  for (int i = 1; i <= m; i++) {
    int x, y;
    cin >> x >> y;
    s[x].insert(y);
  }
  int ans = 0;
  for (int i = n - 1; i > 0; i--) {
    if (s[p[i]].count(p[n])) {
      bool s10 = true;
      for (int j = 0; j < v.size(); j++)
        if (s[p[i]].count(v[j]) == 0) {
          s10 = false;
          break;
        }
      if (s10 == false) {
        v.push_back(p[i]);
        continue;
      }
      ans++;
      continue;
    }
    v.push_back(p[i]);
  }
  cout << ans << endl;
  return 0;
}
