#include <bits/stdc++.h>
using namespace std;
long long A, B, c, d, E, F;
int read();
bool zc(long long fz, long long fm) { return !(fz % fm); }
bool ask(long long a, long long b, long long e, long long f) {
  if (!e && !f) return a == c & b == d;
  if (!e) return zc(c - a, f) & zc(d - b, f);
  if (!f) return zc(c - a, e) & zc(d - b, e);
  long long fx = e * (c - a) + f * (d - b);
  long long fy = f * (c - a) + e * (b - d);
  long long fm = e * e + f * f;
  fx = fx < 0 ? -fx : fx;
  fy = fy < 0 ? -fy : fy;
  return zc(fx, fm) & zc(fy, fm);
}
int main() {
  A = read(), B = read(), c = read();
  d = read(), E = read(), F = read();
  if (ask(A, B, E, F))
    return puts("YES"), 0;
  else if (ask(A, B, -F, E))
    return puts("YES"), 0;
  else if (ask(A, B, F, -E))
    return puts("YES"), 0;
  else if (ask(A, B, -E, -F))
    return puts("YES"), 0;
  else if (ask(-B, A, E, F))
    return puts("YES"), 0;
  else if (ask(-B, A, -F, E))
    return puts("YES"), 0;
  else if (ask(-B, A, F, -E))
    return puts("YES"), 0;
  else if (ask(-B, A, -E, -F))
    return puts("YES"), 0;
  else if (ask(B, -A, E, F))
    return puts("YES"), 0;
  else if (ask(B, -A, -F, E))
    return puts("YES"), 0;
  else if (ask(B, -A, F, -E))
    return puts("YES"), 0;
  else if (ask(B, -A, -E, -F))
    return puts("YES"), 0;
  else if (ask(-A, -B, E, F))
    return puts("YES"), 0;
  else if (ask(-A, -B, -F, E))
    return puts("YES"), 0;
  else if (ask(-A, -B, F, -E))
    return puts("YES"), 0;
  else if (ask(-A, -B, -E, -F))
    return puts("YES"), 0;
  else
    puts("NO");
  return 0;
}
int read() {
  int x = 0, f = 1;
  char c = getchar();
  while (c > '9' || c < '0') f = (c == '-') ? -1 : f, c = getchar();
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = getchar();
  return x * f;
}
