#include <bits/stdc++.h>
const bool DEBUG = false;
using namespace std;
const long long maxn = 3e5 + 5 + 1;
const long long INF = 4e18;
const long long M = 1e9 + 7;
const int lg = 21;
#pragma GCC Optimize("Ofast")
int n, a[maxn], mi = 1e6, ma;
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (a[i] > 1e6 / 2)
      mi = min(mi, a[i]);
    else
      ma = max(ma, a[i]);
  }
  cout << max(ma - 1, 1000000 - mi);
  return 0;
}
