#include <bits/stdc++.h>
using namespace std;
bool comp(pair<int, int> p1, pair<int, int> p2) {
  if (p1.first != p2.first)
    return p2.first > p1.first;
  else
    return p2.second < p1.second;
}
void solve() {
  int n, x;
  cin >> n;
  vector<pair<int, int>> v(n);
  for (int i = 0; i < n; i++) {
    cin >> x;
    v[i] = make_pair(x, i);
  }
  sort(v.begin(), v.end(), comp);
  int m;
  cin >> m;
  while (m--) {
    int k, pos;
    cin >> k >> pos;
    pos--;
    vector<pair<int, int>> ans;
    for (int j = 0; j < k; j++) {
      ans.push_back(make_pair(v[n - 1 - j].second, v[n - 1 - j].first));
    }
    sort(ans.begin(), ans.end());
    cout << ans[pos].second << endl;
  }
}
int main() {
  int t = 1;
  while (t--) {
    solve();
  }
}
