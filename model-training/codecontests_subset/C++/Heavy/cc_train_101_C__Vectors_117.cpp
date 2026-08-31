#include <bits/stdc++.h>
using namespace std;
long long a1, a2, b1, b2, c1, c2;
void rec(long long p, long long q) {
  long long mod = c1 * c1 + c2 * c2;
  if ((p * c1 + q * c2) % mod == 0 && (q * c1 - p * c2) % mod == 0) {
    puts("YES");
    exit(0);
  }
}
int main() {
  scanf("%I64d%I64d%I64d%I64d%I64d%I64d", &a1, &a2, &b1, &b2, &c1, &c2);
  if (c1 == 0 && c2 == 0) {
    if ((a1 == b1 && a2 == b2) || (a1 == -b1 && a2 == -b2) ||
        (a1 == b2 && a2 == -b1) || (a1 == -b2 && a2 == b1))
      puts("YES");
    else
      puts("NO");
    return 0;
  }
  rec(b1 - a1, b2 - a2);
  rec(b1 + a1, b2 + a2);
  rec(b1 + a2, b2 - a1);
  rec(b1 - a2, b2 + a1);
  puts("NO");
  return 0;
}
