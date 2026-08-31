#include <bits/stdc++.h>
using namespace std;
int F() {
  char ch;
  int x, a;
  while (ch = getchar(), (ch < '0' || ch > '9') && ch != '-')
    ;
  if (ch == '-')
    ch = getchar(), a = -1;
  else
    a = 1;
  x = ch - '0';
  while (ch = getchar(), ch >= '0' && ch <= '9')
    x = (x << 1) + (x << 3) + ch - '0';
  return a * x;
}
int n;
int fa[200010], in[200010];
set<int> edge[200010];
int deg(int u) { return in[fa[u]] + ((int)(edge[u]).size()); }
int stk[200010], cnt;
int del[200010], tp;
void clear(int u) {
  stk[++cnt] = u;
  in[u] = 0;
  if (fa[u]) del[++tp] = u;
  for (auto v : edge[u]) clear(v);
}
void dfs(int u) {
  while (tp) {
    int x = del[tp--];
    if (fa[x]) edge[fa[x]].erase(x);
  }
  for (auto v : edge[u]) dfs(v);
  while (tp) {
    int x = del[tp--];
    if (fa[x]) edge[fa[x]].erase(x);
  }
  if (!in[u]) return;
  if (deg(u) & 1) return;
  clear(u);
}
int main() {
  ((n) = F());
  for (int i = 1; i <= n; ++i) {
    ((fa[i]) = F());
    in[i] = 1;
    if (fa[i]) edge[fa[i]].insert(i);
  }
  for (int i = 1; i <= n; ++i)
    if (!fa[i]) dfs(i);
  if (cnt != n) return puts("NO"), 0;
  puts("YES");
  for (int i = 1; i <= n; ++i) printf("%d\n", stk[i]);
  return 0;
}
