#include <bits/stdc++.h>
using namespace std;
int to[3000010], last[3000010], nxt[3000010], tot = 0;
int ru[3000010];
bool vis[3000010];
void add(int x, int y) {
  to[++tot] = y;
  nxt[tot] = last[x];
  last[x] = tot;
}
int to2[3000010], last2[3000010], nxt2[3000010], tot2 = 0;
void add2(int x, int y) {
  to2[++tot2] = y;
  nxt2[tot2] = last2[x];
  last2[x] = tot2;
  ru[y]++;
}
int siz[3000010];
void dfs(int x, int pre) {
  siz[x] = 1;
  for (int j = last[x]; j; j = nxt[j]) {
    if (to[j] != pre && to[j] != 0) {
      dfs(to[j], x);
      siz[x] += siz[to[j]];
    }
  }
  if (pre == 0) return;
  if (siz[x] % 2 == 0)
    add2(x, pre);
  else
    add2(pre, x);
}
void work(int x) {
  printf("%d\n", x);
  vis[x] = true;
  for (int j = last[x]; j; j = nxt[j]) {
    ru[to[j]]--;
    if (ru[to[j]] == 0 && vis[to[j]] == false) work(to[j]);
  }
}
int main(int argc, char const *argv[]) {
  memset(ru, 0, sizeof(ru));
  memset(last, 0, sizeof(last));
  memset(vis, false, sizeof(vis));
  int n;
  scanf("%d", &n);
  if (n % 2 == 0) {
    printf("NO\n");
    return 0;
  } else
    printf("YES\n");
  int faa;
  for (int i = 1; i <= n; ++i) {
    int x;
    scanf("%d", &x);
    add(x, i);
    add(i, x);
    if (x == 0) faa = i;
  }
  dfs(faa, 0);
  for (int i = 1; i <= n; ++i) {
    if (ru[i] == 0 && vis[i] == false) work(i);
  }
  return 0;
}
