#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, m, i, j, x, u, v;
  cin >> n >> m;
  long long a[n + 1];
  vector<long long> adj[n + 1];
  for (i = 1; i <= n; i++) cin >> a[i];
  for (i = 0; i < m; i++) {
    cin >> u >> v;
    adj[u].push_back(v);
  }
  map<long long, long long> mp;
  mp[a[n]] = 1;
  long long left = 1, ans = 0;
  for (i = n - 1; i > 0; i--) {
    long long cnt = 0;
    for (auto j : adj[a[i]]) {
      cnt += mp[j];
    }
    if (cnt == left)
      ans++;
    else {
      left++;
      mp[a[i]] = 1;
    }
  }
  cout << ans;
}
