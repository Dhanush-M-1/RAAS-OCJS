#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> m1;
vector<int> v[100010];
int fx[] = {-1, 0, -1, -1};
int fy[] = {0, -1, 1, -1};
struct ss {
  int r;
  int c1;
  int c2;
};
ss st[100010];
bool cmp(ss a, ss b) {
  if (a.r != b.r)
    return a.r < b.r;
  else {
    if (a.c1 != b.c1)
      return a.c1 < b.c1;
    else
      return a.c2 < b.c2;
  }
}
bool vis[100010];
int dis[100010];
int bfs(int s, int d) {
  memset(vis, 0, sizeof(vis));
  memset(dis, -1, sizeof(dis));
  vis[s] = 1;
  dis[s] = 0;
  queue<int> q;
  q.push(s);
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    for (int i = 0; i < v[u].size(); i++) {
      int j = v[u][i];
      if (!vis[j]) {
        vis[j] = 1;
        dis[j] = dis[u] + 1;
        if (j == d) return dis[j];
        q.push(j);
      }
    }
  }
  return -1;
}
int main() {
  int sx, sy, dx, dy;
  scanf("%d%d", &sx, &sy);
  scanf("%d%d", &dx, &dy);
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int r, c1, c2;
    scanf("%d%d%d", &r, &c1, &c2);
    st[i].r = r;
    st[i].c1 = c1;
    st[i].c2 = c2;
  }
  sort(st, st + n, cmp);
  int ct = 1;
  for (int i = 0; i < n; i++) {
    int row = st[i].r;
    for (int j = st[i].c1; j <= st[i].c2; j++) {
      int col = j;
      if (m1[make_pair(row, col)] > 0) continue;
      m1[make_pair(row, col)] = ct;
      for (int k = 0; k < 4; k++) {
        int x = row + fx[k];
        int y = col + fy[k];
        int cnt = m1[make_pair(x, y)];
        if (cnt > 0) {
          v[ct].push_back(cnt);
          v[cnt].push_back(ct);
        }
      }
      ct++;
    }
  }
  int s = m1[make_pair(sx, sy)];
  int d = m1[make_pair(dx, dy)];
  int ans = bfs(s, d);
  printf("%d", ans);
}
