#include <bits/stdc++.h>
using namespace std;
int T, n, m, i, j, k, l, rt, sum;
int a[200001][2], ls[100001], len;
int d[100001], Sum[100001], fa[100001], Fa[100001], dp[100001], tot;
bool bz[100001], bzin[100001], bz2[200001], ans[100001], Bz;
int Id[100001];
namespace G {
int a[1000001][2], ls[100001], len;
void clear() {
  len = 0;
  memset(ls, 0, (n + 1) * 4);
}
void New(int x, int y) {
  ++len;
  a[len][0] = y;
  a[len][1] = ls[x];
  ls[x] = len;
}
void bfs(int st) {
  int i, j, k, l, h = 0, t = 1;
  static int d[100001];
  d[1] = st;
  ans[st] = 1;
  while (h < t) {
    for (i = ls[d[++h]]; i; i = a[i][1])
      if (!ans[a[i][0]]) {
        ans[a[i][0]] = 1;
        d[++t] = a[i][0];
      }
  }
}
}  // namespace G
void New(int x, int y) {
  ++len;
  a[len][0] = y;
  a[len][1] = ls[x];
  ls[x] = len;
}
void dfs(int t) {
  int i;
  bz[t] = 1;
  d[++tot] = t;
  bzin[t] = 1;
  for (i = ls[t]; i; i = a[i][1])
    if (!bz[a[i][0]])
      dfs(a[i][0]);
    else if (!bzin[a[i][0]])
      Bz = 0;
  --tot;
  bzin[t] = 0;
}
void Dfs(int t) {
  int i;
  bz[t] = 1;
  for (i = ls[t]; i; i = a[i][1])
    if (!bz[a[i][0]])
      dp[a[i][0]] = dp[t] + 1, fa[a[i][0]] = t, bz2[i] = 1, Dfs(a[i][0]),
      Sum[t] += Sum[a[i][0]];
    else
      ++Sum[t], --Sum[a[i][0]];
}
void Dfs2(int t, int Ls) {
  int i;
  Fa[t] = Ls;
  for (i = ls[t]; i; i = a[i][1])
    if (bz2[i]) Dfs2(a[i][0], Sum[t] == 1 ? t : Ls);
}
bool pd(int t) {
  int i;
  memset(bz, 0, n + 1);
  Bz = 1;
  dfs(t);
  return Bz;
}
int main() {
  srand(time(NULL));
  scanf("%d", &T);
  for (; T; --T) {
    scanf("%d%d", &n, &m);
    len = 0;
    memset(ls, 0, (n + 1) * 4);
    memset(ans, 0, n + 1);
    memset(bz2, 0, m + 1);
    memset(Sum, 0, (n + 1) * 4);
    for (i = 1; i <= m; i++) scanf("%d%d", &j, &k), New(j, k);
    for (i = 1; i <= n; i++) Id[i] = i;
    random_shuffle(Id + 1, Id + n + 1);
    l = (100 < n ? 100 : n);
    for (i = 1; i <= l; i++)
      if (pd(Id[i])) break;
    if (i > l)
      printf("-1\n");
    else {
      rt = Id[i];
      sum = 0;
      fa[rt] = Fa[rt] = 0;
      dp[rt] = 1;
      memset(bz, 0, n + 1);
      Dfs(rt);
      Dfs2(rt, 0);
      G::clear();
      for (i = 1; i <= n; i++) {
        for (l = ls[i]; l; l = a[l][1])
          if (dp[a[l][0]] < dp[i]) {
            j = i;
            while (dp[j] > dp[a[l][0]]) {
              if (Sum[j] == 1) G::New(a[l][0], j);
              j = Fa[j];
            }
          }
      }
      G::bfs(rt);
      for (i = 1; i <= n; i++) sum += ans[i];
      if (sum < (double)n / 5)
        printf("-1\n");
      else {
        for (i = 1; i <= n; i++)
          if (ans[i]) printf("%d ", i);
        printf("\n");
      }
    }
  }
  fclose(stdin);
  fclose(stdout);
  return 0;
}
