#include <bits/stdc++.h>
using namespace std;
long long read() {
  long long q = 0, w = 1;
  char ch = getchar();
  while (ch > '9' || ch < '0') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    q = q * 10 + (ch - '0');
    ch = getchar();
  }
  return q * w;
}
const long long N = 1000 + 95;
const long long M = 1e6 + 95;
long long n, m, q;
struct Edge {
  long long u, v, w, num;
} e[M];
vector<Edge> s;
bool cmp(Edge x, Edge y) { return x.w > y.w; }
long long fa[N << 1];
long long Find(long long x) {
  if (fa[x] == x) return x;
  return (fa[x] = Find(fa[x]));
}
int main() {
  n = read();
  m = read();
  q = read();
  for (long long i = 1; i <= m; i++) {
    e[i].u = read();
    e[i].v = read();
    e[i].w = read();
    e[i].num = i;
  }
  sort(e + 1, e + m + 1, cmp);
  while (q--) {
    long long u = read(), v = read();
    for (long long i = 1; i <= (n << 1); i++) fa[i] = i;
    long long cnt = -1;
    for (long long i = 1; i <= m; i++) {
      if (e[i].num < u || v < e[i].num) continue;
      long long x = e[i].u, y = e[i].v;
      long long fax = Find(x), fay = Find(y);
      if (fax == fay) {
        cnt = e[i].w;
        break;
      }
      fa[fax] = Find(y + n);
      fa[fay] = Find(x + n);
    }
    cout << cnt << '\n';
  }
  return 0;
}
