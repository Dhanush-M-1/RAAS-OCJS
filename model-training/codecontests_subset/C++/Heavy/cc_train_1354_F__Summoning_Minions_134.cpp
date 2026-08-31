#include <bits/stdc++.h>
using namespace std;
const int N = 200;
const int M = 20000;
const int oo = 0X10101010;
int mym;
int S, T;
struct adj {
  int ano, cap, wei, nex;
} adj[M];
int nod[N];
void insert(int x, int y, int c, int w) {
  adj[mym].ano = y;
  adj[mym].cap = c;
  adj[mym].wei = w;
  adj[mym].nex = nod[x];
  nod[x] = mym++;
  adj[mym].ano = x;
  adj[mym].cap = 0;
  adj[mym].wei = -w;
  adj[mym].nex = nod[y];
  nod[y] = mym++;
}
bool use[N];
int dis[N], pre[N], lx[N];
int bfs() {
  int p = 0, q = 0, x, e;
  memset(use, 0, sizeof(use));
  memset(dis, 0X10, sizeof(dis));
  lx[q++] = S;
  use[S] = true;
  dis[S] = 0;
  pre[S] = -1;
  while (p != q) {
    x = lx[p++];
    p %= N;
    for (e = nod[x]; e != -1; e = adj[e].nex) {
      if (adj[e].cap > 0)
        if (adj[e].wei + dis[x] < dis[adj[e].ano]) {
          dis[adj[e].ano] = adj[e].wei + dis[x];
          pre[adj[e].ano] = e;
          if (!use[adj[e].ano]) {
            use[adj[e].ano] = true;
            lx[q++] = adj[e].ano;
            q %= N;
          }
        }
    }
    use[x] = false;
  }
  return dis[T];
}
int mincostmaxflow() {
  int ans = 0, hav, x;
  while (bfs() != oo) {
    x = T;
    hav = oo;
    while (x != S) {
      if (adj[pre[x]].cap < hav) hav = adj[pre[x]].cap;
      x = adj[pre[x] ^ 1].ano;
    }
    x = T;
    while (x != S) {
      ans += hav * adj[pre[x]].wei;
      adj[pre[x]].cap -= hav;
      adj[pre[x] ^ 1].cap += hav;
      x = adj[pre[x] ^ 1].ano;
    }
  }
  return ans;
}
vector<int> ans[80];
int tt() {
  int i = 0, j = 0, n = 0, k = 0, e = 0;
  int a[80] = {0}, b[80] = {0};
  memset(nod, 0XFF, sizeof(nod));
  mym = 0;
  scanf("%d%d", &n, &k);
  for (i = 1; i <= n; i++) {
    scanf("%d%d", a + i, b + i);
  }
  S = 0;
  T = n + k + 1 + 1;
  for (i = 0; i <= k + 1; i++) ans[i].clear();
  for (i = 1; i <= n; i++) {
    insert(S, i, 1, 0);
    for (j = 1; j <= k; j++) {
      insert(i, n + j, 1, -(a[i] + b[i] * (j - 1)));
    }
    insert(i, n + k + 1, 1, -(b[i] * (k - 1)));
  }
  for (i = 1; i <= k; i++) {
    insert(n + i, T, 1, 0);
  }
  insert(n + k + 1, T, n - k, 0);
  mincostmaxflow();
  for (i = 1; i <= n; i++) {
    for (e = nod[i]; e != -1; e = adj[e].nex) {
      if (adj[e].cap == 0) {
        ans[adj[e].ano - n].push_back(i);
      }
    }
  }
  printf("%d\n", k + 2 * (n - k));
  for (i = 1; i <= k - 1; i++) {
    printf("%d ", ans[i][0]);
  }
  for (i = 0; i < ans[k + 1].size(); i++) {
    printf("%d ", ans[k + 1][i]);
    printf("%d ", -ans[k + 1][i]);
  }
  printf("%d\n", ans[k][0]);
  return 0;
}
int main() {
  int o = 0;
  scanf("%d", &o);
  while (o--) {
    tt();
  }
  return 0;
}
