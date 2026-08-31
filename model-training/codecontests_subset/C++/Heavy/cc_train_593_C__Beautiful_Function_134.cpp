#include <bits/stdc++.h>
using namespace std;
const int Mx = 5e5 + 5;
int x[Mx], y[Mx], z[Mx];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d%d%d", x + i, y + i, z + i);
  for (int i = 1; i < n; i++) putchar('(');
  for (int i = 1; i <= n; i++) {
    if (i > 1) putchar('+');
    putchar('(');
    printf("%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[i] / 2, i - 1,
           i - 1);
    if (i > 1) putchar(')');
  }
  puts("");
  for (int i = 1; i < n; i++) printf("(");
  for (int i = 1; i <= n; i++) {
    if (i > 1) putchar('+');
    putchar('(');
    printf("%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", y[i] / 2, i - 1,
           i - 1);
    if (i > 1) putchar(')');
  }
  return 0;
}
