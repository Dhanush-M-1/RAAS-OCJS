#include <bits/stdc++.h>
using namespace std;
const int N = 60;
inline int rd() {
  int x = 0, w = 1;
  char ch = 0;
  while (ch < '0' || ch > '9') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + (ch ^ 48);
    ch = getchar();
  }
  return x * w;
}
int n, a[N][2];
int main() {
  n = rd();
  for (int i = 1; i <= n; ++i) a[i][0] = rd() >> 1, a[i][1] = rd() >> 1, rd();
  for (int i = 1; i < n; ++i) putchar('(');
  for (int i = 1; i <= n; ++i) {
    if (i > 1) putchar('+');
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", a[i][0], i - 1,
           i - 1);
    if (i > 1) putchar(')');
  }
  putchar('\n');
  for (int i = 1; i < n; ++i) putchar('(');
  for (int i = 1; i <= n; ++i) {
    if (i > 1) putchar('+');
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", a[i][1], i - 1,
           i - 1);
    if (i > 1) putchar(')');
  }
  putchar('\n');
  return 0;
}
