#include <bits/stdc++.h>
using namespace std;
const long long mxn = 100010;
void solve(long long tc) {
  long long n, k, x, y, z;
  cin >> n >> k;
  deque<long long> d00, d01, d10, d11;
  for (long long i = 0; i < n; i++) {
    cin >> x >> y >> z;
    if (y == 0 && z == 0)
      d00.push_back(x);
    else if (y == 0 && z == 1)
      d01.push_back(x);
    else if (y == 1 && z == 0)
      d10.push_back(x);
    else
      d11.push_back(x);
  }
  sort(d00.begin(), d00.end());
  sort(d01.begin(), d01.end());
  sort(d10.begin(), d10.end());
  sort(d11.begin(), d11.end());
  long long ans = 0;
  while (k--) {
    if (!d01.empty() && !d10.empty()) {
      if (!d11.empty()) {
        if (d01.front() + d10.front() <= d11.front()) {
          ans += d01.front() + d10.front();
          d01.pop_front();
          d10.pop_front();
        } else {
          ans += d11.front();
          d11.pop_front();
        }
      } else {
        ans += d01.front() + d10.front();
        d01.pop_front();
        d10.pop_front();
      }
    } else if (!d11.empty()) {
      ans += d11.front();
      d11.pop_front();
    } else {
      cout << -1 << '\n';
      return;
    }
  }
  cout << ans << '\n';
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  solve(1);
  return 0;
}
