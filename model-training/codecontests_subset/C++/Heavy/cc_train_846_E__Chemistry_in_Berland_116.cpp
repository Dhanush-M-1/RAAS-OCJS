#include <bits/stdc++.h>
const long long MaxN = 1e5 + 50;
struct Edge {
  long long nxt, to, w;
} E[MaxN << 2];
template <class t>
inline void read(t &s) {
  s = 0;
  register long long f = 1;
  register char c = getchar();
  while (!isdigit(c)) {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (isdigit(c)) s = (s << 3) + (s << 1) + (c ^ 48), c = getchar();
  s *= f;
  return;
}
template <class t, class... A>
inline void read(t &x, A &...a) {
  read(x);
  read(a...);
}
template <class t>
inline void write(t x) {
  if (x < 0) putchar('-'), x = -x;
  long long buf[21], top = 0;
  while (x) buf[++top] = x % 10, x /= 10;
  if (!top) buf[++top] = 0;
  while (top) putchar(buf[top--] ^ '0');
  return;
}
inline void setIn(std::string s) {
  freopen(s.c_str(), "r", stdin);
  return;
}
inline void setOut(std::string s) {
  freopen(s.c_str(), "w", stdout);
  return;
}
inline void setIO(std::string s = "") {
  setIn(s + ".in");
  setOut(s + ".out");
  return;
}
template <class t>
inline bool checkmin(t &x, t y) {
  if (x > y) {
    x = y;
    return 1;
  }
  return 0;
}
template <class t>
inline bool checkmax(t &x, t y) {
  if (x < y) {
    x = y;
    return 1;
  }
  return 0;
}
inline long long lowbit(long long x) { return x & (-x); }
long long hd[MaxN], en, n;
inline void adde(long long u, long long v, long long w) {
  E[++en] = (Edge){hd[u], v, w}, hd[u] = en;
}
long double f[MaxN];
const long double eps = 1e-9;
const long double Lim = -1e50;
inline long long sign(long double x) {
  if (std::fabs(x) < eps) return 0;
  return x > 0 ? 1 : -1;
}
inline void dfs(long long u) {
  for (long long i = hd[u]; ~i; i = E[i].nxt) {
    register long long v = E[i].to;
    dfs(v);
    if (!sign(f[v])) continue;
    if (sign(f[v]) > 0)
      f[u] += f[v];
    else
      f[u] += f[v] * E[i].w, checkmax(f[u], Lim);
  }
}
signed main(void) {
  std::memset(hd, -1, sizeof hd);
  read(n);
  register long long x, y;
  for (long long i = 1; i <= n; ++i) read(x), f[i] += x;
  for (long long i = 1; i <= n; ++i) read(x), f[i] -= x;
  for (long long i = 2; i <= n; ++i) read(x, y), adde(x, i, y);
  dfs(1);
  std::puts(sign(f[1]) >= 0 ? "YES" : "NO");
  return 0;
}
