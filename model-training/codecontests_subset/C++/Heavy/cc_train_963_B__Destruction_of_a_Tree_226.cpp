#include <bits/stdc++.h>
using namespace std;
inline void read(int &x) {
  char ch;
  bool flag = false;
  for (ch = getchar(); !isdigit(ch); ch = getchar())
    if (ch == '-') flag = true;
  for (x = 0; isdigit(ch); x = x * 10 + ch - '0', ch = getchar())
    ;
  x = flag ? -x : x;
}
inline void read(long long &x) {
  char ch;
  bool flag = false;
  for (ch = getchar(); !isdigit(ch); ch = getchar())
    if (ch == '-') flag = true;
  for (x = 0; isdigit(ch); x = x * 10 + ch - '0', ch = getchar())
    ;
  x = flag ? -x : x;
}
int n, m;
int pre[610000], now[310000], son[610000], tot;
int siz[310000];
bool vis[310000];
void build(int a, int b) {
  pre[++tot] = now[a];
  now[a] = tot;
  son[tot] = b;
}
int d[310000], w;
int du[310000];
void del(int x, int fa) {
  vis[x] = 1;
  d[++w] = x;
  for (int p = now[x]; p; p = pre[p])
    if ((son[p] != fa) && (vis[son[p]] == 0)) del(son[p], x);
}
void dfs(int x, int fa) {
  int flag = 1;
  for (int p = now[x]; p; p = pre[p])
    if (son[p] != fa) {
      dfs(son[p], x);
      if (vis[son[p]] == 0) {
        siz[x] += siz[son[p]] + 1;
        if (siz[son[p]] % 2 == 1) flag = 0;
      } else
        du[x]--;
    }
  if ((flag) && (du[x] % 2 == 0)) del(x, fa);
}
int main() {
  read(n);
  for (int i = 1; i <= n; i++) {
    int a;
    read(a);
    if (a == 0) continue;
    du[i]++;
    du[a]++;
    build(i, a);
    build(a, i);
  }
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  dfs(1, 0);
  puts("YES");
  for (int i = 1; i <= w; i++) printf("%d\n", d[i]);
  return 0;
}
