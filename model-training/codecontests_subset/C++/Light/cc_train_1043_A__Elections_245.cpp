#include <bits/stdc++.h>
using namespace std;
const int N = 1005;
int n, mx, sm, a[N];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", a + i);
    sm += a[i];
    mx = max(mx, a[i]);
  }
  int l = mx, r = 2 * mx + 1, mid;
  while (l < r) {
    mid = (l + r) / 2;
    if (mid * n > 2 * sm)
      r = mid;
    else
      l = mid + 1;
  }
  printf("%d\n", l);
  return 0;
}
