#include <bits/stdc++.h>
using namespace std;
pair<int, int> a[100005];
int main() {
  int n, ans = 2, g = -1;
  cin >> n;
  if (n < 3) {
    cout << n;
    return 0;
  }
  for (int i = 0; i < n; i++) {
    cin >> a[i].first >> a[i].second;
  }
  for (int i = 1; i < n - 1; i++) {
    if (a[i].first - a[i].second > a[i - 1].first && g != i) {
      ans++;
      g = i;
    } else if (a[i].first + a[i].second < a[i + 1].first && g != i) {
      ans++;
      a[i].first += a[i].second;
      g = i;
    }
  }
  cout << ans;
  return 0;
}
