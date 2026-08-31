#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  cin >> n;
  vector<pair<int, int>> v(n);
  for (int i = 0; i < n; i++) {
    cin >> v[i].first >> v[i].second;
  }
  if (n == 1) {
    cout << 1 << endl;
    return 0;
  }
  int ans = 2;
  for (int i = 1; i < n - 1; i++) {
    if (v[i].second < v[i].first - v[i - 1].first)
      ans++;
    else if (v[i].second < v[i + 1].first - v[i].first) {
      ans++;
      v[i].first += v[i].second;
    }
  }
  cout << ans << endl;
}
