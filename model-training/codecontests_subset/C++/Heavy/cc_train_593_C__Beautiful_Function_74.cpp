#include <bits/stdc++.h>
using namespace std;
int n, i, x[52], y[52], r[52];
int read() {
  char c = getchar();
  int w = 0;
  while (c < '0' || c > '9') c = getchar();
  while (c <= '9' && c >= '0') {
    w = w * 10 + c - '0';
    c = getchar();
  }
  return w;
}
void solve(int *a) {
  for (int i = 1; i < n; i++) printf("(");
  for (int i = 1; i < n; i++) {
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", a[i] / 2, i - 1,
           i - 1);
    if (i != 1) printf(")");
    printf("+");
  }
  printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", a[n] / 2, n - 1, n - 1);
  if (n != 1) printf(")");
  puts("");
}
int main() {
  n = read();
  for (i = 1; i <= n; i++) x[i] = read(), y[i] = read(), r[i] = read();
  solve(x);
  solve(y);
  return 0;
}
