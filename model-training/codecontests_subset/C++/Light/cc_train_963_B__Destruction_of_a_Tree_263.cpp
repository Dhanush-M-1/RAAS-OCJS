#include <bits/stdc++.h>
#pragma GCC optimize(3)
using namespace std;
int n, root, tag[300000], fa[300000];
vector<int> G[300000];
stack<int> S;
int DFS(int now) {
  int chi = G[now].size() - 1;
  int cnt = 0;
  for (int i = 0; i <= chi; ++i) {
    int to = G[now][i];
    if (to == fa[now]) continue;
    int now = DFS(to);
    cnt += now;
  }
  if (cnt & 1 && !fa[now]) {
    printf("NO\n");
    exit(0);
  }
  if (cnt & 1 || (!(cnt & 1) && !fa[now])) {
    tag[now] = 1;
    S.push(now);
    return 0;
  } else
    return 1;
}
void DFS2(int now) {
  tag[now] = 1;
  for (int i = 0; i < (int)G[now].size(); i++) {
    if (G[now][i] == fa[now] || !tag[G[now][i]]) continue;
    DFS2(G[now][i]);
  }
  printf("%d\n", now);
  for (int i = 0; i < (int)G[now].size(); i++) {
    if (G[now][i] == fa[now] || tag[G[now][i]]) continue;
    DFS2(G[now][i]);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", fa + i);
    if (!fa[i]) {
      root = i;
      continue;
    }
    G[i].push_back(fa[i]);
    G[fa[i]].push_back(i);
  }
  DFS(root);
  if (!S.size()) return 0 * puts("NO");
  printf("YES\n");
  DFS2(root);
  return 0;
}
