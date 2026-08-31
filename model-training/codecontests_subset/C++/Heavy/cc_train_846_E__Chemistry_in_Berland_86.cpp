#include <bits/stdc++.h>
using namespace std;
const int mxn = 1e5 + 5;
const long long inf = 2e17;
const double INF = 2e17;
long long a[mxn], b[mxn];
vector<pair<int, int> > adj[mxn];
long long val[mxn] = {};
void dfs(int cur) {
  val[cur] = a[cur];
  for (pair<int, int> x : adj[cur]) {
    int u = x.first;
    long long k = x.second;
    dfs(u);
    if (val[u] > 0)
      val[cur] += val[u];
    else {
      if (val[u] < -inf || (-val[u]) > INF / k) {
        cout << "NO" << endl;
        exit(0);
      }
      val[cur] += k * val[u];
      val[cur] = max(val[cur], -inf);
    }
  }
}
int main() {
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> b[i];
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    a[i] = b[i] - a[i];
  }
  for (int i = 2; i <= n; i++) {
    int x;
    long long k;
    scanf("%d %lld", &x, &k);
    adj[x].push_back({i, k});
  }
  dfs(1);
  if (val[1] >= 0)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
}
