#include <bits/stdc++.h>
using namespace std;
const long long maxn = 1e5 + 1;
vector<int> gx[maxn + 7];
vector<int> gy[maxn + 7];
long long g[maxn + 7];
int n;
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    g[i] = maxn * x + y;
    gx[x].push_back(y);
    gy[y].push_back(x);
  }
  for (int i = 0; i <= maxn; i++) {
    sort(gx[i].begin(), gx[i].end());
    sort(gy[i].begin(), gy[i].end());
  }
  sort(g, g + n);
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    int x, y;
    x = (int)(g[i] / maxn);
    y = (int)(g[i] % maxn);
    int idx, idy;
    idx = lower_bound(gy[y].begin(), gy[y].end(), x + 1) - gy[y].begin();
    idy = lower_bound(gx[x].begin(), gx[x].end(), y + 1) - gx[x].begin();
    while (idx < gy[y].size() && idy < gx[x].size()) {
      int nowx = gy[y][idx];
      int nowy = gx[x][idy];
      if (nowx - x == nowy - y) {
        int pos = lower_bound(g, g + n, nowx * maxn + (long long)nowy) - g;
        if (g[pos] == nowx * maxn + (long long)nowy) ans++;
        idx++;
        idy++;
      } else if (nowx - x > nowy - y)
        idy = lower_bound(gx[x].begin(), gx[x].end(), y + nowx - x) -
              gx[x].begin();
      else
        idx = lower_bound(gy[y].begin(), gy[y].end(), x + nowy - y) -
              gy[y].begin();
    }
  }
  cout << ans << endl;
  return 0;
}
