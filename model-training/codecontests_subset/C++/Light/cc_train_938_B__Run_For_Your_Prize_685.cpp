#include <bits/stdc++.h>
int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
int dy[] = {1, -1, 0, 0, -1, 1, 1, -1};
using namespace std;
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  int n;
  cin >> n;
  int a[n];
  for (int i = 0; i < n; ++i) cin >> a[i];
  int ans = abs((int)1e6 - a[0]);
  for (int i = 0; i + 1 < n; ++i) {
    int cur = max(abs(a[i] - 1), abs((int)1e6 - a[i + 1]));
    ans = min(cur, ans);
  }
  ans = min(ans, a[n - 1] - 1);
  cout << ans << '\n';
}
