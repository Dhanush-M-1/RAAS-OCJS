#include <bits/stdc++.h>
using namespace std;
int p[10000];
int sz[10000];
int color[10000];
int used[10000];
int all;
vector<int> w[10000];
int n, q, m;
int z, y, x;
struct edg {
  int x, y, z, n;
  edg(int X, int Y, int Z, int N) {
    x = X;
    y = Y;
    z = Z;
    n = N;
  }
};
bool cmp(edg a, edg b) { return a.z > b.z; }
vector<edg> v;
int findset(int x) {
  if (p[x] != x) p[x] = findset(p[x]);
  return p[x];
}
void dfs(int x) {
  color[x] = 1 - color[x];
  used[x] = all;
  for (int i = 0; i < w[x].size(); i++) {
    int to = w[x][i];
    if (used[to] == all) continue;
    dfs(to);
  }
}
bool add(int x, int y) {
  int xx = findset(x);
  int yy = findset(y);
  if (xx != yy) {
    if (sz[xx] < sz[yy]) {
      swap(xx, yy);
      swap(x, y);
    }
    p[yy] = xx;
    sz[xx] += sz[yy];
    if (color[x] != color[y]) {
      w[x].push_back(y);
      w[y].push_back(x);
      return true;
    } else {
      ++all;
      dfs(y);
      w[x].push_back(y);
      w[y].push_back(x);
      return true;
    }
  } else {
    w[x].push_back(y);
    w[y].push_back(x);
    if (color[x] == color[y]) return false;
    return true;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) {
    cin >> x >> y >> z;
    edg cur(x, y, z, i);
    v.push_back(cur);
  }
  sort(v.begin(), v.end(), cmp);
  for (int q1 = 1; q1 <= q; q1++) {
    for (int i = 1; i <= n; i++) {
      p[i] = i;
      color[i] = 1;
      sz[i] = 1;
      w[i].clear();
    }
    int l, r;
    cin >> l >> r;
    int ans = -1;
    for (int i = 0; i < v.size(); i++)
      if (v[i].n >= l && v[i].n <= r) {
        x = v[i].x;
        y = v[i].y;
        if (!add(x, y)) {
          ans = v[i].z;
          break;
        }
      }
    cout << ans << "\n";
  }
}
