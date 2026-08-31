#include <bits/stdc++.h>
using namespace std;
const int MAXN = 3005;
vector<int> p[MAXN];
int n;
double ans = 0;
bool instack[MAXN];
int rd[MAXN];
int circle;
int q[MAXN];
inline void TopSort() {
  for (int i = (0); i <= (int)n - 1; i++)
    if (rd[i] == 1) q[++q[0]] = i;
  for (int i = (1); i <= (int)q[0]; i++) {
    int x = q[i];
    for (int j = (0); j <= (int)p[x].size() - 1; j++)
      if ((--rd[p[x][j]]) == 1) q[++q[0]] = p[x][j];
  }
  circle = n - q[0];
}
int d1[MAXN], d2[MAXN];
void dfs(int x, int d) {
  if (!d1[x])
    d1[x] = d;
  else
    d2[x] = d;
  instack[x] = 1;
  for (int i = (0); i <= (int)p[x].size() - 1; i++)
    if (!instack[p[x][i]]) dfs(p[x][i], d + 1);
  instack[x] = 0;
}
int main() {
  scanf("%d", &n);
  for (int i = (1); i <= (int)n; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    p[a].push_back(b);
    p[b].push_back(a);
    rd[a]++;
    rd[b]++;
  }
  TopSort();
  for (int i = (0); i <= (int)n - 1; i++) {
    memset(d1, 0, sizeof d1);
    memset(d2, 0, sizeof d2);
    dfs(i, 1);
    for (int j = (0); j <= (int)n - 1; j++)
      if (!d2[j])
        ans += 1. / d1[j];
      else
        ans += (1. / d1[j]) + (1. / d2[j]) -
               (1. / ((d1[j] + d2[j] + circle - 2) / 2));
  }
  printf("%.10lf\n", ans);
  return 0;
}
