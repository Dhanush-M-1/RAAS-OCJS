#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void rread(T& num) {
  num = 0;
  T f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') num = num * 10 + ch - '0', ch = getchar();
  num *= f;
}
inline int getgcd(int x, int y) {
  if (!x) return y;
  return getgcd(y % x, x);
}
inline long long getlcm(int x, int y) {
  return (long long)x / getgcd(x, y) * y;
}
inline long long getgcd(long long x, long long y) {
  if (!x) return y;
  return getgcd(y % x, x);
}
inline long long getlcm(long long x, long long y) {
  return x / getgcd(x, y) * y;
}
inline int power(int x, int k, int p) {
  int res = 1;
  for (; k; k >>= 1, x = (long long)x * x % p)
    if (k & 1) res = (long long)res * x % p;
  return res;
}
inline long long power(long long x, long long k, long long p) {
  long long res = 1;
  for (; k; k >>= 1, x = x * x % p)
    if (k & 1) res = res * x % p;
  return res;
}
const double pi = acos(-1);
inline void judge() { freopen("input.txt", "r", stdin); }
const int maxm = 1e6 + 5;
const int maxn = 2e3 + 5;
int n, m, q;
int fa[maxn], rk[maxn];
struct edge {
  int x, y, z, id;
} e[maxm];
inline bool cmp(edge a, edge b) { return a.z > b.z; }
inline int find(int x) { return fa[x] == x ? x : fa[x] = find(fa[x]); }
inline void merge(int x, int y) {
  x = find(x);
  y = find(y);
  if (x == y) return;
  if (rk[x] == rk[y])
    rk[y]++;
  else if (rk[x] > rk[y])
    swap(rk[x], rk[y]);
  fa[x] = y;
}
int main() {
  rread(n);
  rread(m);
  rread(q);
  for (int(i) = (1); (i) <= (m); (i)++)
    rread(e[i].x), rread(e[i].y), rread(e[i].z), e[i].id = i;
  sort(e + 1, e + m + 1, cmp);
  while (q--) {
    int l, r;
    rread(l);
    rread(r);
    bool flag = 0;
    for (int(i) = (1); (i) <= (n * 2); (i)++) fa[i] = i, rk[i] = 0;
    for (int(i) = (1); (i) <= (m); (i)++)
      if (e[i].id >= l && e[i].id <= r) {
        merge((2 * e[i].x - 1), (2 * e[i].y));
        merge((2 * e[i].x), (2 * e[i].y - 1));
        if (find((2 * e[i].x - 1)) == find((2 * e[i].x)) ||
            find((2 * e[i].y - 1)) == find((2 * e[i].y))) {
          printf("%d\n", e[i].z);
          flag = 1;
        }
        if (flag) break;
      }
    if (!flag) puts("-1");
  }
  return 0;
}
