#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9 + 123;
const long long INF = 1e18 + 123;
const double pi = acos(-1.0);
const long double eps = 1e-9;
int n, a[300000], mx = -1, sum;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i], sum += a[i], mx = max(mx, a[i]);
  while (1) {
    if (sum < mx * n - sum) cout << mx, exit(0);
    mx++;
  }
}
