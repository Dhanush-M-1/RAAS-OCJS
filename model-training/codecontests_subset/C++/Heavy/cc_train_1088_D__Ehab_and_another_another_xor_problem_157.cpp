#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9 + 10, MOD = 1e9 + 7;
long long a, b, c, d, comp, dl;
int query(long long c, long long d) {
  printf("? %lld %lld\n", c, d);
  fflush(stdout);
  int ans;
  scanf("%d", &ans);
  if (ans == -2) c /= 0;
  return ans;
}
int main() {
  dl = query(0, 0);
  for (int i = 29; i >= 0; i--) {
    if (dl != 0) {
      if (query(c + (1 << i), d + (1 << i)) == dl) {
        if (query(c + (1 << i), d) == -1) {
          c += (1 << i);
          d += (1 << i);
        }
      } else {
        if (dl == 1) {
          dl = query(c + (1 << i), d);
          c += (1 << i);
        } else {
          dl = query(c, d + (1 << i));
          d += (1 << i);
        }
      }
    } else {
      if (query(c + (1 << i), d) == -1) {
        c += (1 << i);
        d += (1 << i);
      }
    }
  }
  printf("! %lld %lld\n", c, d);
  return 0;
}
