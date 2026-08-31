#include <bits/stdc++.h>
using namespace std;
const int N = 100009;
int x, y, n, m, i, u, w, z, sum, best, j, k, t, ans;
int a[N], d[N];
int main() {
  cin >> n >> x;
  k = n;
  while (n >= x) {
    ans += n / x;
    n = n / x + (n % x);
  }
  ans += k;
  cout << ans;
  return 0;
}
