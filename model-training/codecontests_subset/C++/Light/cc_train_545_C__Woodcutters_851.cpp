#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, h;
  cin >> n;
  vector<pair<int, int>> v;
  for (int i = 0; i < n; i++) {
    cin >> x >> h;
    v.push_back({x, h});
  }
  if (n < 3) {
    cout << n;
    return 0;
  }
  int ans = 2;
  int prevx = v[0].first;
  for (int i = 1; i < n - 1; i++) {
    x = v[i].first;
    h = v[i].second;
    if (x - h > prevx) {
      ans++;
      prevx = x;
    } else if (x + h < v[i + 1].first) {
      ans++;
      prevx = x + h;
    } else {
      prevx = x;
    }
  }
  cout << ans;
}
