#include <bits/stdc++.h>
using namespace std;
long long n, a, b, c, sum[100010], tot, ans;
inline long long read() {
  long long cnt = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    cnt = cnt * 10 + ch - 48;
    ch = getchar();
  }
  return cnt * f;
}
int main() {
  n = read();
  a = read();
  b = read();
  c = read();
  for (int i = 0; i <= a; i += 2)
    for (int j = 0; j <= b; j++) sum[(int)(i * 0.5 + j)]++;
  for (int i = 0; i <= c && n - i * 2 >= 0; i++) ans += sum[n - i * 2];
  printf("%lld\n", ans);
  return 0;
}
