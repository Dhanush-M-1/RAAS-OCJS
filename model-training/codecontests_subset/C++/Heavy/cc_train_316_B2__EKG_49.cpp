#include <bits/stdc++.h>
#pragma GCC optimize(3, "Ofast", "inline")
#pragma GCC target("avx,avx2")
using namespace std;
template <class t>
inline t read(t &x) {
  char c = getchar();
  bool f = 0;
  x = 0;
  while (!isdigit(c)) f |= c == '-', c = getchar();
  while (isdigit(c)) x = (x << 1) + (x << 3) + (c ^ 48), c = getchar();
  if (f) x = -x;
  return x;
}
template <class t>
inline void write(t x) {
  if (x < 0)
    putchar('-'), write(-x);
  else {
    if (x > 9) write(x / 10);
    putchar('0' + x % 10);
  }
}
const int N = 1005;
int n, id, pos, nxt[N], a[N], m;
bool v[N];
bitset<1005> f;
signed main() {
  read(n);
  read(id);
  for (int i = 1, x; i <= n; i++)
    if (read(x)) v[i] = 1, nxt[x] = i;
  for (int i = 1; i <= n; i++)
    if (!v[i]) {
      int cnt = 1;
      bool flag = 1;
      for (int x = i; x && flag; cnt++, x = nxt[x])
        if (x == id) {
          flag = 0;
          pos = cnt;
          break;
        }
      if (flag) a[++m] = cnt - 1;
    }
  f[0] = 1;
  for (int i = 1; i <= m; i++) f |= f << a[i];
  for (int i = 0; i + pos <= n; i++)
    if (f[i]) write(i + pos), puts("");
}
