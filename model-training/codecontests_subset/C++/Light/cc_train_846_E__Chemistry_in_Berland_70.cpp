#include <bits/stdc++.h>
using namespace std;
vector<pair<long double, long double> > adj[1000005];
static long long a[1000005], b[1000005];
pair<long double, long double> dfs(int cur) {
  pair<long double, long double> now = make_pair(0ll, 0ll);
  if (a[cur] > b[cur]) {
    now.first += (a[cur] - b[cur]);
  } else {
    now.second += (b[cur] - a[cur]);
  }
  for (int i = 0; i < adj[cur].size(); i++) {
    pair<long double, long double> tmp = dfs(adj[cur][i].first);
    tmp.second *= (adj[cur][i].second);
    now.first += tmp.first;
    now.second += tmp.second;
    assert(tmp.first == 0ll || tmp.second == 0ll);
  }
  long double x = min(now.first, now.second);
  now.second -= x;
  now.first -= x;
  return now;
}
int main() {
  if (0) {
    freopen("C:/Users/gold/Desktop/sublime IO/input.txt", "r", stdin);
    freopen("C:/Users/gold/Desktop/sublime IO/output.txt", "w", stdout);
  }
  int T = 1;
  while (T--) {
    int n;
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
      scanf("%lld", &a[i]);
    }
    for (int i = 1; i <= n; i++) {
      scanf("%lld", &b[i]);
    }
    for (int i = 0; i < n - 1; i++) {
      long long x, k;
      scanf("%lld %lld", &x, &k);
      adj[x].push_back(make_pair(i + 2.0, k * 1.0));
    }
    pair<long double, long double> ans = dfs(1);
    if (ans.second == 0ll) {
      puts("YES");
    } else {
      puts("NO");
    }
  }
  return 0;
}
