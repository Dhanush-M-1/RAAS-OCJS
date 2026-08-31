#include <bits/stdc++.h>
const int N = 2e5 + 5;
using namespace std;
int n, m, k;
int res[N];
int x[N], y[N];
int bac[N];
set<int> a[N];
set<pair<int, int> > S;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> x[i] >> y[i];
    a[x[i]].insert(y[i]);
    a[y[i]].insert(x[i]);
    bac[x[i]]++;
    bac[y[i]]++;
  }
  for (int i = 1; i <= n; i++)
    if (bac[i] > 0) S.insert(make_pair(bac[i], i));
  for (int i = m; i >= 1; i--) {
    while (S.size() && S.begin()->first < k) {
      int cc = S.begin()->first;
      int u = S.begin()->second;
      for (int v : a[u]) {
        S.erase(make_pair(bac[v], v));
        bac[v]--;
        if (bac[v] > 0) S.insert(make_pair(bac[v], v));
        a[v].erase(u);
      }
      a[u].clear();
      bac[u] = 0;
      S.erase(make_pair(cc, u));
    }
    res[i] = S.size();
    if (a[y[i]].find(x[i]) != a[y[i]].end()) {
      S.erase(make_pair(bac[x[i]], x[i]));
      bac[x[i]]--;
      if (bac[x[i]] > 0) S.insert(make_pair(bac[x[i]], x[i]));
      S.erase(make_pair(bac[y[i]], y[i]));
      bac[y[i]]--;
      if (bac[y[i]] > 0) S.insert(make_pair(bac[y[i]], y[i]));
      a[x[i]].erase(y[i]);
      a[y[i]].erase(x[i]);
    }
  }
  for (int i = 1; i <= m; i++) cout << res[i] << '\n';
}
