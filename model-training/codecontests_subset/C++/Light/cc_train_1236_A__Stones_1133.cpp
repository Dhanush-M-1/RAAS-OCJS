#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
void solve() {
  long long a, b, c;
  cin >> a >> b >> c;
  long long x = min(2 * b, c);
  long long ans = 0;
  if (x == c) {
    long long y = c / 2;
    b = b - y;
    ans += 3 * y;
  } else {
    ans = ans + 3 * b;
    b = 0;
  }
  if (b > 0) {
    long long z = min(2 * a, b);
    if (z == b) {
      long long p = b / 2;
      ans = ans + 3 * p;
    } else {
      ans = ans + 3 * a;
      a = 0;
    }
  }
  cout << ans << endl;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
}
