#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[10000], b, tcase = 1, t, n, i, c, ans = 0;
  scanf("%d %d", &n, &c);
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  for (i = 0; i < n - 1; i++) {
    if (a[i] - a[i + 1] - c > ans) {
      ans = a[i] - a[i + 1] - c;
    }
  }
  printf("%d\n", ans);
  return 0;
}
