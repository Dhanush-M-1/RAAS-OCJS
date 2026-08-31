#include <bits/stdc++.h>
using namespace std;
const long long base = 1000000007;
const int MAXN = 100100;
long long sumsq[MAXN], sum2[MAXN];
long long dist1[MAXN];
long long sumsqrest[MAXN], sum2rest[MAXN];
int ac[MAXN][20];
long long sz[MAXN];
vector<pair<int, int> > v[MAXN];
int n;
int tim, tin[MAXN], tout[MAXN];
void dfs(int x, int pr) {
  tin[x] = tim;
  tim++;
  ac[x][0] = pr;
  for (int i = 1; i < 20; i++) ac[x][i] = ac[ac[x][i - 1]][i - 1];
  sz[x] = 1;
  for (int i = 0; i < v[x].size(); i++) {
    int to = v[x][i].first;
    int add = v[x][i].second;
    if (to == pr) continue;
    dist1[to] = dist1[x] + add;
    dist1[to] %= base;
    dfs(to, x);
    sz[x] += sz[to];
    sum2[x] += (sum2[to] + 2 * add * sz[to]);
    sum2[x] %= base;
    sumsq[x] += sumsq[to];
    sumsq[x] %= base;
    sumsq[x] += (sum2[to] * add);
    sumsq[x] %= base;
    sumsq[x] += sz[to] * add % base * add % base;
    sumsq[x] %= base;
  }
  tout[x] = tim;
  tim++;
}
void dfs2(int x, int pr) {
  for (int i = 0; i < v[x].size(); i++) {
    int to = v[x][i].first;
    int add = v[x][i].second;
    if (to == pr) continue;
    long long szh = n - sz[to];
    long long sumsqh = sumsqrest[x] - (sum2[to] * add) - sumsq[to];
    sumsqh += base * base;
    sumsqh %= base;
    sumsqh -= sz[to] * add % base * add % base;
    sumsqh %= base;
    long long sum2h = sum2rest[x] - 2 * sz[to] * add % base - sum2[to];
    sum2h += base * base;
    sum2h %= base;
    sumsqrest[to] = sumsq[to];
    sum2rest[to] = sum2[to];
    sum2rest[to] += (sum2h + 2 * add * szh);
    sum2rest[to] %= base;
    sumsqrest[to] += sumsqh;
    sumsqrest[to] %= base;
    sumsqrest[to] += (sum2h * add);
    sumsqrest[to] %= base;
    sumsqrest[to] += szh * add % base * add % base;
    sumsqrest[to] %= base;
    dfs2(to, x);
  }
}
bool is_ac(int a, int b) { return (tin[a] <= tin[b] && tout[b] <= tout[a]); }
int lca(int a, int b) {
  if (is_ac(a, b)) return a;
  if (is_ac(b, a)) return b;
  for (int i = 19; i >= 0; i--) {
    if (!is_ac(ac[b][i], a)) b = ac[b][i];
  }
  return ac[b][0];
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int aa, bb, cc;
    scanf("%d%d%d", &aa, &bb, &cc);
    v[aa].push_back(make_pair(bb, cc));
    v[bb].push_back(make_pair(aa, cc));
  }
  tin[0] = -1;
  tout[0] = (1 << 20);
  dfs(1, 0);
  sumsqrest[1] = sumsq[1];
  sum2rest[1] = sum2[1];
  dfs2(1, 0);
  int q;
  scanf("%d", &q);
  for (int i = 1; i <= q; i++) {
    int aa, bb;
    scanf("%d%d", &aa, &bb);
    int o = lca(aa, bb);
    long long dist = dist1[aa] + dist1[bb] - 2 * dist1[o];
    long long F, S;
    if (!is_ac(bb, aa)) {
      F = sumsq[bb] + dist * sum2[bb] + sz[bb] * dist % base * dist % base;
      F %= base;
      S = sumsqrest[aa] - F;
      S += base * base;
      S %= base;
    } else {
      long long szr = n - sz[bb];
      F = sumsqrest[aa] -
          (sumsqrest[bb] - sumsq[bb] + szr * dist % base * dist % base +
           (sum2rest[bb] - sum2[bb] + base) * dist % base);
      F += base * base;
      F %= base;
      S = sumsqrest[aa] - F;
      S += base * base;
      S %= base;
    }
    long long ans = F - S;
    ans += base * base;
    ans %= base;
    cout << ans << "\n";
  }
  return 0;
}
