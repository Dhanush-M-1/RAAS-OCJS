#include <bits/stdc++.h>
using namespace std;
const int maxn = 100000 + 5;
const long long inf = (1ll << 60) - 1;
vector<int> g[maxn];
long long a[maxn], b[maxn];
long long k[maxn];
int n;
int fa[maxn];
bool flag = true;
void handle(int v, int pa) {
  if (!flag) return;
  for (int i = 0; i < (int)g[v].size(); i++) {
    int u = g[v][i];
    if (u != pa) handle(u, v);
  }
  if (pa == -1) {
    if (b[v] >= a[v])
      return;
    else {
      flag = false;
      return;
    }
  } else {
    if (b[v] - a[v] >= 0)
      b[pa] += b[v] - a[v], b[v] = a[v];
    else {
      long long del = 0;
      if (a[v] - b[v] > inf)
        del = inf;
      else
        del = (a[v] - b[v]) * k[v];
      b[v] = a[v];
      if (del >= inf)
        b[pa] = -inf;
      else
        b[pa] -= del;
      if (b[pa] < -inf) b[pa] = -inf;
    }
  }
}
void out() {
  printf("a:\n");
  for (int i = 1; i <= n; i++) printf("%I64d ", a[i]);
  puts("");
  printf("b:\n");
  for (int i = 1; i <= n; i++) printf("%I64d ", b[i]);
  puts("");
}
int main() {
  scanf("%d", &n);
  long long sumb = 0, suma = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%I64d", &b[i]);
    sumb += b[i];
  }
  for (int i = 1; i <= n; i++) {
    scanf("%I64d", &a[i]);
    suma += a[i];
  }
  if (sumb < suma) {
    printf("NO\n");
    exit(0);
  }
  for (int i = 2; i <= n; i++) {
    int x;
    scanf("%d%I64d", &x, &k[i]);
    fa[i] = x;
    g[x].push_back(i);
    g[i].push_back(x);
  }
  handle(1, -1);
  if (flag) {
    printf("YES\n");
  } else
    printf("NO\n");
  return 0;
}
