#include <bits/stdc++.h>
const int MAXN = (int)1e6 + 123;
const double eps = 1e-6;
const long long INF = 1000000000000000000ll;
using namespace std;
int n, c, a[200];
int main() {
  cin >> n >> c;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  int ans = 0;
  for (int i = 1; i < n; i++) {
    int cur = a[i];
    if (cur >= a[i + 1]) {
      cur -= a[i + 1];
      if (cur >= c) {
        cur -= c;
        ans = max(ans, cur);
      }
    }
  }
  cout << ans;
  return 0;
}
