#include <bits/stdc++.h>
using namespace std;
const int N = 2e5, M = 4e5;
int head[N + 10], ver[M + 10], nxt[M + 10], tot, sz[N + 10];
void add(int x, int y) {
  ver[++tot] = y;
  nxt[tot] = head[x];
  head[x] = tot;
  ver[++tot] = x;
  nxt[tot] = head[y];
  head[y] = tot;
}
void dfs1(int x, int fa) {
  sz[x] = 1;
  for (int i = head[x]; i; i = nxt[i]) {
    int y = ver[i];
    if (y == fa) continue;
    dfs1(y, x);
    sz[x] += sz[y];
  }
}
int ans[N + 10], cnt = 0;
void dfs2(int x, int fa) {
  vector<int> odd, even;
  for (int i = head[x]; i; i = nxt[i]) {
    int y = ver[i];
    if (y == fa) continue;
    if (sz[y] & 1)
      odd.push_back(y);
    else
      even.push_back(y);
  }
  for (int i = 0; i < even.size(); i++) {
    int y = even[i];
    dfs2(y, x);
  }
  ans[++cnt] = x;
  for (int i = 0; i < odd.size(); i++) {
    int y = odd[i];
    dfs2(y, x);
  }
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    if (!x) continue;
    add(i, x);
  }
  dfs1(1, -1);
  if (!(sz[1] & 1))
    printf("NO");
  else {
    printf("YES\n");
    dfs2(1, -1);
    for (int i = 1; i <= cnt; i++) printf("%d\n", ans[i]);
  }
  return 0;
}
