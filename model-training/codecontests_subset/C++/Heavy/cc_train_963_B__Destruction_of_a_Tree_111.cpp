#include <bits/stdc++.h>
using namespace std;
const int N = 5e5 + 50;
int E, V[N], Next[N], Head[N];
bool vis[N];
void add(int a, int b) {
  V[E] = b;
  Next[E] = Head[a];
  Head[a] = E++;
}
bool dfs(int u, int fa) {
  bool ans = 0;
  for (int i = Head[u]; i != -1; i = Next[i]) {
    int v = V[i];
    if (v == fa) continue;
    vis[v] = dfs(v, u);
    if (!vis[v]) ans = !ans;
  }
  return ans;
}
void print(int u, int fa) {
  for (int i = Head[u]; i != -1; i = Next[i]) {
    int v = V[i];
    if (v == fa) continue;
    if (vis[v]) print(v, u);
  }
  printf("%d\n", u);
  for (int i = Head[u]; i != -1; i = Next[i]) {
    int v = V[i];
    if (v == fa) continue;
    if (!vis[v]) print(v, u);
  }
}
int main() {
  int n, rt;
  memset(Head, -1, sizeof(Head));
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int p;
    scanf("%d", &p);
    if (p == 0) {
      rt = i;
      continue;
    }
    add(i, p), add(p, i);
  }
  if (!dfs(rt, -1)) {
    puts("YES");
    print(rt, -1);
  } else
    puts("NO");
}
