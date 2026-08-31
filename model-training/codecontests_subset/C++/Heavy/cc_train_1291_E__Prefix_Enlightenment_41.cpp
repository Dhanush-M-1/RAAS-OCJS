#include <bits/stdc++.h>
using namespace std;
const int maxn = 6e5 + 10;
int n, k, l[maxn][2];
int fa[maxn], sz[maxn];
string s;
int get_fa(int x) {
  if (x == fa[x]) return x;
  return fa[x] = get_fa(fa[x]);
}
int calc(int x) {
  int y;
  if (x <= k)
    y = x + k;
  else
    y = x - k;
  x = get_fa(x), y = get_fa(y);
  if (x == 0 || y == 0) return sz[x + y];
  return min(sz[x], sz[y]);
}
void merge_dis(int x, int y) {
  x = get_fa(x);
  y = get_fa(y);
  if (y == 0) {
    swap(x, y);
  }
  fa[y] = x;
  if (x != 0) sz[x] += sz[y];
}
int main() {
  scanf("%d%d", &n, &k);
  cin >> s;
  for (int i = 1; i <= (int)3e5; i++)
    fa[i] = i, fa[i + k] = i + k, sz[i + k] = 1;
  for (int i = 1, c; i <= k; i++) {
    scanf("%d", &c);
    for (int j = 0, x; j < c; j++) {
      scanf("%d", &x);
      if (l[x][0] == 0)
        l[x][0] = i;
      else
        l[x][1] = i;
    }
  }
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (l[i][1] == 0) {
      int x = l[i][0];
      if (x) {
        ans -= calc(x);
        if (s[i - 1] == '1')
          fa[get_fa(x + k)] = 0;
        else
          fa[get_fa(x)] = 0;
        ans += calc(x);
      }
    } else {
      int x = l[i][0], y = l[i][1];
      if (s[i - 1] == '1') {
        if (get_fa(x) != get_fa(y)) {
          ans -= calc(x);
          ans -= calc(y);
          merge_dis(x, y);
          merge_dis(x + k, y + k);
          ans += calc(x);
        }
      } else {
        if (get_fa(x + k) != get_fa(y)) {
          ans -= calc(x);
          ans -= calc(y);
          merge_dis(x + k, y);
          merge_dis(x, y + k);
          ans += calc(x);
        }
      }
    }
    cout << ans << endl;
  }
  return 0;
}
