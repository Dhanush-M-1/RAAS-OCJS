#include <bits/stdc++.h>
using namespace std;
const long long inff = 0x3f3f3f3f3f3f3f3f;
const int N = 1e2 + 8;
int w[N][N], x[N], y[N], pop, n, k, lx, ly, a[N];
int px[N], py[N], sy[N], slack[N], par[N];
void adjust(int v) {
  sy[v] = py[v];
  if (px[sy[v]] != -2) adjust(px[sy[v]]);
}
bool fid(int v) {
  for (int i(0); i <= (pop - 1); ++i)
    if (py[i] == -1) {
      if (slack[i] > x[v] + y[i] - w[v][i])
        slack[i] = x[v] + y[i] - w[v][i], par[i] = v;
      if (x[v] + y[i] == w[v][i]) {
        py[i] = v;
        if (sy[i] == -1) {
          adjust(i);
          return 1;
        }
        if (px[sy[i]] != -1) continue;
        px[sy[i]] = i;
        if (fid(sy[i])) return 1;
      }
    }
  return 0;
}
void km() {
  for (int i(0); i <= (pop - 1); ++i) sy[i] = -1, y[i] = 0;
  for (int i(0); i <= (pop - 1); ++i) {
    x[i] = 0;
    for (int j(0); j <= (pop - 1); ++j) x[i] = max(x[i], w[i][j]);
  }
  int flag, m;
  for (int i(0); i <= (pop - 1); ++i) {
    for (int j(0); j <= (pop - 1); ++j)
      px[j] = py[j] = -1, slack[j] = int(0x3f3f3f3f);
    px[i] = -2;
    if (fid(i)) continue;
    flag = 0;
    while (!flag) {
      m = int(0x3f3f3f3f);
      for (int j(0); j <= (pop - 1); ++j)
        if (py[j] == -1) m = min(m, slack[j]);
      for (int j(0); j <= (pop - 1); ++j) {
        if (px[j] != -1) x[j] -= m;
        if (py[j] != -1)
          y[j] += m;
        else
          slack[j] -= m;
      }
      for (int j(0); j <= (pop - 1); ++j)
        if (py[j] == -1 && !slack[j]) {
          py[j] = par[j];
          if (sy[j] == -1) {
            adjust(j), flag = 1;
            break;
          }
          px[sy[j]] = j;
          if (fid(sy[j])) {
            flag = 1;
            break;
          }
        }
    }
  }
}
int main() {
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    cin >> n >> k;
    pop = max(n, k);
    for (int i(1); i <= (n); ++i) {
      scanf("%d", &lx), scanf("%d", &ly);
      for (int j(1); j <= (min(k, n)); ++j) w[i - 1][j - 1] = lx + ly * (j - 1);
      for (int j(k + 1); j <= (n); ++j) w[i - 1][j - 1] = ly * (k - 1);
    }
    km();
    if (k <= n)
      cout << 2 * n - k << endl;
    else
      cout << n << endl;
    for (int i(0); i <= (n - 1); ++i) {
      sy[i]++;
      if (i == min(n, k) - 1) continue;
      if (i >= k)
        cout << sy[i] << " " << -sy[i] << " ";
      else
        cout << sy[i] << " ";
    }
    cout << sy[min(n, k) - 1] << endl;
  }
  return 0;
}
