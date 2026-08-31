#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  long long n, q, m, t, r, k, i, j, x, b1, b2, s1, s2,
      last = 0, y, z, p, v, val = 0, minans = LLONG_MAX, a, b, c, d, flag = 0,
      u;
  cin >> n >> k;
  vector<long long> arr(n);
  for (i = 0; i < n; i++) cin >> arr[i];
  for (i = 0; i < n; i++) {
    if (k % arr[i] == 0) {
      minans = min(minans, k / arr[i]);
    }
  }
  cout << minans;
  return 0;
}
