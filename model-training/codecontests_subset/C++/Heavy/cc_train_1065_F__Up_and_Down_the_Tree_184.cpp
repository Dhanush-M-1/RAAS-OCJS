#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2000000;
int n, k, head[MAXN], ver[MAXN], next1[MAXN], tot, f[MAXN], num[MAXN],
    deep[MAXN];
void add(int x, int y) {
  ver[++tot] = y;
  next1[tot] = head[x];
  head[x] = tot;
}
void dfs(int x, int fa) {
  deep[x] = 10000000;
  for (int i = head[x]; i; i = next1[i]) {
    int y = ver[i];
    if (y == fa) continue;
    dfs(y, x);
    deep[x] = min(deep[x], deep[y] + 1);
    num[x] += num[y];
    f[x] = max(f[x], f[y] - num[y]);
  }
  f[x] += num[x];
  if (deep[x] == 10000000) {
    f[x] = 1;
    num[x] = 1;
    deep[x] = 0;
  }
  if (deep[x] >= k) num[x] = 0;
}
int main() {
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    int x;
    scanf("%d", &x);
    add(x, i);
  }
  dfs(1, 0);
  cout << f[1] << endl;
}
