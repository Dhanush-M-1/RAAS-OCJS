#include <bits/stdc++.h>
using namespace std;
inline long long Rd() {
  long long x = 0;
  int ch = getchar(), f = 1;
  while (!isdigit(ch) && (ch != '-') && (ch != EOF)) ch = getchar();
  if (ch == '-') {
    f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = (x << 1) + (x << 3) + ch - '0';
    ch = getchar();
  }
  return x * f;
}
inline void Rt(long long x) {
  if (x < 0) putchar('-'), x = -x;
  if (x >= 10)
    Rt(x / 10), putchar(x % 10 + '0');
  else
    putchar(x + '0');
}
const int N = 1005, M = 500005;
struct Edge {
  int u, v, w, id;
  bool operator<(const Edge& x) const { return w > x.w; }
} E[M];
int n, m, q, Fa[N], Val[N], Dep[N];
int Find(int x) {
  if (x == Fa[x]) return x;
  int F = Find(Fa[x]);
  Val[x] = Val[x] ^ Val[Fa[x]];
  return Fa[x] = F;
}
int main() {
  n = Rd(), m = Rd(), q = Rd();
  for (int i = 1; i <= (int)m; i++)
    E[i].u = Rd(), E[i].v = Rd(), E[i].w = Rd(), E[i].id = i;
  sort(E + 1, E + m + 1);
  while (q--) {
    int l = Rd(), r = Rd();
    for (int i = 1; i <= (int)n; i++) Fa[i] = i, Val[i] = 0, Dep[i] = 1;
    int sign = 0;
    for (int i = 1; i <= (int)m; i++) {
      if (E[i].id > r || E[i].id < l) continue;
      int Fu = Find(E[i].u), Fv = Find(E[i].v);
      if (Fu != Fv) {
        if (Dep[Fu] < Dep[Fv]) swap(Fu, Fv);
        Fa[Fv] = Fu;
        if (Dep[Fv] == Dep[Fu]) Dep[Fu]++;
        Val[Fv] = Val[E[i].v] ^ Val[E[i].u] ^ 1;
      } else {
        if (Val[E[i].u] == Val[E[i].v]) {
          Rt(E[i].w), putchar('\n');
          sign = 1;
          break;
        }
      }
    }
    if (!sign) puts("-1");
  }
}
