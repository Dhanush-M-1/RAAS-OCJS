#include <bits/stdc++.h>
using namespace std;
bool check(long long a, long long b, long long c1, long long c2) {
  if (a == 0 && b == 0) {
    if (c1 == c2 && c1 == 0)
      return 1;
    else
      return 0;
  }
  long long tt = a * a + b * b;
  long long t1 = c1 * a + c2 * b;
  long long t2 = a * c2 - b * c1;
  if (t1 % tt == 0 && t2 % tt == 0)
    return 1;
  else
    return 0;
}
int main() {
  long long a1, a2;
  long long b1, b2, c1, c2;
  while (scanf("%I64d %I64d", &a1, &a2) != EOF) {
    scanf("%I64d %I64d", &b1, &b2);
    scanf("%I64d %I64d", &c1, &c2);
    bool flag = 0;
    if (check(c1, c2, b1 - a1, b2 - a2)) flag = 1;
    if (check(c1, c2, b1 + a2, b2 - a1)) flag = 1;
    if (check(c1, c2, b1 + a1, b2 + a2)) flag = 1;
    if (check(c1, c2, b1 - a2, b2 + a1)) flag = 1;
    if (flag)
      puts("YES");
    else
      puts("NO");
  }
  return 0;
}
