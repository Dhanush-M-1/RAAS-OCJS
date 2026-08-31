#include <bits/stdc++.h>
using namespace std;
const int MAXN = 810000;
int fa[MAXN], val[MAXN], vec[MAXN][3];
int n, k, ans;
char str[MAXN];
int getfa(int x) {
  if (fa[x] == x) return x;
  return fa[x] = getfa(fa[x]);
}
void merge(int x, int y) {
  int p = getfa(x), q = getfa(y);
  if (p == q) return;
  fa[p] = q;
  val[q] += val[p];
}
int getval(int x) { return min(val[getfa(x)], val[getfa(x + k)]); }
int main() {
  scanf("%d%d%s", &n, &k, str + 1);
  int tc;
  for (int i = 1; i <= k; i++) {
    scanf("%d", &tc);
    int tx;
    for (int j = 1; j <= tc; j++) {
      scanf("%d", &tx);
      vec[tx][++vec[tx][0]] = i;
    }
  }
  for (int i = 1; i <= k; i++) fa[i] = i, val[i] = 0;
  for (int i = k + 1; i <= 2 * k; i++) fa[i] = i, val[i] = 1;
  fa[k << 1 | 1] = k << 1 | 1;
  val[k << 1 | 1] = 1000000;
  for (int i = 1; i <= n; i++) {
    if (vec[i][0] == 2) {
      if (str[i] == '0') {
        if (getfa(vec[i][1]) != getfa(vec[i][2] + k)) {
          ans -= getval(vec[i][1]) + getval(vec[i][2]);
          merge(vec[i][1], vec[i][2] + k);
          merge(vec[i][1] + k, vec[i][2]);
          ans += getval(vec[i][1]);
        }
      } else {
        if (getfa(vec[i][1]) != getfa(vec[i][2])) {
          ans -= getval(vec[i][1]) + getval(vec[i][2]);
          merge(vec[i][1] + k, vec[i][2] + k);
          merge(vec[i][1], vec[i][2]);
          ans += getval(vec[i][1]);
        }
      }
    } else if (vec[i][0] == 1) {
      if (str[i] == '0') {
        ans -= getval(vec[i][1]);
        merge(vec[i][1], k << 1 | 1);
        ans += getval(vec[i][1]);
      } else {
        ans -= getval(vec[i][1]);
        merge(vec[i][1] + k, k << 1 | 1);
        ans += getval(vec[i][1]);
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
