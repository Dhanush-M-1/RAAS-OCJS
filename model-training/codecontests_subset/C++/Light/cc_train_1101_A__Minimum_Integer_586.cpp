#include <bits/stdc++.h>
using namespace std;
const int maxn = 100000;
int main() {
  int n;
  scanf("%d", &n);
  long long l, r, d;
  for (int i = 1; i <= n; i++) {
    cin >> l >> r >> d;
    if (d < l)
      printf("%I64d\n", d);
    else if (r / d * d > r)
      printf("%I64d\n", r / d * d);
    else
      printf("%I64d\n", (r / d + 1) * d);
  }
  return 0;
}
