#include <bits/stdc++.h>
using namespace std;
int a[110], b[110], ans, i, n, c;
int main() {
  scanf("%d%d", &n, &c);
  for (i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  for (i = 1; i <= n - 1; i++) {
    b[i] = a[i] - a[i + 1];
  }
  for (i = 1; i <= n - 1; i++) {
    ans = max(ans, b[i]);
  }
  ans -= c;
  if (ans < 0) {
    printf("0");
  } else {
    printf("%d", ans);
  }
}
