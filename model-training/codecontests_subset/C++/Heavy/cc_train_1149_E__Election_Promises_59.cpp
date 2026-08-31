#include <bits/stdc++.h>
using namespace std;
int n, m;
int h[200200];
struct data {
  int to, nxt;
} mp[200200];
int head[200200], cnt;
void link(int x, int y) {
  mp[++cnt].to = y;
  mp[cnt].nxt = head[x];
  head[x] = cnt;
}
int d[200200];
queue<int> q;
vector<int> nx[200200];
int id[200200];
int val[200200];
void Topsort() {
  for (int i = 1; i <= n; ++i)
    if (!d[i]) q.push(i);
  int u, v, la, siz;
  while (!q.empty()) {
    u = q.front();
    q.pop();
    sort(nx[u].begin(), nx[u].end());
    id[u] = la = -1;
    siz = nx[u].size();
    for (int i = 0; i < siz; ++i) {
      if (nx[u][i] > la + 1) {
        id[u] = la + 1;
        break;
      }
      la = nx[u][i];
    }
    if (id[u] == -1) id[u] = la + 1;
    val[id[u]] ^= h[u];
    for (int i = head[u]; i; i = mp[i].nxt) {
      v = mp[i].to;
      d[v]--;
      nx[v].push_back(id[u]);
      if (!d[v]) q.push(v);
    }
  }
}
vector<int> ed[200200];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) scanf("%d", &h[i]);
  int xx, yy;
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d", &xx, &yy);
    link(yy, xx);
    d[xx]++;
    ed[xx].push_back(yy);
  }
  Topsort();
  int fl = 0;
  for (int i = 1; i <= n; ++i)
    if (val[id[i]]) {
      fl = 1;
      break;
    }
  if (!fl) {
    puts("LOSE");
    return 0;
  }
  puts("WIN");
  int mv = 0, v;
  for (int i = 1; i <= n; ++i)
    if (val[id[i]]) mv = max(mv, id[i]);
  for (int i = 1; i <= n; ++i)
    if (id[i] == mv) {
      if ((h[i] ^ val[mv]) > h[i]) continue;
      h[i] ^= val[mv];
      for (int e = 0; e < ed[i].size(); ++e) {
        v = ed[i][e];
        h[v] ^= val[id[v]];
        val[id[v]] = 0;
      }
      break;
    }
  for (int i = 1; i <= n; ++i) printf("%d ", h[i]);
  puts("");
  return 0;
}
