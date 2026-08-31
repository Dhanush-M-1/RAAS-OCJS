#include <bits/stdc++.h>
using namespace std;
int n, m;
vector<int> a, was;
vector<vector<int> > g;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  a.resize(n);
  g.resize(n);
  was.resize(n);
  for (int i = 0; i < n; i++) cin >> a[i], a[i]--;
  for (int i = 0; i < m; i++) {
    int w1, w2;
    cin >> w1 >> w2;
    w1--;
    w2--;
    g[w1].push_back(w2);
  }
  reverse(a.begin(), a.end());
  int ans = 0;
  for (int i = 0; i < n; i++) was[i] = 0;
  was[a[0]] = 1;
  int cnt = 1;
  for (int i = 1; i < n; i++) {
    int cnt2 = 0;
    for (int to : g[a[i]]) {
      if (was[to]) cnt2++;
    }
    if (cnt == cnt2) {
      ans++;
    } else {
      was[a[i]] = 1;
      cnt++;
    }
  }
  cout << ans;
}
