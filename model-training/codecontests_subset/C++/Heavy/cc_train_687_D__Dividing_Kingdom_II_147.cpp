#include <bits/stdc++.h>
using namespace std;
int i, j, n, x, y, z, m, k, l, r, flag, timer, glob, sz, q;
string s, t;
pair<pair<int, int>, pair<int, int> > a[1000000 + 500];
int g[1005][1005], gsz[1005];
int p[1005], c[1005];
int w[1000000 + 500], num[1000000 + 500], fir[1000000 + 500],
    sec[1000000 + 500];
int main() {
  cin >> n >> m >> q;
  for (i = 0; i < m; i++) {
    scanf("%d %d %d", &a[i].second.first, &a[i].second.second,
          &a[i].first.first);
    a[i].first.second = i + 1;
  }
  sort(a, a + m);
  reverse(a, a + m);
  for (j = 0; j < m; j++) num[j] = a[j].first.second;
  for (i = 0; i < q; i++) {
    for (j = 1; j <= n; j++) p[j] = j, c[j] = -1, w[j] = 1;
    cin >> l >> r;
    int ans = -1;
    for (j = 0; j < m; j++)
      if (num[j] >= l && num[j] <= r) {
        int x = a[j].second.first;
        int y = a[j].second.second;
        if (p[x] == p[y]) {
          if (c[x] == c[y]) {
            ans = a[j].first.first;
            break;
          }
        } else {
          if (c[x] == -1 && c[y] == -1) {
            p[x] = p[y];
            c[x] = 0;
            c[y] = 1;
            w[p[x]] = 2;
          } else if (c[x] == -1) {
            p[x] = p[y];
            c[x] = !c[y];
            w[p[x]]++;
          } else if (c[y] == -1) {
            p[y] = p[x];
            c[y] = !c[x];
            w[p[y]]++;
          } else {
            if (w[p[x]] > w[p[y]]) swap(x, y);
            w[p[y]] += w[p[x]];
            int col = p[x];
            int to_inv = (c[x] == c[y]);
            for (k = 1; k <= n; k++)
              if (p[k] == col) {
                p[k] = p[y];
                c[k] ^= to_inv;
              }
          }
        }
      }
    cout << ans << endl;
  }
  return 0;
}
