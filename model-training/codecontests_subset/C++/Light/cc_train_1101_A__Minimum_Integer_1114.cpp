#include <bits/stdc++.h>
using namespace std;
long long l, r, d, q;
int main() {
  scanf("%lld", &q);
  for (int i = 1; i <= q; i++) {
    scanf("%lld%lld%lld", &l, &r, &d);
    if (d < l)
      printf("%lld\n", d);
    else {
      printf("%lld\n", (r / d + 1) * d);
    }
  }
  return 0;
}
