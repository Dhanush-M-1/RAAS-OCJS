#include <bits/stdc++.h>
#pragma GCC optimize "trapv"
const int inf1 = 1e9;
const long long int inf2 = 1e18;
const int N = 100000;
using namespace std;
int dirs[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
int solve() {
  long long int n, l, r;
  cin >> n >> l >> r;
  if (l == n * (n - 1) + 1) {
    cout << 1 << "\n";
    return 0;
  }
  long long int bl = 1;
  bool f = false;
  if (r == (n * (n - 1) + 1)) {
    r--;
    f = true;
  }
  long long int lo = 1;
  long long int hi = n - 1;
  while (lo <= hi) {
    long long int m = (lo + hi) / 2;
    long long int ch = 2 * n * m - m * (m + 1);
    if (ch >= l) {
      bl = m;
      hi = m - 1;
    } else
      lo = m + 1;
  }
  long long int val = 2 * n * (bl - 1) - bl * (bl - 1);
  for (long long int i = l; i <= r; i++) {
    if (i % 2 == 0) {
      cout << bl + (i - val) / 2 << " ";
    } else {
      cout << bl << " ";
    }
    if ((2 * n * bl - (bl + 1) * bl) == i) {
      val = i;
      bl++;
    }
  }
  if (f) cout << 1 << " ";
  cout << "\n";
  return 0;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
