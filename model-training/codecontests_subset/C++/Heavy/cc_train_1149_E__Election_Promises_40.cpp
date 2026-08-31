#include <bits/stdc++.h>
using namespace std;
namespace io {
const int SIZE = (1 << 21) + 1;
char ibuf[SIZE], *iS, *iT, obuf[SIZE], *oS = obuf, *oT = oS + SIZE - 1, c,
                                       qu[55];
int f, qr;
inline void flush() {
  fwrite(obuf, 1, oS - obuf, stdout);
  oS = obuf;
}
inline void putc(char x) {
  *oS++ = x;
  if (oS == oT) flush();
}
template <class I>
inline void gi(I &x) {
  for (f = 1, c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                              (iS == iT ? EOF : *iS++))
                            : *iS++);
       c < '0' || c > '9';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    if (c == '-') f = -1;
  for (x = 0; c <= '9' && c >= '0';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    x = (x << 1) + (x << 3) + (c & 15);
  x *= f;
}
template <class I>
inline void get(I &x) {
  for (c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++);
       c < 'A' || c > 'Z';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    ;
  x = c;
}
inline void read(char *s) {
  for (c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++);
       c < 'A' || c > 'Z';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    ;
  for (; c >= 'A' && c <= 'Z';
       c = (iS == iT ? (iT = (iS = ibuf) + fread(ibuf, 1, SIZE, stdin),
                       (iS == iT ? EOF : *iS++))
                     : *iS++))
    *++s = c;
  *++s = '\0';
}
template <class I>
inline void print(I x) {
  if (!x) putc('0');
  if (x < 0) putc('-'), x = -x;
  while (x) qu[++qr] = x % 10 + '0', x /= 10;
  while (qr) putc(qu[qr--]);
}
struct Flusher_ {
  ~Flusher_() { flush(); }
} io_flusher_;
}  // namespace io
using io ::get;
using io ::gi;
using io ::print;
using io ::putc;
using io ::read;
const int N = 2e5 + 5;
vector<int> e[N], v[N];
int deg[N], q[N], num[N], vis[N];
long long h[N], val[N];
int main() {
  register int n, m, i, x, y, l, r, cnt;
  gi(n);
  gi(m);
  for (i = 1; i <= n; ++i) gi(h[i]);
  while (m--) gi(x), gi(y), ++deg[x], e[y].push_back(x), v[x].push_back(y);
  l = 1;
  r = 0;
  for (i = 1; i <= n; ++i)
    if (!deg[i]) q[++r] = i;
  cnt = 0;
  while (l <= r) {
    x = q[l++];
    for (auto y : v[x]) vis[num[y]] = 1;
    while (vis[num[x]]) ++num[x];
    for (auto y : v[x]) vis[num[y]] = 0;
    cnt = max(cnt, num[x]);
    for (auto y : e[x])
      if (!--deg[y]) q[++r] = y;
  }
  for (i = 1; i <= n; ++i) val[num[i]] ^= h[i];
  for (i = cnt; i >= 0; --i)
    if (val[i]) {
      putc('W');
      putc('I');
      putc('N');
      putc('\n');
      for (x = 1; x <= n; ++x)
        if (num[x] == i && h[x] > (h[x] ^ val[i])) {
          h[x] ^= val[i];
          for (auto y : v[x]) h[y] ^= val[num[y]], val[num[y]] = 0;
          for (i = 1; i <= n; ++i) print(h[i]), putc(' ');
          putc('\n');
          return 0;
        }
    }
  puts("LOSE");
  return 0;
}
