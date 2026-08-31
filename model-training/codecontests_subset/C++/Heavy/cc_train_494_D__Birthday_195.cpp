#include <bits/stdc++.h>
using namespace std;
long long int n, h[100001], root[100001], par[100001][25], size[100001],
    dp_down_0[100001], dp_down_1[100001], dp_up_0[100001], dp_up_1[100001];
vector<pair<long long int, long long int> > v[100001];
long long int add(long long int x, long long int y) {
  return (x + y) % 1000000007;
}
long long int mul(long long int x, long long int y) {
  return (1LL * x * y) % 1000000007;
}
long long int sub(long long int x, long long int y) {
  return (x - y + 1000000007) % 1000000007;
}
long long int sq(long long int x) { return (1LL * x * x) % 1000000007; }
void dfs_down(long long int cur, long long int p) {
  if (p != -1) h[cur] = h[p] + 1;
  par[cur][0] = p;
  for (long long int i = 1; i < 20; i++) {
    if (par[cur][i - 1] != -1) par[cur][i] = par[par[cur][i - 1]][i - 1];
  }
  size[cur] = 1;
  for (long long int i = 0; i < v[cur].size(); i++) {
    long long int x = v[cur][i].first;
    if (x == p) continue;
    root[x] = add(root[cur], v[cur][i].second);
    dfs_down(x, cur);
    size[cur] += size[x];
    dp_down_0[cur] = add(dp_down_0[cur], dp_down_0[x]);
    dp_down_0[cur] = add(dp_down_0[cur], mul(size[x], v[cur][i].second));
    dp_down_1[cur] = add(dp_down_1[cur], mul(size[x], sq(v[cur][i].second)));
    dp_down_1[cur] = add(dp_down_1[cur], dp_down_1[x]);
    dp_down_1[cur] =
        add(dp_down_1[cur], mul(2, mul(v[cur][i].second, dp_down_0[x])));
  }
}
void dfs_up(long long int cur, long long int p, long long int wt) {
  if (p != -1) {
    dp_up_0[cur] = add(dp_up_0[cur], dp_up_0[p]);
    dp_up_0[cur] = add(dp_up_0[cur], mul(n - size[p], wt));
    long long int x = dp_down_0[p];
    x = sub(x, dp_down_0[cur]);
    x = sub(x, mul(size[cur], wt));
    dp_up_0[cur] = add(dp_up_0[cur], x);
    dp_up_0[cur] = add(dp_up_0[cur], mul(wt, size[p] - size[cur]));
    dp_up_1[cur] = add(dp_up_1[cur], dp_up_1[p]);
    dp_up_1[cur] = add(dp_up_1[cur], mul(n - size[p], sq(wt)));
    dp_up_1[cur] = add(dp_up_1[cur], mul(2, mul(wt, dp_up_0[p])));
    x = dp_down_1[p];
    x = sub(x, dp_down_1[cur]);
    x = sub(x, mul(2, mul(wt, dp_down_0[cur])));
    x = sub(x, mul(size[cur], sq(wt)));
    long long int y = dp_down_0[p];
    y = sub(y, dp_down_0[cur]);
    y = sub(y, mul(wt, size[cur]));
    dp_up_1[cur] = add(dp_up_1[cur], x);
    dp_up_1[cur] = add(dp_up_1[cur], mul(2, mul(wt, y)));
    dp_up_1[cur] = add(dp_up_1[cur], mul(sq(wt), size[p] - size[cur]));
  }
  for (long long int i = 0; i < v[cur].size(); i++) {
    long long int x = v[cur][i].first;
    if (x == p) continue;
    dfs_up(x, cur, v[cur][i].second);
  }
}
int lca(int v, int u) {
  if (h[v] < h[u]) swap(v, u);
  for (int i = 20 - 1; i >= 0; i--) {
    if (par[v][i] != -1 && h[par[v][i]] >= h[u]) {
      v = par[v][i];
    }
  }
  if (v == u) return u;
  for (int i = 20 - 1; i >= 0; i--) {
    if (par[v][i] - par[u][i]) v = par[v][i], u = par[u][i];
  }
  return par[v][0];
}
long long int distance(long long int x, long long int y) {
  long long int ans = root[x];
  ans = add(ans, root[y]);
  ans = sub(ans, mul(2, root[lca(x, y)]));
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  ;
  cin.tie(0);
  ;
  long long int i, j, q, x, y, ans, temp, z, lc, dist;
  memset(par, -1, sizeof par);
  cin >> n;
  for (i = 1; i <= n - 1; i++) {
    cin >> x >> y >> z;
    v[x].push_back(make_pair(y, z));
    v[y].push_back(make_pair(x, z));
  }
  dfs_down(1, -1);
  dfs_up(1, -1, 0);
  cin >> q;
  while (q--) {
    cin >> x >> y;
    dist = distance(x, y);
    lc = lca(x, y);
    if ((lc != x && lc != y) || lc == x) {
      ans = dp_down_1[y];
      ans = add(ans, mul(sq(dist), size[y]));
      ans = add(ans, mul(2, mul(dist, dp_down_0[y])));
      ans = mul(2, ans);
      ans = sub(ans, dp_down_1[x]);
      ans = sub(ans, dp_up_1[x]);
      cout << ans << "\n";
    } else if (lc == y) {
      ans = dp_down_1[x];
      temp = dp_up_1[x];
      temp = sub(temp, dp_up_1[y]);
      temp = sub(temp, mul(2, mul(dist, dp_up_0[y])));
      temp = sub(temp, mul(n - size[y], sq(dist)));
      ans = add(ans, temp);
      ans = mul(2, ans);
      ans = sub(ans, dp_down_1[x]);
      ans = sub(ans, dp_up_1[x]);
      cout << ans << "\n";
    } else
      assert(false);
  }
  return 0;
}
