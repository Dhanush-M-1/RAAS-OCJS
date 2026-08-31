#include <bits/stdc++.h>
using namespace std;
int x[55], y[55];
void print(int* x, int n) {
  for (int i = 1; i < n; i++) putchar('(');
  for (int i = 1; i <= n; i++) {
    if (i != 1) putchar('+');
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[i] / 2, i, i);
    if (i != 1) putchar(')');
  }
  puts("");
}
int main(void) {
  int n, k;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d %d %d", x + i, y + i, &k);
  print(x, n), print(y, n);
  return 0;
}
