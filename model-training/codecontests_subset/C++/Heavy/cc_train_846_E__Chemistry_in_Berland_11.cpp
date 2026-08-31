#include <bits/stdc++.h>
using namespace std;
int n;
long double a[100010], b[100010], w[200010], f[100010];
int cnt, head[100010], to[200010], nxt[200010];
void add(int x, int y, int z) {
  cnt++;
  to[cnt] = y;
  nxt[cnt] = head[x];
  head[x] = cnt;
  w[cnt] = z;
}
void dfs(int x) {
  for (int i = head[x]; i; i = nxt[i]) {
    int y = to[i];
    dfs(y);
    if (f[y] > 0) {
      f[x] += f[y];
    } else {
      f[x] += f[y] * w[i];
      f[y] = 0;
    }
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    cin >> b[i];
  }
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    f[i] = b[i] - a[i];
  }
  for (int i = 2; i <= n; i++) {
    int x, k;
    cin >> x >> k;
    add(x, i, k);
  }
  dfs(1);
  if (f[1] < 0) {
    puts("NO");
  } else {
    puts("YES");
  }
  return 0;
}
