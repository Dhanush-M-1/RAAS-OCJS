#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<pair<int, int>> v(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i].first;
    v[i].second = i + 1;
    v[i].first *= -1;
  }
  sort(v.begin(), v.end());
  int t;
  cin >> t;
  for (; t; t--) {
    int x, y;
    cin >> x >> y;
    vector<pair<int, int>> z;
    for (int i = 0; i < x; i++) {
      z.push_back({v[i].second, v[i].first});
    }
    sort(z.begin(), z.end());
    cout << -z[y - 1].second << "\n";
  }
}
