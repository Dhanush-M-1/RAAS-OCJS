#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<int, int>> color(n);
  vector<int> h(101, 0), g(101, 0);
  for (int i = 0; i < n; ++i) {
    cin >> color[i].first >> color[i].second;
    ++h[color[i].first];
    ++g[color[i].second];
  }
  int ans = 0;
  for (int i = 1; i < 101; ++i) {
    ans += (h[i] * g[i]);
  }
  cout << ans << endl;
  return 0;
}
