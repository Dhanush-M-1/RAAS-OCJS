#include <bits/stdc++.h>
int T, l, r, d;
using namespace std;
int main() {
  scanf("%d", &T);
  while (T--) {
    scanf("%d%d%d", &l, &r, &d);
    if (d < l) {
      printf("%d\n", d);
      continue;
    } else {
      int t = (r / d * d);
      if (t <= r) t += d;
      printf("%d\n", t);
    }
  }
  return 0;
}
