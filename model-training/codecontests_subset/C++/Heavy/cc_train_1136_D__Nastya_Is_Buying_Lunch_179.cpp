#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
void solve() {
  int n, m;
  cin >> n >> m;
  int p[n];
  for (int i = 0; i <= n - 1; i++) cin >> p[i];
  set<int> st[n + 1];
  for (int i = 1; i <= m; i++) {
    int a, b;
    cin >> a >> b;
    st[a].insert(b);
  }
  set<int> s;
  vector<bool> flag(n + 1, false);
  int ans = 0;
  for (int i = n - 2; i >= 0; i--) {
    if (st[p[i]].find(p[n - 1]) != st[p[i]].end()) {
      int cnt = 0;
      for (auto j : st[p[i]]) {
        if (flag[j]) cnt++;
      }
      if (cnt == ((int)(s).size()))
        ans++;
      else {
        flag[p[i]] = true;
        s.insert(p[i]);
      }
    } else {
      flag[p[i]] = true;
      s.insert(p[i]);
    }
  }
  cout << ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  solve();
}
