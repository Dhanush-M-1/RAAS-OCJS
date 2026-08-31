#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  int n;
  cin >> n;
  vector<long long> a(n);
  for (auto &i : a) cin >> i;
  long long ans = 1000000000000;
  for (int i = 0; i <= n; ++i) {
    long long t;
    if (i == 0)
      t = 1000000 - a[0];
    else if (i == n)
      t = a.back() - 1;
    else
      t = max(a[i - 1] - 1, 1000000 - a[i]);
    ans = min(ans, t);
  }
  cout << ans;
  return 0;
}
