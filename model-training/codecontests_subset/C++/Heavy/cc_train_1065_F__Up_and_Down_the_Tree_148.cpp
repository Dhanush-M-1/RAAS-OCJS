#include <bits/stdc++.h>
using namespace std;
struct node {
  int next, to;
} e[1000005];
int f[1000005][2], mn[1000005], head[1000005], dep[1000005], g, n, k;
int read() {
  int A;
  bool K;
  char C;
  C = A = K = 0;
  while (C < '0' || C > '9') K |= C == '-', C = getchar();
  while (C > '/' && C < ':') A = (A << 3) + (A << 1) + (C ^ 48), C = getchar();
  return (K ? -A : A);
}
inline void add(int u, int v) {
  e[++g].to = v;
  e[g].next = head[u];
  head[u] = g;
}
void dfs(int u) {
  if (!head[u]) {
    f[u][0] = f[u][1] = 1;
    mn[u] = dep[u];
    return;
  }
  int i, v;
  mn[u] = n;
  for (i = head[u]; i; i = e[i].next) {
    v = e[i].to;
    dep[v] = dep[u] + 1;
    dfs(v);
    mn[u] = ((mn[u]) < (mn[v]) ? mn[u] : mn[v]);
    if (mn[v] - dep[u] <= k)
      f[u][1] += f[v][1],
          f[u][0] =
              ((f[u][0]) > (f[v][0] - f[v][1]) ? f[u][0] : f[v][0] - f[v][1]);
    else
      f[u][0] = ((f[u][0]) > (f[v][0]) ? f[u][0] : f[v][0]);
  }
  f[u][0] += f[u][1];
}
int main() {
  int i;
  n = read(), k = read();
  for (i = 2; i <= (n); i++) add(read(), i);
  dfs(1);
  cout << f[1][0];
  return 0;
}
