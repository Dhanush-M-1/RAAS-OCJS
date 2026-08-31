#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10, inf = 0x3f3f3f3f;
int n, K, m, x, pos[N][2], ans, fa[N], val[N];
char s[N];
int getfa(int x) { return fa[x] == x ? x : fa[x] = getfa(fa[x]); }
void add(int x, int y) {
  int fx = getfa(x), fy = getfa(y);
  if (fx != fy) fa[fx] = fy, val[fy] += val[fx];
}
int calc(int x) { return min(val[getfa(x)], val[getfa(x + K)]); }
int main() {
  cin >> n >> K;
  scanf("%s", s + 1);
  for (int i = 1; i <= K; i++) {
    scanf("%d", &m);
    for (int j = 1; j <= m; j++) {
      scanf("%d", &x);
      if (pos[x][0])
        pos[x][1] = i;
      else
        pos[x][0] = i;
    }
  }
  for (int i = 0; i <= 2 * K + 1; i++) {
    fa[i] = i;
    if (i > K) val[i] = 1;
  }
  val[2 * K + 1] = inf;
  for (int i = 1; i <= n; i++) {
    if (!pos[i][0]) {
      printf("%d\n", ans);
      continue;
    }
    if (!pos[i][1]) {
      ans -= calc(pos[i][0]);
      if (s[i] == '1')
        add(pos[i][0] + K, 2 * K + 1);
      else
        add(pos[i][0], 2 * K + 1);
      ans += calc(pos[i][0]);
    } else {
      int x = pos[i][0], y = pos[i][1];
      if (getfa(x) != getfa(y) && getfa(x) != getfa(y + K)) {
        ans -= calc(x) + calc(y);
        if (s[i] == '1')
          add(x, y), add(x + K, y + K);
        else
          add(x, y + K), add(x + K, y);
        ans += calc(x);
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
