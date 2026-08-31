#include <bits/stdc++.h>
using namespace std;
int a[100005];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i]);
  a[0] = 1, a[n + 1] = 1000000;
  int ans = 1e9;
  for (int i = 0; i <= n; ++i) {
    ans = min(ans, max(1000000 - a[i + 1], a[i] - 1));
  }
  ans = min(ans, 1000000 - a[1]);
  ans = min(ans, a[n] - 1);
  cout << ans << endl;
  return 0;
}
