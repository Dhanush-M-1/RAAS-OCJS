#include <bits/stdc++.h>
const long long M = 1000;
const long long N = 1020000;
const long long mx = (1e18);
using namespace std;
long long x, y, a[N], n, m, k, l, w, j, i, res, w1, w2;
int main() {
  ios_base::sync_with_stdio(0);
  cin >> n;
  for (i = 1; i <= n; i++) cin >> a[i];
  x = 1;
  y = (1e6);
  w1 = w2 = 0;
  for (i = 1; i <= n; i++) w = max(w, min(abs(x - a[i]), abs(y - a[i])));
  cout << w;
}
