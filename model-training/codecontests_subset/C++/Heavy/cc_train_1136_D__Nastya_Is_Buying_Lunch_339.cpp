#include <bits/stdc++.h>
using namespace std;
mt19937 rng32(chrono::steady_clock::now().time_since_epoch().count());
int n, m;
vector<int> ar;
vector<int> gr[300005];
int unab[300005];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n >> m;
  ar.resize(n);
  for (int i = 0; i < n; i++) cin >> ar[i];
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    gr[u].push_back(v);
  }
  int ans = 0;
  unab[ar[n - 1]] = 1;
  for (int i = n - 2; i >= 0; i--) {
    int cnt = 0;
    for (int j = 0; j < (int)(gr[ar[i]].size()); j++) {
      if (unab[gr[ar[i]][j]] == 1) cnt++;
    }
    if (cnt + ans == n - 1 - i)
      ans++;
    else
      unab[ar[i]] = 1;
  }
  cout << ans << endl;
  return 0;
}
