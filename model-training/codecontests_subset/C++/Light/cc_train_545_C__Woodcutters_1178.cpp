#include <bits/stdc++.h>
using namespace std;
pair<int, int> x[100005];
int main() {
  int n, ans;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    cin >> x[i].first >> x[i].second;
  }
  sort(x, x + n);
  if (n == 1)
    ans = 1;
  else if (n >= 2)
    ans = 2;
  for (int i = 1; i < n - 1; ++i) {
    if (x[i].second < x[i].first - x[i - 1].first) {
      ans++;
    } else if (x[i].second < x[i + 1].first - x[i].first) {
      ans++;
      x[i].first += x[i].second;
    }
  }
  cout << ans << '\n';
  return 0;
}
