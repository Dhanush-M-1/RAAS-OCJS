#include <bits/stdc++.h>
using namespace std;
const int maxn = (int)3e5 + 10;
int par[maxn << 1], num[maxn << 1];
inline void makeSet(int size) {
  for (int i = 1; i <= size; i++) {
    par[i] = i;
  }
}
inline int find(int x) {
  int k, j, r;
  r = x;
  while (r != par[r]) {
    r = par[r];
  }
  k = x;
  while (k != r) {
    j = par[k];
    par[k] = r;
    k = j;
  }
  return r;
}
inline void unite(int x, int y) {
  x = find(x);
  y = find(y);
  if (x == y) {
    return;
  }
  par[x] = y;
  num[y] += num[x];
}
inline int calc(int x, int k) { return min(num[find(x)], num[find(x + k)]); }
int belong[maxn][2];
char s[maxn];
int main() {
  int n, k, c, tmp;
  scanf("%d%d%s", &n, &k, s + 1);
  for (int i = 1; i <= k; ++i) {
    scanf("%d", &c);
    for (int j = 0; j < c; ++j) {
      scanf("%d", &tmp);
      if (belong[tmp][0]) {
        belong[tmp][1] = i;
      } else {
        belong[tmp][0] = i;
      }
    }
    num[i] = 1;
  }
  makeSet(k << 1 | 1);
  num[k << 1 | 1] = 0x3f3f3f3f;
  int ans = 0;
  for (int i = 1; i <= n; ++i) {
    if (belong[i][1]) {
      if (s[i] == '0' && find(belong[i][0]) != find(belong[i][1] + k)) {
        ans -= calc(belong[i][0], k) + calc(belong[i][1], k);
        unite(belong[i][0], belong[i][1] + k);
        unite(belong[i][1], belong[i][0] + k);
        ans += calc(belong[i][0], k);
      } else if (s[i] == '1' && find(belong[i][0]) != find(belong[i][1])) {
        ans -= calc(belong[i][0], k) + calc(belong[i][1], k);
        unite(belong[i][0], belong[i][1]);
        unite(belong[i][0] + k, belong[i][1] + k);
        ans += calc(belong[i][0], k);
      }
    } else if (belong[i][0]) {
      ans -= calc(belong[i][0], k);
      if (s[i] == '0') {
        unite(belong[i][0] + k, k << 1 | 1);
      } else {
        unite(belong[i][0], k << 1 | 1);
      }
      ans += calc(belong[i][0], k);
    }
    printf("%d\n", ans);
  }
  return 0;
}
