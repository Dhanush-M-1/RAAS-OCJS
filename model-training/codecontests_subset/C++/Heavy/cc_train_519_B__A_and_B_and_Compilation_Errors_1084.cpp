#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, x = 0, m = 0, j = 0, i, a[100005], b[100005], c[100005],
                   d[100005];
  scanf("%lld", &n);
  for (i = 0; i < n; i++) {
    scanf("%lld", &a[i]);
  }
  for (i = 0; i < n - 1; i++) {
    scanf("%lld", &b[i]);
  }
  for (i = 0; i < n - 2; i++) {
    scanf("%lld", &c[i]);
  }
  sort(a, a + n);
  sort(b, b + n - 1);
  sort(c, c + n - 2);
  for (i = 0; i < n; i++) {
    if (b[j] != a[i]) {
      printf("%d\n", a[i]);
      break;
    }
    j++;
  }
  j = 0;
  for (i = 0; i < n - 1; i++) {
    if (c[j] != b[i]) {
      printf("%d\n", b[i]);
      break;
    }
    j++;
  }
}
