#include <bits/stdc++.h>
using namespace std;
const int maxn = 100;
int n, x[maxn], y[maxn], r;
void write(int x) {
  if (x <= 50)
    printf("%d", x);
  else {
    printf("(50+");
    write(x - 50);
    printf(")");
  }
}
void work() {
  for (int i = 1; i < n; i++) printf("(");
  for (int i = 1; i <= n; i++) {
    if (i > 1) printf("+");
    printf("(");
    write(x[i]);
    printf("*((1-abs((t-");
    write(i - 1);
    printf(")))+abs((abs((t-");
    write(i - 1);
    printf("))-1))))");
    if (i > 1) printf(")");
  }
  printf("\n");
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d%d%d", x + i, y + i, &r);
    x[i] /= 2;
    y[i] /= 2;
  }
  work();
  memcpy(x, y, sizeof(y));
  work();
  return 0;
}
