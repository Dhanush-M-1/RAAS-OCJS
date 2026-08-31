#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
const int N = 1e5 + 10;
int t, n, a[N];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(nullptr);
  cin >> t;
  while (t--) {
    cin >> n;
    for (int i = 1; i <= n; ++i) cin >> a[i];
    int x = a[1], y = a[2], z = a[n];
    if (x + y <= z || y + z <= x || z + x <= y) {
      cout << 1 << " " << 2 << " " << n << '\n';
    } else
      cout << "-1" << '\n';
  }
}
