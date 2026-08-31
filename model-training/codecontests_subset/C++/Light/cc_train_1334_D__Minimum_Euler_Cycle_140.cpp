#include <bits/stdc++.h>
using namespace std;
long long n, l, r;
void solve(long long l, long long r) {
  long long s = 1;
  while (s <= n && l > 2 * (n - s)) {
    l -= 2 * (n - s);
    r -= 2 * (n - s);
    s++;
  }
  long long cnt = l / 2 + l % 2;
  cnt += s;
  while (s <= n && l <= r) {
    while (cnt <= n) {
      if (l % 2)
        cout << s << " ";
      else
        cout << cnt++ << " ";
      l++;
      if (l > r) break;
    }
    s++;
    cnt = s + 1;
  }
  if (l <= r) cout << 1;
  cout << "\n";
}
signed main() {
  long long t;
  cin >> t;
  while (t--) {
    cin >> n >> l >> r;
    solve(l, r);
  }
  return 0;
}
