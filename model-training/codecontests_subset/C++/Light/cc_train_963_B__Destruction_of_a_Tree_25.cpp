#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
int tot, z;
int head[1000010];
struct node {
  int from;
  int to;
  int w;
  int next;
} edge[1000010];
void add(int from, int to, int w) {
  edge[tot].from = from;
  edge[tot].to = to;
  edge[tot].w = w;
  edge[tot].next = head[from];
  head[from] = tot++;
}
int vis[200100];
int deg[200100];
int ans[200100];
int n, tt, root;
void des(int p, int pre) {
  vis[p] = 1;
  ans[tt++] = p;
  for (int i = head[p]; i != -1; i = edge[i].next) {
    int v = edge[i].to;
    deg[v]--;
    if (v == pre) continue;
    if (vis[v] == 0) {
      if (deg[v] % 2 == 0) {
        des(v, p);
      }
    }
  }
}
bool dfs(int Q, int P) {
  bool Ok = deg[Q] & 1;
  for (int i = head[Q]; i != -1; i = edge[i].next) {
    int v = edge[i].to;
    if (v != P) Ok ^= dfs(v, Q);
  }
  if (!Ok) des(Q, P);
  return !Ok;
}
int main() {
  memset(head, -1, sizeof(head));
  tot = 0;
  tt = 0;
  memset(ans, 0, sizeof(ans));
  memset(deg, 0, sizeof(deg));
  memset(vis, 0, sizeof(vis));
  cin >> n;
  if (n % 2 == 0) {
    cout << "NO" << endl;
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    int aa;
    cin >> aa;
    if (aa == 0) {
      root = i;
      continue;
    }
    add(aa, i, 0);
    add(i, aa, 0);
    deg[aa]++;
    deg[i]++;
  }
  cout << "YES" << endl;
  dfs(root, 0);
  for (int i = 0; i < tt; i++) cout << ans[i] << endl;
  return 0;
}
