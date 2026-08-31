#include <bits/stdc++.h>
using namespace std;
int d[200003];
int dd[200003];
bool vis[200003];
int siz[200003];
int f[200003];
int ans[200003];
queue<int> q;
int n, rt, sum;
struct Edge {
  int to, next;
} edge[400003];
int head[200003];
int cnt;
void init() {
  memset(head, -1, sizeof(head));
  cnt = 0;
}
void add(int u, int v) {
  edge[cnt].to = v;
  edge[cnt].next = head[u];
  head[u] = cnt++;
}
void getrt(int u, int fa) {
  siz[u] = 1;
  f[u] = 0;
  bool flag = true;
  for (int i = head[u]; ~i; i = edge[i].next) {
    if (edge[i].to != fa && !vis[edge[i].to]) {
      getrt(edge[i].to, u);
      siz[u] += siz[edge[i].to];
      f[u] = max(f[u], siz[edge[i].to]);
      if (siz[edge[i].to] % 2 == 0) {
        dd[u]++;
        flag = false;
      }
    }
  }
  f[u] = max(f[u], sum - siz[u]);
  if (sum - siz[u] != 0 && (sum - siz[u]) % 2 == 0) dd[u]++;
  if (d[u] % 2 == 0 && flag) q.push(u);
}
void solve(int u) {
  vis[u] = true;
  printf("%d\n", u);
  for (int i = head[u]; ~i; i = edge[i].next) {
    dd[edge[i].to]--;
    if (dd[edge[i].to] == 0) q.push(edge[i].to);
  }
}
int main() {
  init();
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int v;
    scanf("%d", &v);
    if (v) {
      add(v, i);
      add(i, v);
      d[v]++;
      d[i]++;
    }
  }
  if (n % 2 == 0) {
    printf("NO\n");
  } else {
    f[0] = n + 1, sum = n;
    printf("YES\n");
    getrt(1, 0);
    while (!q.empty()) {
      rt = q.front();
      q.pop();
      solve(rt);
    }
  }
}
