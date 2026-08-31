#include <bits/stdc++.h>
using namespace std;
int a[100010];
int n, d, min1 = 0, max1 = 0, ans = 0;
int main() {
  scanf("%d %d", &n, &d);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  for (int i = 1; i <= n; i++) {
    if (!a[i]) {
      if (min1 < 0) {
        min1 = 0;
      }
      if (max1 < 0) {
        max1 = d;
        ans++;
      }
    } else {
      min1 += a[i];
      max1 += a[i];
      if (min1 > d) {
        printf("-1\n");
        return 0;
      }
      if (max1 > d) {
        max1 = d;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
