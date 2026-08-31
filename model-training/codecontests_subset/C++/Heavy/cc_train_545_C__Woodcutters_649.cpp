#include <bits/stdc++.h>
using namespace std;
struct T {
  long long int a, b;
} ar[1000000];
int main() {
  long long int i, j, k, l, t, cs = 1, r = 1, s, m, n, a, b, c, d, e, f, g, h,
                               u, v;
  scanf("%I64d", &n);
  for (i = 0; i < n; i++) {
    scanf("%I64d %I64d", &ar[i].a, &ar[i].b);
  }
  long long int ans = 0;
  a = -100000000000000;
  ar[n].a = 1000000000000000000;
  for (i = 0; i < n; i++) {
    if (a < ar[i].a - ar[i].b) {
      ans++;
      a = ar[i].a;
    } else if (ar[i].a + ar[i].b < ar[i + 1].a) {
      ans++;
      a = ar[i].a + ar[i].b;
    }
    a = max(a, ar[i].a);
  }
  printf("%I64d\n", ans);
  return 0;
}
