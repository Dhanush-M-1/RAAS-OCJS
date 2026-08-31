#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  register char ch = getchar();
  register long long x = 0;
  register bool y = 1;
  while (ch != '-' && (ch > '9' || ch < '0')) ch = getchar();
  if (ch == '-') ch = getchar(), y = 0;
  while (ch >= '0' && ch <= '9')
    x = (x << 1) + (x << 3) + (ch ^ '0'), ch = getchar();
  return y ? x : -x;
}
int point[51][3], n;
void solve(int l, int r, int dir) {
  if (l == r)
    printf("(%01d*abs(((1-abs((t-%d)))+abs((abs((t-%d))-1)))))",
           point[l][dir] / 2, l, l);
  else {
    printf("(");
    solve(l, (l + r) >> 1, dir);
    printf("+");
    solve(((l + r) >> 1) + 1, r, dir);
    printf(")");
  }
}
int main() {
  n = read();
  for (register long long i = 1; i <= n; ++i)
    point[i][0] = read(), point[i][1] = read(), point[i][2] = read();
  solve(1, n, 0);
  printf("\n");
  solve(1, n, 1);
  return 0;
}
