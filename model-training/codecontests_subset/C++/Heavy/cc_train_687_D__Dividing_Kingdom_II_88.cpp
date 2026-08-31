#include <bits/stdc++.h>
using namespace std;
void getre() {
  int x = 0;
  printf("%d\n", 1 / x);
}
void gettle() {
  int res = 1;
  while (1) res <<= 1;
  printf("%d\n", res);
}
template <typename T, typename S>
inline bool upmin(T &a, const S &b) {
  return a > b ? a = b, 1 : 0;
}
template <typename T, typename S>
inline bool upmax(T &a, const S &b) {
  return a < b ? a = b, 1 : 0;
}
template <typename N, typename PN>
inline N flo(N a, PN b) {
  return a >= 0 ? a / b : -((-a - 1) / b) - 1;
}
template <typename N, typename PN>
inline N cei(N a, PN b) {
  return a > 0 ? (a - 1) / b + 1 : -(-a / b);
}
template <typename N>
N gcd(N a, N b) {
  return b ? gcd(b, a % b) : a;
}
template <typename N>
inline int sgn(N a) {
  return a > 0 ? 1 : (a < 0 ? -1 : 0);
}
inline void gn(long long &x) {
  int sg = 1;
  char c;
  while (((c = getchar()) < '0' || c > '9') && c != '-')
    ;
  c == '-' ? (sg = -1, x = 0) : (x = c - '0');
  while ((c = getchar()) >= '0' && c <= '9') x = x * 10 + c - '0';
  x *= sg;
}
inline void gn(int &x) {
  long long t;
  gn(t);
  x = t;
}
inline void gn(unsigned long long &x) {
  long long t;
  gn(t);
  x = t;
}
inline void gn(double &x) {
  double t;
  scanf("%lf", &t);
  x = t;
}
inline void gn(long double &x) {
  double t;
  scanf("%lf", &t);
  x = t;
}
inline void gs(char *s) { scanf("%s", s); }
inline void gc(char &c) {
  while ((c = getchar()) > 126 || c < 33)
    ;
}
inline void pc(char c) { putchar(c); }
inline long long sqr(long long a) { return a * a; }
inline double sqrf(double a) { return a * a; }
const int inf = 0x3f3f3f3f;
const double pi = 3.14159265358979323846264338327950288L;
const double eps = 1e-6;
int n, m, q;
int u[1111111], v[1111111], w[1111111];
int ord[1111111];
int tot;
int cmp(int i, int j) { return w[i] > w[j]; }
int cmp1(int i, int j) { return w[i] < w[j]; }
int val[1111111];
int fa[2222];
int gf(int x) { return x == fa[x] ? x : fa[x] = gf(fa[x]); }
map<pair<int, int>, int> mem;
int u2[1111111], v2[1111111];
int main() {
  gn(n);
  gn(m);
  gn(q);
  for (int i = (1), _ed = (m + 1); i < _ed; i++) {
    gn(u[i]), gn(v[i]), gn(w[i]);
    ord[i] = i;
  }
  sort(ord + 1, ord + 1 + m, cmp1);
  for (int i = (1), _ed = (m + 1); i < _ed; i++) val[i] = w[ord[i]];
  for (int i = (1), _ed = (m + 1); i < _ed; i++)
    u2[i] = u[ord[i]], v2[i] = v[ord[i]];
  while (q--) {
    int l, r;
    gn(l);
    gn(r);
    if (mem.count(make_pair(l, r))) {
      printf("%d\n", mem[make_pair(l, r)]);
      continue;
    }
    for (int i = (1), _ed = (2 * n + 1); i < _ed; i++) fa[i] = i;
    int ans = -1;
    for (int i = m; i >= 1; i--)
      if (ord[i] >= l && ord[i] <= r) {
        int uu = u2[i], vv = v2[i];
        int a, b, c, d;
        if ((a = gf(uu)) == (b = gf(vv)) ||
            (c = gf(uu + n)) == (d = gf(vv + n))) {
          ans = w[ord[i]];
          break;
        }
        fa[a] = d;
        fa[b] = c;
      }
    printf("%d\n", mem[make_pair(l, r)] = ans);
  }
  return 0;
}
