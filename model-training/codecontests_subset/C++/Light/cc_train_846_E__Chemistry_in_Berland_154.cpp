#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 7;
const long long inf = (long long)1e18;
long long a[N], b[N];
vector<pair<long long, long long> > g[N];
bool pos;
void dfs(int s) {
  for (auto nd : g[s]) {
    dfs(nd.first);
    if (a[nd.first] <= b[nd.first])
      b[s] = (b[s] + b[nd.first] - a[nd.first]);
    else {
      if (1.0 * nd.second * (a[nd.first] - b[nd.first]) + 1.0 * a[s] > 1e18)
        pos = false;
      a[s] = (a[s] + nd.second * (a[nd.first] - b[nd.first]));
    }
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cout.precision(15);
  cout.setf(ios::fixed);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) cin >> b[i];
  for (int i = 0; i < n; i++) cin >> a[i];
  long long x, k;
  for (int i = 1; i < n; i++) {
    cin >> x >> k;
    x--;
    g[x].push_back({i, k});
  }
  pos = true;
  dfs(0);
  if (a[0] > b[0]) pos = false;
  if (pos)
    cout << "YES" << '\n';
  else
    cout << "NO" << '\n';
}
