#include <bits/stdc++.h>
using namespace std;
const int MAXX = 1e5 + 10, inf = 1e6;
int n, a[MAXX], ans;
int main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    (a[i] > inf / 2) ? (a[i] = inf - a[i]) : (a[i] -= 1);
    ans = max(ans, a[i]);
  }
  return cout << ans << endl, 0;
}
