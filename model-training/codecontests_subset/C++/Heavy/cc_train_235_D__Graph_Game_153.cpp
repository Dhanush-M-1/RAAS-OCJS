#include <bits/stdc++.h>
using namespace std;
void file(string s) {
  freopen((s + ".in").c_str(), "r", stdin);
  freopen((s + ".out").c_str(), "w", stdout);
}
template <typename Tp>
void read(Tp &x) {
  int fh = 1;
  char c = getchar();
  x = 0;
  while (c > '9' || c < '0') {
    if (c == '-') {
      fh = -1;
    }
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = (x << 1) + (x << 3) + (c & 15);
    c = getchar();
  }
  x *= fh;
}
vector<int> G[1000005], nG[1000005];
int n, m;
int ff[1000005];
int fid(int x) { return ff[x] == x ? ff[x] : ff[x] = fid(ff[x]); }
int cycdep[1000005], ffa[1000005], nm;
void dfs0(int x, int pa) {
  ffa[x] = pa;
  for (auto y : G[x]) {
    if (y == pa) continue;
    if (ffa[y]) {
      cycdep[x] = 1;
      for (int yy = ffa[x], nm = 2; yy != x; yy = ffa[yy], ++nm)
        cycdep[yy] = nm;
      return;
    } else
      dfs0(y, x);
  }
}
long double ans;
void dfs(int x, int pa, int dep, int flg1, int flg2) {
  if (x == n + 1) {
    for (auto y : nG[x]) {
      if (y == pa) continue;
      dfs(y, x, dep, pa, y);
    }
    return;
  }
  for (auto y : nG[x]) {
    if (y == pa) continue;
    dfs(y, x, dep + 1, flg1, flg2);
  }
  if (flg1) {
    int a = cycdep[flg1], b = cycdep[flg2];
    int aa = abs(a - b), bb = nm - aa;
    --aa, --bb;
    ans += 1.0 / (dep + aa);
    ans += 1.0 / (dep + bb);
    ans -= 1.0 / (dep + aa + bb);
  } else {
    ans += 1.0 / dep;
  }
}
signed main() {
  int RT, X;
  read(n);
  for (int i = 1; i <= n; ++i) ff[i] = i;
  for (int i = 1, u, v; i <= n; ++i) {
    read(u);
    read(v);
    ++u;
    ++v;
    G[u].push_back(v);
    G[v].push_back(u);
    if (fid(u) == fid(v)) {
      RT = u;
      X = v;
    } else {
      ff[fid(u)] = fid(v);
    }
  }
  dfs0(RT, X);
  for (int i = 1; i <= n; ++i) {
    for (auto y : G[i]) {
      if (cycdep[i] && cycdep[y]) continue;
      nG[i].push_back(y);
    }
  }
  for (int i = 1; i <= n; ++i) {
    if (cycdep[i]) {
      nG[n + 1].push_back(i);
      nG[i].push_back(n + 1);
      ++nm;
    }
  }
  for (int i = 1; i <= n; ++i) {
    dfs(i, 0, 1, 0, 0);
  }
  cout << fixed << setprecision(15) << ans << endl;
  return 0;
}
