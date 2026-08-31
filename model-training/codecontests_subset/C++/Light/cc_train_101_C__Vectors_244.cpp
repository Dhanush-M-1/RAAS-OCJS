#include <bits/stdc++.h>
using namespace std;
bool ok(long long int c1, long long int c2, long long int a1,
        long long int a2) {
  long long int d = c1 * c1 + c2 * c2;
  if (d == 0LL) return a1 == 0LL && a2 == 0LL;
  return (a1 * c1 + a2 * c2) % d == 0LL && (a1 * c2 - a2 * c1) % d == 0LL;
}
int main() {
  int a1, a2, b1, b2, c1, c2;
  scanf("%d %d %d %d %d %d", &a1, &a2, &b1, &b2, &c1, &c2);
  if (ok(c1, c2, b1 - a1, b2 - a2) || ok(c1, c2, b1 - a2, b2 + a1) ||
      ok(c1, c2, b1 + a1, b2 + a2) || ok(c1, c2, b1 + a2, b2 - a1))
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
