#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5;
struct Edge {
  int v, next;
} edge[N << 1];
int head[N], esize;
inline void addedge(int x, int y) {
  edge[++esize] = (Edge){y, head[x]};
  head[x] = esize;
}
int n, m, ans;
int a[N];
int d[N];
inline void ins(int x) {
  for (int i = head[x], vv; ~i; i = edge[i].next) {
    vv = edge[i].v;
    ++d[vv];
  }
}
int main() {
  memset(head, -1, sizeof(head));
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
  }
  for (int i = 1, x, y; i <= m; ++i) {
    scanf("%d%d", &x, &y);
    addedge(y, x);
  }
  ans = 0;
  ins(a[n]);
  for (int i = n - 1; i >= 1; --i) {
    if (d[a[i]] == n - i) {
      --n;
      ++ans;
    } else {
      ins(a[i]);
    }
  }
  printf("%d", ans);
  return 0;
}
