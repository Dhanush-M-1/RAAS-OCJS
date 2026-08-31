#include <bits/stdc++.h>
using namespace std;
long long a1, a2, b1, b2, c1, c2;
long long flag = 0;
long long check(long long x, long long y) {
  x -= b1, y -= b2;
  long long dis = c1 * c1 + c2 * c2;
  if (!dis) return !x && !y;
  return !((c1 * x + c2 * y) % dis) && !((c1 * y - c2 * x) % dis);
}
signed main() {
  cin >> a1 >> a2 >> b1 >> b2 >> c1 >> c2;
  flag |= check(a1, a2);
  flag |= check(-a1, -a2);
  flag |= check(a2, -a1);
  flag |= check(-a2, a1);
  if (flag)
    printf("YES");
  else
    printf("NO");
  return 0;
}
