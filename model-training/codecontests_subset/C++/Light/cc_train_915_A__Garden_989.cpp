#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, k;
  int a[105];
  scanf("%d%d", &n, &k);
  int ans = 100;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    if (k % a[i] == 0) ans = min(ans, k / a[i]);
  }
  cout << ans << endl;
  return 0;
}
