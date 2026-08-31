#include <bits/stdc++.h>
using namespace std;
void fio() {}
void pti() {
  double timeuse = clock() * 1000.0 / CLOCKS_PER_SEC;
  cerr << "Timeuse " << timeuse << "ms" << endl;
}
void end() { exit(0); }
namespace io {
const int SIZ = 55;
int que[SIZ], op, qr;
char ch;
template <class I>
inline void gi(I& w) {
  ch = getchar(), op = 1, w = 0;
  while (!isdigit(ch)) {
    if (ch == '-') op = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    w = w * 10 + ch - '0';
    ch = getchar();
  }
  w *= op;
}
template <typename T, typename... Args>
inline void gi(T& t, Args&... args) {
  gi(t);
  gi(args...);
}
template <class I>
inline void print(I w) {
  qr = 0;
  if (!w) putchar('0');
  if (w < 0) putchar('-'), w = -w;
  while (w) que[++qr] = w % 10 + '0', w /= 10;
  while (qr) putchar(que[qr--]);
}
}  // namespace io
using io::gi;
using io::print;
const int N = 2e5 + 5;
int n, num;
struct node {
  long long a, b;
};
node e[N];
long long c[N], t[N], sum[N];
map<long long, int> g;
int lowbit(int x) { return x & -x; }
void modify(int x, long long z) {
  while (x <= n) ++t[x], sum[x] += z, x += lowbit(x);
}
long long query_t(int x) {
  long long res = 0;
  while (x) res += t[x], x -= lowbit(x);
  return res;
}
long long query_sum(int x) {
  long long res = 0;
  while (x) res += sum[x], x -= lowbit(x);
  return res;
}
int main() {
  fio();
  gi(n);
  for (int i = 1; i <= n; ++i) gi(e[i].a);
  for (int i = 1; i <= n; ++i) gi(e[i].b), c[i] = e[i].b;
  sort(c + 1, c + n + 1);
  for (int i = 1; i <= n; ++i)
    if (!g[c[i]]) g[c[i]] = ++num;
  sort(e + 1, e + n + 1,
       [](node x, node y) { return x.a == y.a ? x.b < y.b : x.a < y.a; });
  long long ans = 0;
  for (int i = 1, j = 1; i <= n; ++i) {
    ans += e[i].a * query_t(g[e[i].b]) - query_sum(g[e[i].b]);
    while (j <= n && e[j].b == e[i].b && e[j].a == e[i].a)
      modify(g[e[j].b], e[j].a), ++j;
  }
  print(ans);
  end();
}
