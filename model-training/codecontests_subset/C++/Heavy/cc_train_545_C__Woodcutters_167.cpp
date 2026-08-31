#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n;
  cin >> n;
  int x[n], h[n];
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  vector<pair<unsigned long long int, unsigned long long int>> range(n);
  range[0].first = INT_MAX;
  range[n - 1].second = INT_MAX;
  for (int i = 0; i < n - 1; i++) {
    range[i].second = x[i + 1] - x[i];
    range[i + 1].first = range[i].second;
  }
  int ans = min(2, n);
  for (int i = 1; i < n - 1; i++) {
    if (range[i].first > h[i]) {
      ++ans;
    } else if (range[i].second > h[i]) {
      range[i].second -= h[i];
      range[i + 1].first = range[i].second;
      ++ans;
    }
  }
  cout << ans;
  return 0;
}
