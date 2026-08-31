#include <bits/stdc++.h>
using namespace std;
const int maxn = 200005;
int q, x, y, z, a1, a2, i, j, k, l, n, m, ans;
bool f;
int a[maxn];
int b[maxn];
int c[maxn];
int d[maxn];
int get1(int x) {
  int sum = 0;
  while (x > 0) {
    sum += b[x];
    x -= x & (-x);
  }
  return sum;
}
int get2(int x) {
  int sum = 0;
  while (x > 0) {
    sum += c[x];
    x -= x & (-x);
  }
  return sum;
}
void add1(int x, int q) {
  while (x <= n) {
    b[x] += q;
    x += x & (-x);
  }
}
void add2(int x, int q) {
  while (x <= n) {
    c[x] += q;
    x += x & (-x);
  }
}
int main() {
  cin >> n >> k >> a1 >> a2 >> q;
  for (i = 1; i <= q; i++) {
    scanf("%d", &x);
    if (x == 1) {
      scanf("%d%d", &y, &z);
      add1(y, min(a1 - a[y], z));
      a[y] = min(a1, a[y] + z);
      add2(y, min(a2 - d[y], z));
      d[y] = min(a2, d[y] + z);
    } else {
      scanf("%d", &y);
      ans = get2(y - 1) + (get1(n) - get1(y + k - 1));
      printf("%d\n", ans);
    }
  }
}
