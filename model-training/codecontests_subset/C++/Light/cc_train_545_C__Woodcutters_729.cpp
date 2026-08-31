#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 5;
int n, x, y, ans = 2;
pair<int, int> a[maxn];
int main() {
  cin >> n;
  if (n == 1) {
    return cout << 1, 0;
  }
  for (int i = 0; i < n; i++) {
    cin >> x >> y;
    a[i] = make_pair(x, y);
  }
  for (int i = 1; i < n - 1; i++) {
    if (a[i].first - a[i - 1].first > a[i].second) {
      ans++;
    } else {
      if (a[i + 1].first - a[i].first > a[i].second) {
        ans++;
        a[i].first += a[i].second;
      }
    }
  }
  cout << ans;
  return 0;
}
