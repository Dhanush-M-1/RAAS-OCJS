#include <bits/stdc++.h>
#pragma GCC optimize("inline,Ofast", 3)
#pragma GCC optimize(2)
#pragma GCC optimize(3)
#pragma GCC optimize("Ofast")
#pragma GCC optimize("inline")
#pragma GCC optimize("-fgcse")
#pragma GCC optimize("-fgcse-lm")
#pragma GCC optimize("-fipa-sra")
#pragma GCC optimize("-ftree-pre")
#pragma GCC optimize("-ftree-vrp")
#pragma GCC optimize("-fpeephole2")
#pragma GCC optimize("-ffast-math")
#pragma GCC optimize("-fsched-spec")
#pragma GCC optimize("unroll-loops")
#pragma GCC optimize("-falign-jumps")
#pragma GCC optimize("-falign-loops")
#pragma GCC optimize("-falign-labels")
#pragma GCC optimize("-fdevirtualize")
#pragma GCC optimize("-fcaller-saves")
#pragma GCC optimize("-fcrossjumping")
#pragma GCC optimize("-fthread-jumps")
#pragma GCC optimize("-funroll-loops")
#pragma GCC optimize("-fwhole-program")
#pragma GCC optimize("-freorder-blocks")
#pragma GCC optimize("-fschedule-insns")
#pragma GCC optimize("inline-functions")
#pragma GCC optimize("-fschedule-insns2")
#pragma GCC optimize("-fstrict-aliasing")
#pragma GCC optimize("-fstrict-overflow")
#pragma GCC optimize("-falign-functions")
#pragma GCC optimize("-fcse-skip-blocks")
#pragma GCC optimize("-fcse-follow-jumps")
#pragma GCC optimize("-fsched-interblock")
#pragma GCC optimize("-fpartial-inlining")
#pragma GCC optimize("no-stack-protector")
#pragma GCC optimize("-freorder-functions")
#pragma GCC optimize("-findirect-inlining")
#pragma GCC optimize("inline-small-functions")
#pragma GCC optimize("-finline-small-functions")
#pragma GCC optimize("-ftree-switch-conversion")
#pragma GCC optimize("-foptimize-sibling-calls")
#pragma GCC optimize("-fexpensive-optimizations")
#pragma GCC optimize("-funsafe-loop-optimizations")
#pragma GCC optimize("inline-functions-called-once")
#pragma GCC optimize("-fdelete-null-pointer-checks")
using namespace std;
long long n, m, q, fa[1000010], ans, l, r;
struct lujing {
  long long u, v, c, id;
} f[1000010];
inline long long read() {
  long long w = 0, e = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    e = ch == '-' ? -1 : 1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    w = (w << 3) + (w << 1) + (ch ^ 48);
    ch = getchar();
  }
  return w * e;
}
long long find(long long x) { return (fa[x] == x) ? x : (fa[x] = find(fa[x])); }
void add(long long x, long long y) {
  long long xx = find(x), yy = find(y);
  if (xx != yy) fa[xx] = yy;
}
bool pd(long long x, long long y) {
  long long xx = find(x), yy = find(y);
  if (xx == yy) return true;
  return false;
}
bool cmp(lujing x, lujing y) { return x.c > y.c; }
int main() {
  n = read();
  m = read();
  q = read();
  for (register int i = 1; i <= m; ++i)
    f[i].u = read(), f[i].v = read(), f[i].c = read(), f[i].id = i;
  sort(f + 1, f + 1 + m, cmp);
  while (q--) {
    l = read(), r = read();
    ans = -1;
    for (register int i = 1; i <= n * 2; ++i) fa[i] = i;
    for (register int i = 1; i <= m; ++i) {
      if (f[i].id >= l && f[i].id <= r) {
        if (pd(f[i].u, f[i].v)) {
          ans = f[i].c;
          break;
        } else {
          add(f[i].u + n, f[i].v);
          add(f[i].u, f[i].v + n);
        }
      }
    }
    cout << ans << endl;
  }
  return 0;
}
