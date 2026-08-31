#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int t = 1;
  while (t--) {
    int n;
    cin >> n;
    vector<pair<int, int>> v;
    int x, y;
    for (int i = 0; i < n; i++) {
      cin >> x >> y;
      v.push_back({x, y});
    }
    int ans = std::min(n, 2);
    int diff[n];
    for (int i = 1; i < n; i++) {
      diff[i] = v[i].first - v[i - 1].first;
    }
    for (int i = 1; i < n - 1; i++) {
      int height = v[i].second;
      if (height < diff[i]) {
        ans++;
      } else if (height < diff[i + 1]) {
        ans++;
        diff[i + 1] -= height;
      }
    }
    cout << ans << "\n";
  }
  return 0;
}
