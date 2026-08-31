#include <bits/stdc++.h>
using namespace std;
const int maxn = 100000 + 10;
struct P {
  int to;
  long long dis;
};
vector<P> v[maxn];
map<int, int> mp[maxn];
vector<long long> psum[maxn], sqsum[maxn];
vector<int> sz[maxn];
long long sqval[maxn];
int anc[17][maxn], dep[maxn];
int tin[maxn], tout[maxn], tick;
void dfs0(int x, int f, int d) {
  tin[x] = tick++;
  dep[x] = d;
  anc[0][x] = f;
  for (int i = 1; i < 17; i++) anc[i][x] = anc[i - 1][anc[i - 1][x]];
  for (auto i : v[x])
    if (f != i.to) dfs0(i.to, x, (i.dis + d) % 1000000007);
  tout[x] = tick++;
}
inline bool isfa(int x, int y) {
  return tin[x] <= tin[y] && tout[x] >= tout[y];
}
int LCA(int x, int y) {
  if (isfa(x, y)) return x;
  if (isfa(y, x)) return y;
  for (int i = 16; i >= 0; i--)
    if (!isfa(anc[i][x], y)) x = anc[i][x];
  return anc[0][x];
}
int getlen(int x, int y) {
  int lca = LCA(x, y), ret = (dep[x] + dep[y] - 2 * dep[lca]) % 1000000007;
  if (ret < 0) ret += 1000000007;
  return ret;
}
inline long long cal_add_s(const P &i, int id) {
  return sqsum[i.to][id] + (i.dis * i.dis % 1000000007) * sz[i.to][id] +
         2 * i.dis * psum[i.to][id];
}
inline long long cal_add_p(const P &i, int id) {
  return psum[i.to][id] + sz[i.to][id] * i.dis;
}
int n, cnt[maxn];
void dfs(int x, int id) {
  if (psum[x][id] != -1) return;
  sz[x][id] = 1;
  long long &ans1 = psum[x][id];
  long long &ans2 = sqsum[x][id];
  ans1 = 0;
  if (v[x].size() == 1) return;
  for (auto i : v[x])
    if (i.to != v[x][id].to) {
      int id2 = mp[i.to][x];
      dfs(i.to, id2);
      ans1 = (ans1 + cal_add_p(i, id2)) % 1000000007;
      ans2 = (ans2 + cal_add_s(i, id2)) % 1000000007;
      sz[x][id] += sz[i.to][id2];
    }
  if (++cnt[x] == 2) {
    int id2 = mp[v[x][id].to][x];
    long long tot1 = ans1 + cal_add_p(v[x][id], id2);
    tot1 %= 1000000007;
    long long tot2 = ans2 + cal_add_s(v[x][id], id2);
    tot2 %= 1000000007;
    int totsz = sz[x][id] + sz[v[x][id].to][id2];
    for (int i = 0; i < v[x].size(); i++)
      if (psum[x][i] == -1) {
        int id3 = mp[v[x][i].to][x];
        assert(psum[v[x][i].to][id3] != -1);
        psum[x][i] = tot1 - cal_add_p(v[x][i], id3) % 1000000007;
        if (psum[x][i] < 0) psum[x][i] += 1000000007;
        sqsum[x][i] = tot2 - cal_add_s(v[x][i], id3) % 1000000007;
        if (sqsum[x][i] < 0) sqsum[x][i] += 1000000007;
        sz[x][i] = totsz - sz[v[x][i].to][id3];
      }
  }
}
long long getval(int x) {
  long long ret = 0;
  for (auto i : v[x]) {
    int id = mp[i.to][x];
    dfs(i.to, id);
    ret = (ret + cal_add_s(i, id)) % 1000000007;
  }
  return ret;
}
long long query(int u, int v) {
  long long ret = 0LL;
  if (!isfa(v, u)) {
    ret = -sqval[u] + 1000000007;
    int id = mp[v][anc[0][v]];
    long long dis = getlen(u, v), add = (dis * dis % 1000000007) * sz[v][id];
    add += sqsum[v][id];
    add += 2 * dis * psum[v][id];
    add %= 1000000007;
    return (ret + 2 * add) % 1000000007;
  } else if (v == 1)
    return sqval[u];
  else {
    ret = sqval[u];
    int v2 = anc[0][v], id = mp[v2][v];
    long long dis = dep[u] - dep[v2];
    if (dis < 0) dis += 1000000007;
    long long sub = (dis * dis % 1000000007) * sz[v2][id];
    sub += sqsum[v2][id];
    sub += 2 * dis * psum[v2][id];
    sub %= 1000000007;
    return ((ret - 2 * sub) % 1000000007 + 1000000007) % 1000000007;
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int x, y;
    long long dis;
    scanf("%d%d%I64d", &x, &y, &dis);
    v[x].push_back((P){y, dis});
    v[y].push_back((P){x, dis});
  }
  for (int i = 1; i <= n; i++) {
    psum[i].resize(v[i].size());
    sqsum[i].resize(v[i].size());
    sz[i].resize(v[i].size());
    for (int j = 0; j < v[i].size(); j++)
      mp[i][v[i][j].to] = j, psum[i][j] = -1;
  }
  dfs0(1, 1, 0);
  for (int i = 1; i <= n; i++) sqval[i] = getval(i);
  int Q;
  scanf("%d", &Q);
  while (Q--) {
    int x, y;
    scanf("%d%d", &x, &y);
    printf("%I64d\n", query(x, y));
  }
}
