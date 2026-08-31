#include <bits/stdc++.h>
char BB[1 << 15], *SS = BB, *TT = BB;
inline int Read() {
  register int x = 0;
  register char ch =
      (SS == TT && (TT = (SS = BB) + fread(BB, 1, 1 << 15, stdin), TT == SS)
           ? EOF
           : *SS++);
  while (ch < '0' || ch > '9')
    ch = (SS == TT && (TT = (SS = BB) + fread(BB, 1, 1 << 15, stdin), TT == SS)
              ? EOF
              : *SS++);
  while (ch <= '9' && ch >= '0') {
    x = x * 10 + (ch ^ 48);
    ch = (SS == TT && (TT = (SS = BB) + fread(BB, 1, 1 << 15, stdin), TT == SS)
              ? EOF
              : *SS++);
  }
  return x;
}
inline int Max(const int x, const int y) { return x > y ? x : y; }
int a[100 + 5], b[100 + 5], n, m, f[10000 + 42], g[10000 + 42], ans;
int main() {
  n = Read();
  for (register int i = 1; i <= n; ++i) m += (a[i] = Read());
  for (register int i = 1; i <= n; ++i) b[i] = Read();
  for (register int i = m + 100; i >= 1; --i) f[i] = n;
  for (register int i = 1; i <= n; ++i)
    for (register int j = m + 100; j >= b[i]; --j)
      if (f[j - b[i]] + 1 < f[j]) {
        f[j] = f[j - b[i]] + 1;
        g[j] = g[j - b[i]] + a[i];
      } else if (f[j - b[i]] + 1 == f[j])
        g[j] = Max(g[j], g[j - b[i]] + a[i]);
  f[0] = n;
  for (register int i = m + 100; i >= m; --i)
    if (f[ans] > f[i])
      ans = i;
    else if (f[ans] == f[i] && g[ans] < g[i])
      ans = i;
  printf("%d %d", f[ans], m - g[ans]);
  return 0;
}
