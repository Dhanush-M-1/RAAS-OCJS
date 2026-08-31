#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long f = 1, x = 0;
  char s = getchar();
  while (s < '0' || s > '9') {
    if (s == '-') f = -1;
    s = getchar();
  }
  while (s >= '0' && s <= '9') {
    x = x * 10 + (s - '0');
    s = getchar();
  }
  return x * f;
}
const int jzm = 1000000007;
int n, m, i, j, s, o, k;
struct it {
  int u, v, w, id;
} e[1000005];
bool cmp(it a, it b) { return a.w > b.w; }
int fa[1005 << 1];
int findf(int x) { return x == fa[x] ? x : (fa[x] = findf(fa[x])); }
void unionSet(int a, int b) {
  int u = findf(a), v = findf(b);
  if (u != v) fa[u] = v;
}
int main() {
  n = read();
  m = read();
  int q = read();
  for (int i = 1; i <= m; i++) {
    e[i].u = read();
    e[i].v = read();
    e[i].w = read();
    e[i].id = i;
  }
  sort(e + 1, e + 1 + m, cmp);
  while (q--) {
    s = read();
    o = read();
    for (int i = 1; i <= 2 * n; i++) {
      fa[i] = i;
    }
    for (int i = 1; i <= m + 1; i++) {
      if (i == m + 1) {
        printf("-1\n");
        break;
      }
      if (e[i].id >= s && e[i].id <= o) {
        int a = e[i].u, b = e[i].v;
        if (findf(a) == findf(b)) {
          printf("%d\n", e[i].w);
          break;
        } else {
          unionSet(a + n, b);
          unionSet(a, b + n);
        }
      }
    }
  }
  return 0;
}
