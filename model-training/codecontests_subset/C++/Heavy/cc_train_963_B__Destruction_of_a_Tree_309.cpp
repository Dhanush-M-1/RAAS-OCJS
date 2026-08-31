#include <bits/stdc++.h>
using namespace std;
const int M = 200010;
int n, root;
int fa[M];
template <typename T>
inline void read(T &x) {
  x = 0;
  char ch = getchar();
  int f = 1;
  for (; ch < '0' || ch > '9'; ch = getchar())
    if (ch == '-') f = -1;
  for (; ch >= '0' && ch <= '9'; ch = getchar()) x = x * 10 + ch - '0';
  x *= f;
}
int head[M], tot = 0;
struct edge {
  int to, next;
} e[M];
inline void add(int u, int v) {
  e[++tot] = (edge){v, head[u]};
  head[u] = tot;
}
int size[M];
void get_size(int pos) {
  size[pos] = 1;
  for (int i = head[pos]; i; i = e[i].next)
    get_size(e[i].to), size[pos] += size[e[i].to];
}
void dfs(int pos) {
  for (int i = head[pos], v; i; i = e[i].next)
    if (size[v = e[i].to] % 2 == 0) dfs(e[i].to);
  printf("%d\n", pos);
  for (int i = head[pos], v; i; i = e[i].next)
    if (size[v = e[i].to] % 2 == 1) dfs(e[i].to);
}
int main() {
  read(n);
  if (n % 2 == 0) return printf("NO\n"), 0;
  for (int i = 1; i <= n; i++) {
    read(fa[i]);
    if (fa[i])
      add(fa[i], i);
    else
      root = i;
  }
  get_size(root);
  printf("YES\n");
  dfs(root);
  return 0;
}
