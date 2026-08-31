#include <bits/stdc++.h>
using namespace std;
int n, q, m, f[2005];
struct node {
  int x, y, z, id;
} a[500000];
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') f = -1;
  for (; isdigit(ch); ch = getchar()) x = (x + (x << 2) << 1) + (ch ^ 48);
  return x * f;
}
bool cmp(const node &x, const node &y) { return x.z > y.z; }
int getf(int x) {
  if (x == f[x]) return x;
  return f[x] = getf(f[x]);
}
int main() {
  n = read(), m = read(), q = read();
  for (int i = 1; i <= m; i++)
    a[i].x = read(), a[i].y = read(), a[i].z = read(), a[i].id = i;
  sort(a + 1, a + m + 1, cmp);
  while (q--) {
    int l = read(), r = read(), ans = -1;
    for (int i = 1; i <= (n << 1); i++) f[i] = i;
    for (int i = 1; i <= m; i++)
      if (a[i].id >= l && a[i].id <= r) {
        int x = getf(a[i].x), y = getf(a[i].y);
        if (x == y) {
          ans = a[i].z;
          break;
        }
        f[getf(a[i].y + n)] = x, f[y] = getf(a[i].x + n);
      }
    printf("%d\n", ans);
  }
  return 0;
}
