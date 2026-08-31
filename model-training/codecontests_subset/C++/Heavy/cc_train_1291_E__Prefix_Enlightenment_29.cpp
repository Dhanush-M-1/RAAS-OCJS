#include <bits/stdc++.h>
using namespace std;
int n, k;
char s[300005];
vector<int> bel[300005];
int fa[300005 * 2], val[300005 * 2];
int getfa(int now) { return fa[now] == now ? now : fa[now] = getfa(fa[now]); }
int getans(int now) {
  int now2;
  if (now <= k)
    now2 = k + now;
  else
    now2 = now - k;
  int xx = getfa(now), yy = getfa(now2);
  if (xx == 0 || yy == 0) return val[xx + yy];
  return min(val[xx], val[yy]);
}
void merge(int x, int y) {
  int xx = getfa(x), yy = getfa(y);
  if (xx == yy) return;
  if (yy == 0) swap(xx, yy);
  fa[yy] = xx;
  if (xx != 0) val[xx] += val[yy];
}
int main() {
  scanf("%d%d", &n, &k);
  scanf("%s", s + 1);
  for (int i = 1; i <= k; i++) {
    int c;
    scanf("%d", &c);
    for (int j = 1; j <= c; j++) {
      int x;
      scanf("%d", &x);
      bel[x].push_back(i);
    }
    fa[i] = i;
    fa[i + k] = i + k;
    val[i + k] = 1;
  }
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    int len = bel[i].size();
    if (len == 0) {
      printf("%d\n", ans);
      continue;
    }
    if (len == 1) {
      int now = bel[i][0];
      ans -= getans(now);
      if (s[i] == '1')
        fa[getfa(now + k)] = 0;
      else
        fa[getfa(now)] = 0;
      ans += getans(now);
    }
    if (len == 2) {
      int now1 = bel[i][0];
      int now2 = bel[i][1];
      if (s[i] == '1') {
        if (getfa(now1) != getfa(now2)) {
          ans -= getans(now1);
          ans -= getans(now2);
          merge(now1, now2);
          merge(now1 + k, now2 + k);
          ans += getans(now1);
        }
      } else {
        if (getfa(now1 + k) != getfa(now2)) {
          ans -= getans(now1);
          ans -= getans(now2);
          merge(now1 + k, now2);
          merge(now1, now2 + k);
          ans += getans(now1);
        }
      }
    }
    printf("%d\n", ans);
  }
}
