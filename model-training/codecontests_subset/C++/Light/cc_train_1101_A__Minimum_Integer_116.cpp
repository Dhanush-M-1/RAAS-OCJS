#include <bits/stdc++.h>
using namespace std;
int a[1000100];
int c[1000010];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    int l, r, d;
    scanf("%d%d%d", &l, &r, &d);
    if (d < l) {
      printf("%d\n", d);
    } else {
      long long x2 = r / d;
      while (x2 * d <= r) {
        x2++;
      }
      printf("%lld\n", x2 * d);
    }
  }
}
