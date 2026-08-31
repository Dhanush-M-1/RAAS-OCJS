#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    long int l, r, d, i, j;
    scanf("%ld %ld %ld", &l, &r, &d);
    if (d < l)
      printf("%ld\n", d);
    else {
      i = r / d;
      printf("%ld\n", (i + 1) * d);
    }
  }
  return 0;
}
