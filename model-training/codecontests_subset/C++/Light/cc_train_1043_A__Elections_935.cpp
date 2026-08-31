#include <bits/stdc++.h>
using namespace std;
int a[150], n;
int main() {
  int ans = 0, s = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    ans = max(ans, a[i]);
    s += a[i];
  }
  for (; ans * n - s <= s; ans++)
    ;
  cout << ans;
  return 0;
}
