#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  if (n <= 2) {
    cout << n;
    return 0;
  }
  int x[n + 10], h[n + 10];
  for (int i = 1; i <= n; ++i) cin >> x[i] >> h[i];
  int ans = 2;
  int i = 2;
  while (i < n) {
    if (x[i] - h[i] > x[i - 1])
      ++ans;
    else if (x[i] + h[i] < x[i + 1]) {
      x[i] += h[i];
      ++ans;
    }
    ++i;
  }
  cout << ans;
  return 0;
}
