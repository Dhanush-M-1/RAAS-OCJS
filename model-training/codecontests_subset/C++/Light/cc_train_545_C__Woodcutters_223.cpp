#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<int, int>> v;
  int x, y;
  int i, j;
  for (i = 0; i < n; i++) {
    cin >> x >> y;
    v.push_back(make_pair(x, y));
  }
  sort(v.begin(), v.end());
  int ans = 1;
  for (i = 1; i < n - 1; i++) {
    if (v[i].first - v[i].second > v[i - 1].first)
      ans++;
    else if (v[i].first + v[i].second < v[i + 1].first) {
      ans++;
      v[i].first = v[i].first + v[i].second;
    }
  }
  if (n > 1) ans++;
  cout << ans << endl;
  return 0;
}
