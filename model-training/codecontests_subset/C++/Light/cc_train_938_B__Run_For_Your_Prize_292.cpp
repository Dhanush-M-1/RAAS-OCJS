#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n;
  cin >> n;
  long long int a[n], i, ans = 0;
  for (i = 0; i < n; ++i) cin >> a[i];
  for (i = 0; i < n; ++i)
    if (a[i] <= 5 * 100000)
      ans = max(ans, a[i] - 1);
    else
      ans = max(ans, 1000000 - a[i]);
  cout << ans;
  return 0;
}
