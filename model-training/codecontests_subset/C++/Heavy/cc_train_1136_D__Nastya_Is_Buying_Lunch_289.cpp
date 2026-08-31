#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, m, s1, s2, i, ans = 0, curr, areInSide;
  cin >> n >> m;
  vector<int> v(n), swaps[n];
  for (i = 0; i < n; i++) {
    cin >> v[i];
    v[i]--;
  }
  for (i = 0; i < m; i++) {
    cin >> s1 >> s2;
    s1--;
    s2--;
    swaps[s1].push_back(s2);
  }
  vector<bool> isReady(n, false);
  isReady[v[n - 1]] = true;
  reverse(v.begin(), v.end());
  areInSide = 1;
  for (i = 1; i < n; i++) {
    curr = 0;
    for (auto it : swaps[v[i]]) {
      if (isReady[it]) curr++;
    }
    if (curr == areInSide) {
      ans++;
    } else {
      areInSide++;
      isReady[v[i]] = true;
    }
  }
  cout << ans;
  return 0;
}
