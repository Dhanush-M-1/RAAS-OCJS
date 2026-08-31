#include <bits/stdc++.h>
using namespace std;
long long a[50005];
int main() {
  int i, t, n;
  scanf("%d", &t);
  while (t--) {
    scanf("%d", &n);
    for (i = 0; i < n; i++) {
      scanf("%lld", &a[i]);
    }
    if (a[0] + a[1] <= a[n - 1]) {
      printf("1 2 %d\n", n);
    } else {
      printf("-1\n");
    }
  }
  return 0;
}
