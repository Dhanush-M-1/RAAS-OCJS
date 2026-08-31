#include <bits/stdc++.h>
using namespace std;
long n, i, mx, c, a[200];
int main() {
  while (~scanf("%ld%ld", &n, &c)) {
    for (i = 0; i < n; i++) scanf("%ld", &a[i]);
    mx = 0;
    for (i = 1; i < n; i++) {
      if ((a[i - 1] - a[i]) > mx) mx = a[i - 1] - a[i];
    }
    mx -= c;
    if (mx > 0)
      printf("%ld\n", mx);
    else
      printf("0\n");
  }
  return 0;
}
