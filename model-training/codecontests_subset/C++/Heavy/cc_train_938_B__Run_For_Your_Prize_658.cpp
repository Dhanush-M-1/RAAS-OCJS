#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x;
  char c;
  int f = 1;
  while ((c = getchar()) != '-' && (c > '9' || c < '0'))
    ;
  if (c == '-') c = getchar(), f = -1;
  x = c ^ '0';
  while ((c = getchar()) >= '0' && c <= '9')
    x = (x << 1) + (x << 3) + (c ^ '0');
  return x * f;
}
inline long long readll() {
  long long x;
  char c;
  int f = 1;
  while ((c = getchar()) != '-' && (c > '9' || c < '0'))
    ;
  if (c == '-') c = getchar(), f = -1;
  x = c ^ '0';
  while ((c = getchar()) >= '0' && c <= '9')
    x = (x << 1ll) + (x << 3ll) + (c ^ '0');
  return x * f;
}
int x = 1, y = 1e6, Mid = (x + y) >> 1;
int main() {
  int n = read(), u = 0, v = 0;
  for (register int i = 1, iend = n; i <= iend; ++i) {
    int x = read();
    if (x > Mid)
      u = max(u, y - x);
    else
      v = max(v, x - 1);
  }
  printf("%d\n", max(u, v));
  return 0;
}
