#include <bits/stdc++.h>
using namespace std;
;
const double eps = 1e-8;
const int mod = 1e9 + 7;
const int maxn = 3e5 + 5;
const int INF = 0x3f3f3f3f;
const long long INFLL = 0x3f3f3f3f3f3f3f3f;
struct EDGE {
  int v, nxt;
} edge[maxn << 1];
int head[maxn], tot;
void add_edge(int u, int v) {
  edge[tot].v = v, edge[tot].nxt = head[u], head[u] = tot++;
}
int degree[maxn];
int main() {
  memset(head, -1, sizeof(head));
  tot = 0;
  int n;
  scanf("%d", &n);
  for (int i = 1, u, v; i < n; i++) {
    scanf("%d%d", &u, &v);
    degree[u]++;
    degree[v]++;
  }
  bool flag = true;
  for (int i = 1; i <= n; i++) {
    if (degree[i] == 2) {
      flag = false;
    }
  }
  if (flag) {
    printf("YES\n");
  } else {
    printf("NO\n");
  }
  return 0;
}
