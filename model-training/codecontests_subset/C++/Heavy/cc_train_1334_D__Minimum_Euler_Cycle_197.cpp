#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n;
  cin >> n;
  long long l, r;
  cin >> l >> r;
  if (l == r && l == (n * (n - 1) + 1)) {
    cout << 1 << '\n';
    return;
  }
  long long grp = n - 1;
  long long sum = 0;
  long long idx = 1;
  long long extra = 0;
  for (long long i = 1; i <= n - 1; i++) {
    sum += (grp * 2);
    if (sum >= l) {
      idx = i;
      sum -= (grp * 2);
      break;
    }
    grp--;
  }
  long long rem = l - sum;
  long long x = idx;
  long long y = idx + (rem + 1) / 2;
  for (long long i = l; i <= r; i++) {
    if (i == (n * (n - 1) + 1)) {
      cout << 1 << ' ';
    } else {
      if (i % 2) {
        cout << x << ' ';
      } else {
        cout << y << ' ';
        y++;
        if (y == n + 1) {
          x++;
          y = 1 + x;
        }
      }
    }
  }
  cout << '\n';
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  int t = 1;
  cin >> t;
  for (int i = 1; i <= t; i++) {
    solve();
  }
  return 0;
}
