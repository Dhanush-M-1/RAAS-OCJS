#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int x, y;
} E[200010];
struct edge {
  int nxt, t, s;
} e[200010 << 1];
int head[200010], edge_cnt;
void add_edge(int x, int y, int z) {
  e[edge_cnt] = (edge){head[x], y, z};
  head[x] = edge_cnt++;
}
bool ban[200010];
int Deg[200010], Q[200010], Ans[200010];
int main() {
  memset(head, -1, sizeof(head));
  int n, m, K, i, j;
  scanf("%d%d%d", &n, &m, &K);
  for (i = 1; i <= m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    add_edge(x, y, i);
    add_edge(y, x, i);
    E[i] = (Edge){x, y};
    Deg[x]++, Deg[y]++;
  }
  int L = 1, R = 0;
  for (i = 1; i <= n; i++) {
    if (Deg[i] < K) {
      Q[++R] = i;
      ban[i] = 1;
    }
  }
  for (i = m; i >= 1; i--) {
    while (L <= R) {
      int x = Q[L++];
      for (j = head[x]; ~j; j = e[j].nxt) {
        int y = e[j].t;
        if (ban[y] || e[j].s > i) {
          continue;
        }
        Deg[y]--;
        if (Deg[y] < K) {
          Q[++R] = y;
          ban[y] = 1;
        }
      }
    }
    Ans[i] = n - R;
    int a = E[i].x, b = E[i].y;
    if (ban[a] || ban[b]) {
      continue;
    }
    Deg[a]--, Deg[b]--;
    if (Deg[a] < K) {
      Q[++R] = a;
      ban[a] = 1;
    }
    if (Deg[b] < K) {
      Q[++R] = b;
      ban[b] = 1;
    }
  }
  for (i = 1; i <= m; i++) {
    printf("%d\n", Ans[i]);
  }
  return 0;
}
