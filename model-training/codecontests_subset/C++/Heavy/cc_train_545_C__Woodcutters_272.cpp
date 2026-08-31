#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<pair<int, int>> vec(n);
  for (auto& p : vec) cin >> p.first >> p.second;
  vector<bool> fell(n, false);
  fell[0] = true;
  int ans = 1;
  for (int i = 1; i < n; i++) {
    if (fell[i - 1] == true) {
      if (vec[i].first - vec[i].second > vec[i - 1].first) {
        ans++;
        fell[i] = true;
      } else if ((i == n - 1) ||
                 vec[i + 1].first > vec[i].first + vec[i].second)
        ans++;
      else
        fell[i] = true;
    } else {
      if (vec[i].first - vec[i].second > vec[i - 1].first + vec[i - 1].second) {
        ans++;
        fell[i] = true;
      } else if ((i == n - 1) ||
                 vec[i + 1].first > vec[i].first + vec[i].second)
        ans++;
      else
        fell[i] = true;
    }
  }
  cout << ans << '\n';
  return 0;
}
