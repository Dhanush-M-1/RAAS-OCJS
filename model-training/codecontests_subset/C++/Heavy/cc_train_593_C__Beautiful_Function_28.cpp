#include <bits/stdc++.h>
using namespace std;
int x[55], y[55];
int n;
int main() {
  int i, j;
  scanf("%d", &n);
  for (i = 1; i <= n; ++i) scanf("%d%d%*d", x + i, y + i);
  for (i = 1; i < n; ++i) putchar('(');
  printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[1] >> 1, 0, 0);
  for (i = 2; i <= n; ++i) {
    putchar('+');
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1)))))", x[i] >> 1, i, i);
  }
  putchar('\n');
  for (i = 1; i < n; ++i) putchar('(');
  printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", y[1] >> 1, 0, 0);
  for (i = 2; i <= n; ++i) {
    putchar('+');
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1)))))", y[i] >> 1, i, i);
  }
  putchar('\n');
  return 0;
}
