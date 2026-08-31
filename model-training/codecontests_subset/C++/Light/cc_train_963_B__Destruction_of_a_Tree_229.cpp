#include <bits/stdc++.h>
using namespace std;
int n, tot, e[500001], nt[500001], hd[500001], sz[500001];
void build(int x, int y) {
  tot++;
  e[tot] = y;
  nt[tot] = hd[x];
  hd[x] = tot;
}
void dfs(int x, int fa) {
  int i;
  sz[x] = 1;
  for (i = hd[x]; i; i = nt[i]) {
    if (e[i] == fa) continue;
    dfs(e[i], x);
    sz[x] += sz[e[i]];
  }
}
void get(int x, int fa) {
  int i;
  for (i = hd[x]; i; i = nt[i]) {
    if (e[i] == fa) continue;
    if (sz[e[i]] % 2 == 0) get(e[i], x);
  }
  printf("%d\n", x);
  for (i = hd[x]; i; i = nt[i]) {
    if (e[i] == fa) continue;
    if (sz[e[i]] % 2 == 1) get(e[i], x);
  }
}
int main() {
  int i, x;
  scanf("%d", &n);
  if (n % 2 == 0) return puts("NO"), 0;
  for (i = 1; i <= n; i++) {
    scanf("%d", &x);
    if (x) build(x, i), build(i, x);
  }
  dfs(1, 0);
  puts("YES");
  get(1, 0);
}
