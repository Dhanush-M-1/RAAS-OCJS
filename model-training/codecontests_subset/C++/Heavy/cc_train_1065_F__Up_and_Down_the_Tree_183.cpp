#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
int vet[N], nxt[N], head[N], num;
int cest[N], d[N], sum[N], n, k, is[N], x, ans;
inline int read() {
  int s = 0, f = 1;
  char c = getchar();
  while (!isdigit(c)) f = c == '-' ? -1 : 1, c = getchar();
  while (isdigit(c)) s = (s << 3) + (s << 1) + c - '0', c = getchar();
  return s * f;
}
void add(int xx, int yy) {
  vet[++num] = yy;
  nxt[num] = head[xx];
  head[xx] = num;
}
void dfs(int t, int dep) {
  cest[t] = 1e9;
  d[t] = dep;
  if (!is[t]) cest[t] = dep, sum[t] = 1;
  for (register int i = head[t]; i; i = nxt[i]) {
    int v = vet[i];
    dfs(v, dep + 1);
    cest[t] = min(cest[t], cest[v]);
    if (cest[v] <= k + d[t]) sum[t] += sum[v], sum[v] = 0;
  }
}
int getsum(int t) {
  int temp = 0;
  for (register int i = head[t]; i; i = nxt[i])
    temp = max(temp, getsum(vet[i]));
  temp += sum[t];
  return temp;
}
int main() {
  n = read();
  k = read();
  for (register int i = 1; i < n; i++) x = read(), add(x, i + 1), is[x] = 1;
  dfs(1, 0);
  printf("%d", getsum(1));
  return 0;
}
