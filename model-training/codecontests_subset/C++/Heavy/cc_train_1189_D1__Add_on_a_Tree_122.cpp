#include <bits/stdc++.h>
using namespace std;
const long long maxn = 1e5 + 10;
long long n, deg[maxn];
long long read() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
void print(long long x) {
  if (x < 0) putchar('-'), x = -x;
  if (x > 9) print(x / 10);
  putchar(x % 10 + '0');
}
void write(long long x) {
  print(x);
  puts("");
}
signed main() {
  n = read();
  bool flag = 0;
  for (long long i = 2; i <= n; i++) deg[read()]++, deg[read()]++;
  for (long long i = 1; i <= n; i++)
    if (deg[i] == 2) {
      puts("NO");
      flag = 1;
      break;
    }
  if (!flag) puts("YES");
  return 0;
}
