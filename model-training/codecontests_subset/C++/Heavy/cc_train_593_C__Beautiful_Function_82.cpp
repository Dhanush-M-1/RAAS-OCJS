#include <bits/stdc++.h>
using namespace std;
const int S = 53;
char buf[1000000], *p1, *p2;
inline char gc() {
  return p1 == p2 && (p2 = (p1 = buf) + fread(buf, 1, 1000000, stdin), p1 == p2)
             ? EOF
             : *p1++;
}
inline int rd() {
  register int f = 0;
  register char c = gc();
  while (c < 48 || c > 57) c = gc();
  while (c > 47 && c < 58) f = f * 10 + (c ^ 48), c = gc();
  return f;
}
int f[S][3];
void slv(int l, int r, int v) {
  if (l == r) {
    printf("(%01d*abs(((1-abs((t-%d)))+abs((abs((t-%d))-1)))))", f[l][v] >> 1,
           l, l);
    return;
  }
  register int m = l + r >> 1;
  putchar('('), slv(l, m, v), putchar('+'), slv(m + 1, r, v), putchar(')');
}
int main() {
  register int n = rd(), i;
  for (i = 1; i <= n; ++i) f[i][0] = rd(), f[i][1] = rd(), f[i][2] = rd();
  slv(1, n, 0), putchar('\n'), slv(1, n, 1);
  return 0;
}
