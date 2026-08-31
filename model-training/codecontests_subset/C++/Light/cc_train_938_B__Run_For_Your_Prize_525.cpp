#include <bits/stdc++.h>
using namespace std;
int m = (1000000 + 1 >> 1), n, a[100005], ans;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    if (a[i] <= m)
      ans = max(ans, a[i] - 1);
    else
      ans = max(ans, 1000000 - a[i]);
  }
  printf("%d", ans);
  return 0;
}
