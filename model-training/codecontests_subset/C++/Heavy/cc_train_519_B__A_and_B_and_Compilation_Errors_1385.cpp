#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  scanf("%d", &n);
  int x = n - 1, y = n - 2, i;
  long long int a[n], b[x], c[y];
  for (i = 0; i < n; i++) {
    scanf("%lld", &a[i]);
  }
  for (i = 0; i < x; i++) {
    scanf("%lld", &b[i]);
  }
  for (i = 0; i < y; i++) {
    scanf("%lld", &c[i]);
  }
  sort(a, a + n);
  sort(b, b + x);
  sort(c, c + y);
  long long int j, r1, r2, flag = 0;
  for (i = 0; i < n; i++) {
    flag = 0;
    for (j = i; j < x; j++) {
      if (b[j] == a[i]) {
        flag = 1;
        break;
      }
    }
    if (flag == 0) {
      r1 = a[i];
      break;
    }
  }
  for (i = 0; i < x; i++) {
    flag = 0;
    for (j = i; j < y; j++) {
      if (c[j] == b[i]) {
        flag = 1;
        break;
      }
    }
    if (flag == 0) {
      r2 = b[i];
      break;
    }
  }
  printf("%lld\n%lld", r1, r2);
}
