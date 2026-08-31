#include <bits/stdc++.h>
using namespace std;
long long n, l, ans = 0, a[100005], r[100005];
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) cin >> a[i] >> r[i];
  a[n] = 1e18;
  l = -1e18;
  for (int i = 0; i < n; i++) {
    if (a[i] - r[i] > l) {
      ans++;
      l = a[i];
      continue;
    } else if (a[i] + r[i] < a[i + 1]) {
      ans++;
      l = a[i] + r[i];
      continue;
    } else
      l = a[i];
  }
  cout << ans;
  return 0;
}
