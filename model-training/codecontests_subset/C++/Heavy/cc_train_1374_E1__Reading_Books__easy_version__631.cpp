#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  int n, k;
  cin >> n >> k;
  vector<int> t(n), a(n), b(n);
  for (int i = 0; i < n; i++) cin >> t[i] >> a[i] >> b[i];
  vector<vector<int>> elements(4);
  for (int i = 0; i < n; i++) elements[2 * a[i] + b[i]].push_back(t[i]);
  for (int i = 0; i < 4; i++) sort(elements[i].begin(), elements[i].end());
  vector<vector<int>> prefix(4);
  for (int i = 0; i < 4; i++) {
    prefix[i].push_back(0);
    for (auto &x : elements[i]) prefix[i].push_back(prefix[i].back() + x);
  }
  int ans = INT_MAX;
  for (int i = 0; i <= min((int)elements[3].size(), k); i++) {
    int req = k - i;
    if (prefix[1].size() <= req || prefix[2].size() <= req) continue;
    int cur = prefix[1][req] + prefix[2][req] + prefix[3][i];
    ans = min(ans, cur);
  }
  ans == INT_MAX ? cout << "-1" << endl : cout << ans << endl;
}
