#include <bits/stdc++.h>
const int magicconst = 73743071;
using namespace std;
long long a[2], x, y, b[2];
bool check(long long u, long long v) {
  long long det = x * x + y * y;
  long long q = x * v - u * y;
  long long w = u * x + y * v;
  return (q % det == 0 && w % det == 0);
}
int main() {
  scanf("%I64d%I64d%I64d%I64d%I64d%I64d", &a[0], &a[1], &b[0], &b[1], &x, &y);
  if (x == 0 && y == 0) {
    bool ans = 0;
    if (b[0] == a[0] && b[1] == a[1]) ans = 1;
    if (b[0] == -a[0] && b[1] == -a[1]) ans = 1;
    if (b[0] == a[1] && b[1] == -a[0]) ans = 1;
    if (b[0] == -a[1] && b[1] == a[0]) ans = 1;
    if (ans)
      printf("YES");
    else
      printf("NO");
  } else {
    bool ans = 0;
    if (check(b[0] - a[0], b[1] - a[1])) ans = 1;
    if (check(b[0] + a[0], b[1] + a[1])) ans = 1;
    if (check(b[0] - a[1], b[1] + a[0])) ans = 1;
    if (check(b[0] + a[1], b[1] - a[0])) ans = 1;
    if (ans)
      printf("YES");
    else
      printf("NO");
  }
  return 0;
}
