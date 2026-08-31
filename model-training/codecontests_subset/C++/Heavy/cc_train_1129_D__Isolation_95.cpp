#include <bits/stdc++.h>
using namespace std;
int n, K, a[100009], pre[100009], ind[100009], ans[100009];
int bf[296][100009 << 1], bst[296], bans[296], f[100009];
inline int read();
inline void M(int& x, int y) {
  x = x + y < 998244353 ? x + y : x + y - 998244353;
}
inline int get_B(int x) { return (x + 340 - 1) / 340; }
inline void add_scatter(int l, int r, int va, int ib) {
  for (register int i(l); i <= r; ++i) {
    M(bf[ib][f[i] + 100009], 998244353 - ans[i - 1]);
    if (f[i] == bst[ib] && va == 1) M(bans[ib], 998244353 - ans[i - 1]);
    f[i] += va;
    M(bf[ib][f[i] + 100009], ans[i - 1]);
    if (f[i] == bst[ib] && va != 1) M(bans[ib], ans[i - 1]);
  }
}
inline void add(int l, int r, int va) {
  int lb = get_B(l), rb = get_B(r);
  if (lb == rb) return add_scatter(l, r, va, lb);
  if (l % 340 != 1) {
    add_scatter(l, lb * 340, va, lb);
    ++lb;
  }
  if (r % 340) {
    add_scatter((rb - 1) * 340 + 1, r, va, rb);
    --rb;
  }
  for (register int i(lb); i <= (rb); ++i)
    if (va == 1) {
      M(bans[i], 998244353 - bf[i][bst[i] + 100009]);
      --bst[i];
    } else {
      ++bst[i];
      M(bans[i], bf[i][bst[i] + 100009]);
    }
}
inline int ask_scatter(int l, int r, int ib, int ret = 0) {
  for (register int i(l); i <= r; ++i)
    if (f[i] <= bst[ib]) M(ret, ans[i - 1]);
  return ret;
}
inline int ask(int l, int r) {
  int lb = get_B(l), rb = get_B(r), ret = 0;
  if (lb == rb) return ask_scatter(l, r, lb);
  if (l % 340 != 1) {
    M(ret, ask_scatter(l, lb * 340, lb));
    ++lb;
  }
  if (r % 340) {
    M(ret, ask_scatter((rb - 1) * 340 + 1, r, rb));
    --rb;
  }
  for (register int i(lb); i <= rb; ++i) M(ret, bans[i]);
  return ret;
}
int main() {
  n = read(), K = read();
  ans[0] = 1;
  for (register int i(1); i <= n; ++i) {
    a[i] = read();
    pre[i] = ind[a[i]];
    ind[a[i]] = i;
  }
  int nB = get_B(n);
  for (register int i(1); i <= nB; ++i) bst[i] = K;
  for (register int i(1); i <= n; ++i) {
    if (pre[i]) add(pre[pre[i]] + 1, pre[i], -1);
    int ib = get_B(i);
    M(bf[ib][100009], ans[i - 1]);
    if (0 <= bst[ib]) M(bans[ib], ans[i - 1]);
    add(pre[i] + 1, i, 1);
    ans[i] = ask(1, i);
  }
  printf("%d\n", ans[n]);
  return 0;
}
inline int read() {
  int x = 0, f = 1;
  char c = getchar();
  while (c > '9' || c < '0') f = (c == '-') ? -1 : f, c = getchar();
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = getchar();
  return x * f;
}
