#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
int n, k, par[20][N];
vector<int> g[N], g2[N], H[N], ord;
bool mark[N], l[N];
int f[N], h[N], p[N], c, s[N], la[N], ans;
void ff();
void input();
void dp();
void dfs(int);
void dfss(int);
void dfsss(int);
void c_g();
int get_par(int, int);
void dfssss(int);
int main() {
  input();
  c_g();
  ff();
  fill(mark, mark + n, false);
  s[p[0]] = la[p[0]];
  dfssss(p[0]);
  cout << ans << endl;
}
void input() {
  cin >> n >> k;
  for (int i = 1; i <= n - 1; i++) {
    cin >> par[0][i];
    par[0][i]--, g[par[0][i]].push_back(i);
    g2[i].push_back(par[0][i]);
  }
}
void dfs(int x) {
  mark[x] = true;
  if (g[x].size() == 0)
    f[x] = k, l[x] = true;
  else
    for (int y : g[x]) {
      if (!mark[y]) {
        h[y] = h[x] + 1;
        dfs(y);
        f[x] = max(f[x], f[y] - 1);
      }
    }
  f[x] = min(f[x], h[x]);
}
void c_g() {
  dfs(0);
  dp();
  for (int i = 0; i < n; i++)
    if (f[i] != 0) {
      int d = get_par(i, f[i]);
      g[i].push_back(d);
      g2[d].push_back(i);
    }
}
void dp() {
  for (int i = 1; i < 20; i++)
    for (int j = 0; j < n; j++) par[i][j] = par[i - 1][par[i - 1][j]];
}
int get_par(int x, int b) {
  for (int i = 20 - 1; i >= 0; i--)
    if (b >= (1 << i)) b -= (1 << i), x = par[i][x];
  return x;
}
void ff() {
  fill(mark, mark + n, false);
  dfss(0);
  fill(mark, mark + n, false);
  for (int i = n - 1; i >= 0; i--)
    if (!mark[ord[i]]) dfsss(ord[i]), c++;
  for (int i = 1; i < n; i++) {
    if (p[i] != p[par[0][i]]) H[p[par[0][i]]].push_back(p[i]);
    if (l[i]) {
      la[p[i]]++;
    }
  }
}
void dfss(int x) {
  mark[x] = true;
  for (int y : g[x]) {
    if (!mark[y]) dfss(y);
  }
  ord.push_back(x);
}
void dfsss(int x) {
  mark[x] = true;
  p[x] = c;
  for (int y : g2[x]) {
    if (!mark[y]) dfsss(y);
  }
}
void dfssss(int x) {
  mark[x] = true;
  for (int y : H[x]) {
    if (!mark[y]) {
      s[y] = la[y] + s[x];
      dfssss(y);
    }
  }
  if (H[x].size() == 0) ans = max(ans, s[x]);
}
