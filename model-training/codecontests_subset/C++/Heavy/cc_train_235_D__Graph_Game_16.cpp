#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int to, next;
} e[6060];
int point[3030], te = 1;
void addE(int st, int ed) {
  te++;
  e[te].to = ed;
  e[te].next = point[st];
  point[st] = te;
}
int ind[3030];
queue<int> q;
int ter, cir;
int vis[3030], dis[3030], dis2[3030];
double ans;
void dfs(int now) {
  vis[now] = 1;
  for (int i = point[now]; i; i = e[i].next) {
    int who = e[i].to;
    if (vis[who]) continue;
    dis2[who] = dis2[now] + 1;
    if (!dis[who]) {
      dis[who] = dis[now] + 1;
      ans += 1. / dis[who];
    } else {
      ans += 1. / dis2[who] - 2. / (dis[who] + dis2[who] + cir - 2);
    }
    dfs(who);
  }
  vis[now] = 0;
}
int n;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int u, v;
    cin >> u >> v;
    addE(u, v);
    addE(v, u);
    ind[u]++, ind[v]++;
  }
  for (int i = 0; i < n; i++) {
    if (ind[i] == 1) q.push(i);
  }
  ter = q.size();
  while (!q.empty()) {
    int now = q.front();
    q.pop();
    for (int i = point[now]; i; i = e[i].next) {
      int who = e[i].to;
      ind[who]--;
      if (ind[who] == 1) q.push(who), ter++;
    }
  }
  cir = n - ter;
  for (int i = 0; i < n; i++) {
    memset(vis, 0, sizeof(vis));
    memset(dis, 0, sizeof(dis));
    memset(dis2, 0, sizeof(dis2));
    dis[i] = dis2[i] = 1;
    dfs(i);
  }
  cout << fixed << setprecision(10) << ans + n << endl;
  return 0;
}
