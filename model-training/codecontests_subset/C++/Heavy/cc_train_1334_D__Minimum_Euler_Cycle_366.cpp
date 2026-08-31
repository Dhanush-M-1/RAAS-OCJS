#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  register char c = ' ';
  register long long v = 0, x = 1;
  while ((c < '0') || (c > '9')) {
    if (c == '-') x = -1;
    c = getchar();
  }
  while ((c >= '0') && (c <= '9')) {
    v = (v << 1) + (v << 3) + (c ^ 48);
    c = getchar();
  }
  return v * x;
}
inline void write(register long long x) {
  if (x < 0) x = -x, putchar('-');
  if (x > 9) write(x / 10);
  putchar(x % 10 ^ 48);
}
long long t, n, l, r, x, y;
inline void calc(register long long m) {
  if (m > n * (n - 1) / 2) return (void)(x = y = 1ll);
  register long long a = 0, b = 0;
  while (a < m) a += n - 1 - b, b++;
  a -= n - b, x = b, y = m - a + b;
}
inline void nxt() {
  (y != n) ? (y++) : (x++, y = x + 1);
  if (x == n) x = 1;
}
int main() {
  t = read();
  while (t--) {
    n = read(), l = read(), r = read(), calc((l + 1) >> 1);
    for (register long long i = l; i <= r; i++, putchar(' '))
      (i & 1) ? write(x) : (write(y), nxt());
    putchar('\n');
  }
  return ~~(0 - 0);
}
