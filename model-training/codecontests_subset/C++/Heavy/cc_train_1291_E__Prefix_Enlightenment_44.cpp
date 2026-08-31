#include <bits/stdc++.h>
using namespace std;
const int N = 6E5 + 10;
int n, k, l[N][2];
int fa[N], sc[N];
string s;
int find(int x) {
  if (x == fa[x]) return x;
  return fa[x] = find(fa[x]);
}
int cal(int x) {
  int y = x <= k ? x + k : x - k;
  int xx = find(x), yy = find(y);
  if (xx == 0 || yy == 0) return sc[xx + yy];
  return min(sc[xx], sc[yy]);
}
void merge(int x, int y) {
  int xx = find(x), yy = find(y);
  if (xx == 0)
    fa[yy] = xx, sc[xx] += sc[yy];
  else
    fa[xx] = yy, sc[yy] += sc[xx];
}
int main() {
  scanf("%d%d", &n, &k);
  cin >> s;
  for (int i = 1; i <= k; i++) fa[i] = i, fa[i + k] = i + k, sc[i + k] = 1;
  for (int i = 1, c; i <= k; i++) {
    scanf("%d", &c);
    for (int j = 0, v; j < c; j++) {
      scanf("%d", &v);
      if (l[v][0])
        l[v][1] = i;
      else
        l[v][0] = i;
    }
  }
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (l[i][1] == 0) {
      int x = l[i][0];
      if (x) {
        ans -= cal(x);
        if (s[i - 1] == '1')
          fa[find(x + k)] = 0;
        else
          fa[find(x)] = 0;
        ans += cal(x);
      }
    } else {
      int x = l[i][0], y = l[i][1];
      if (s[i - 1] == '1') {
        if (find(x) != find(y)) {
          ans -= cal(x);
          ans -= cal(y);
          merge(x, y);
          merge(x + k, y + k);
          ans += cal(x);
        }
      } else {
        if (find(x) != find(y + k)) {
          ans -= cal(x);
          ans -= cal(y);
          merge(x, y + k);
          merge(x + k, y);
          ans += cal(x);
        }
      }
    }
    cout << ans << '\n';
  }
}
