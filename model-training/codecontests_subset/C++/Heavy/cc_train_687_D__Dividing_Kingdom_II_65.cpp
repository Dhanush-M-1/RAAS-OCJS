#include <bits/stdc++.h>
using namespace std;
void fre() {
  freopen("c://test//input.in", "r", stdin);
  freopen("c://test//output.out", "w", stdout);
}
template <class T1, class T2>
inline void gmax(T1 &a, T2 b) {
  if (b > a) a = b;
}
template <class T1, class T2>
inline void gmin(T1 &a, T2 b) {
  if (b < a) a = b;
}
const int N = 1010, M = 5e5 + 10, Z = 1e9 + 7, ms63 = 0x3f3f3f3f;
int n, m, q;
struct Edge {
  int x, y, z, o;
  bool operator<(const Edge &b) const { return z > b.z; }
} a[M];
int f[N], op[N];
int find(int x) { return f[x] == x ? f[x] : f[x] = find(f[x]); }
int solve(int l, int r) {
  for (int i = 1; i <= n; ++i) f[i] = i, op[i] = -1;
  for (int i = 1; i <= m; ++i)
    if (a[i].o >= l && a[i].o <= r) {
      int x = find(a[i].x);
      int y = find(a[i].y);
      if (x == y) return a[i].z;
      if (op[x] == -1) op[x] = y;
      if (op[y] == -1) op[y] = x;
      op[x] = find(op[x]);
      op[y] = find(op[y]);
      f[x] = op[y];
      f[y] = op[x];
    }
  return -1;
}
int main() {
  while (~scanf("%d%d%d", &n, &m, &q)) {
    for (int i = 1; i <= m; ++i) {
      scanf("%d%d%d", &a[i].x, &a[i].y, &a[i].z);
      a[i].o = i;
    }
    sort(a + 1, a + m + 1);
    while (q--) {
      int x, y;
      scanf("%d%d", &x, &y);
      printf("%d\n", solve(x, y));
    }
  }
  return 0;
}
