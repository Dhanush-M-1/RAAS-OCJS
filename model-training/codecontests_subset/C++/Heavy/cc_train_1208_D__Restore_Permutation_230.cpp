#include <bits/stdc++.h>
using namespace std;
long long n, m, q, x, k, t, y, w = 2, z, a[200500], ans[200500], bit[400500];
long long get(int i) {
  long long ret = 0;
  while (i) ret += bit[i], i -= (i & -i);
  return ret;
}
void update(int i, int val) {
  while (i <= 2 * n) bit[i] += val, i += (i & -i);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin >> n;
  for (int i = 1; i <= n; ++i) cin >> a[i - 1], update(i + 1, i);
  for (int i = n - 1; i >= 0; --i) {
    z = 0;
    for (int j = pow(2, ceil(log2(n))); j > 0; j /= 2)
      if (get(j + z) <= a[i]) z += j;
    update(z + 1, -z);
    ans[i] = z;
  }
  for (int i = 0; i < n; ++i) cout << ans[i] << " ";
}
