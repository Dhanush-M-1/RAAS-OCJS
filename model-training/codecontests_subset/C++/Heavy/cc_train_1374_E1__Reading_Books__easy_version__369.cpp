#include <bits/stdc++.h>
using namespace std;
#pragma GCC target("sse4.2")
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n, k;
  cin >> n >> k;
  vector<long long int> v[4];
  vector<long long int> pref[4];
  for (long long int i = 0; i < (long long int)n; i++) {
    long long int t, a, b;
    cin >> t >> a >> b;
    v[2 * a + b].push_back(t);
  }
  for (long long int i = 0; i < (long long int)4; i++) {
    sort(v[i].begin(), v[i].end());
    pref[i].push_back(0ll);
    for (long long int j = 0; j < (long long int)v[i].size(); j++)
      pref[i].push_back(pref[i].back() + v[i][j]);
  }
  long long int ans = INT_MAX;
  for (long long int i = 0; i < min(k + 1, (long long int)pref[3].size());
       i++) {
    if (k - i < pref[1].size() && k - i < pref[2].size()) {
      ans = min(ans, pref[3][i] + pref[1][k - i] + pref[2][k - i]);
    }
  }
  if (ans == INT_MAX)
    cout << "-1\n";
  else
    cout << ans << "\n";
  return 0;
}
