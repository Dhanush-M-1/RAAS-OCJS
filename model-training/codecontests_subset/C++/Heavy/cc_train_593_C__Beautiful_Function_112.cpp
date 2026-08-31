#include <bits/stdc++.h>
const int N = 105;
using namespace std;
int n, x[N], y[N], r[N];
template <typename T>
inline T read() {
  T x = 0, w = 1;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') w = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = getchar();
  return x * w;
}
int main() {
  n = read<int>();
  for (int i = 1; i <= n; i++)
    x[i] = read<int>(), y[i] = read<int>(), r[i] = read<int>();
  for (int i = 1; i < n; i++) putchar('(');
  for (int i = 1; i <= n; i++) {
    if (i >= 2) putchar('+');
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", x[i] / 2, i, i);
    if (i >= 2) putchar(')');
  }
  puts("");
  for (int i = 1; i < n; i++) putchar('(');
  for (int i = 1; i <= n; i++) {
    if (i >= 2) putchar('+');
    printf("(%d*((1-abs((t-%d)))+abs((abs((t-%d))-1))))", y[i] / 2, i, i);
    if (i >= 2) putchar(')');
  }
  puts("");
  return 0;
}
