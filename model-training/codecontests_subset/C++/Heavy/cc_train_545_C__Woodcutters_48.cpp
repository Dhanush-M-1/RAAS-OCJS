#include <bits/stdc++.h>
using namespace std;
const long long dx[] = {1, 0, -1, 0};
const long long dy[] = {0, 1, 0, -1};
int ans;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  vector<pair<long long, long long> > v;
  for (int i = 0; i < n; i++) {
    long long temp1, temp2;
    cin >> temp1 >> temp2;
    v.push_back({temp1, temp2});
  }
  if (n == 1) {
    cout << 1;
    return 0;
  }
  ans = 2;
  for (int i = 1; i < n - 1; i++) {
    if (v[i].first - v[i].second > v[i - 1].first) {
      ans++;
    } else if (v[i].first + v[i].second < v[i + 1].first) {
      ans++;
      v[i].first = v[i].first + v[i].second;
    }
  }
  cout << ans;
  return 0;
}
