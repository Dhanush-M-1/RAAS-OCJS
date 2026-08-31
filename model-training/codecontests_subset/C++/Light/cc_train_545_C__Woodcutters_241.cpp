#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  vector<pair<int, int>> v;
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    v.push_back({x, y});
  }
  int ans = min(2, n);
  int temp = v[0].first;
  for (int i = 1; i < n - 1; i++) {
    if (v[i].first - v[i].second > temp) {
      temp = v[i].first;
      ans++;
    } else if (v[i].first + v[i].second < v[i + 1].first) {
      temp = v[i].first + v[i].second;
      ans++;
    } else {
      temp = v[i].first;
    }
  }
  cout << ans << endl;
}
