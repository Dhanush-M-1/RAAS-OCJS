#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pii = pair<int, int>;
using vi = vector<int>;
const int MN = 1e5 + 5;
int a[MN], ed[MN];
void die() {
  cout << -1 << '\n';
  exit(0);
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  int n, d;
  cin >> n >> d;
  for (int i = 1; i <= n; i++) cin >> a[i];
  int cur = 0, mx = 0, ans = 0;
  for (int i = 1; i <= n; i++) {
    if (a[i] == 0) {
      if (cur + mx < 0) {
        ans++, cur = 0, mx = d;
      } else if (cur < 0) {
        mx += cur;
        cur = 0;
      }
    } else {
      cur += a[i];
      if (cur > d) die();
      mx = min(mx, d - cur);
    }
  }
  cout << ans << '\n';
  return 0;
}
