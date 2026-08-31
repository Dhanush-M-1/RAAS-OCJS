#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:66777216")
using namespace std;
inline void add(int& a, int b) {
  a += b;
  if (a >= 1000000007) a -= 1000000007;
}
const int N = 100002;
int a, b, c, d, n, m, k;
vector<pair<int, int> > sm[N];
int cnt[N], sum[N], ss[N];
bool bad[N];
void dfsr(int v, int pr, int* cnt, int* sum, int* ss) {
  cnt[v] = 1;
  sum[v] = 0;
  ss[v] = 0;
  for (int _n(((int)((sm[v]).size())) - 1), i(0); i <= _n; i++) {
    int w = sm[v][i].first;
    if (w == pr || bad[w]) continue;
    dfsr(w, v, cnt, sum, ss);
    cnt[v] += cnt[w];
    add(sum[v], sum[w]);
    sum[v] = (sum[v] + (long long)cnt[w] * sm[v][i].second) % 1000000007;
    add(ss[v], ss[w]);
    ss[v] = (ss[v] + (long long)sm[v][i].second * sm[v][i].second % 1000000007 *
                         cnt[w]) %
            1000000007;
    ss[v] = (ss[v] + 2LL * sm[v][i].second * sum[w]) % 1000000007;
  }
}
int ovss[N], ovsum[N], sub[N];
int dfs_cnt(int v, int pr) {
  int ans = 1;
  for (int _n(((int)((sm[v]).size())) - 1), i(0); i <= _n; i++) {
    int w = sm[v][i].first;
    if (w == pr || bad[w]) continue;
    ans += dfs_cnt(w, v);
  }
  return ans;
}
pair<int, int> dfs_cen(int v, int pr, int ov) {
  pair<int, int> t = make_pair(1000000000, v);
  sub[v] = 1;
  int mx = 0;
  for (int _n(((int)((sm[v]).size())) - 1), i(0); i <= _n; i++) {
    int w = sm[v][i].first;
    if (w == pr || bad[w]) continue;
    pair<int, int> tt = dfs_cen(w, v, ov);
    t = min(t, tt);
    sub[v] += sub[w];
    mx = max(mx, sub[w]);
  }
  mx = max(mx, ov - sub[v]);
  t = min(t, make_pair(mx, v));
  return t;
}
int pcnt[N], psum[N], pss[N];
void dfs_part(int v, int pr, int sumsof, int cntrem, int sumrem, int sqrem) {
  ovsum[v] = (ovsum[v] + sumrem + (long long)sumsof * cntrem) % 1000000007;
  ovss[v] =
      (ovss[v] + sqrem + (long long)sumsof * sumsof % 1000000007 * cntrem +
       2LL * sumsof * sumrem) %
      1000000007;
  for (int _n(((int)((sm[v]).size())) - 1), i(0); i <= _n; i++) {
    int w = sm[v][i].first;
    if (w == pr || bad[w]) continue;
    dfs_part(w, v, (sumsof + sm[v][i].second) % 1000000007, cntrem, sumrem,
             sqrem);
  }
}
void rec(int s) {
  int ov = dfs_cnt(s, -1);
  pair<int, int> t = dfs_cen(s, -1, ov);
  s = t.second;
  dfsr(s, -1, pcnt, psum, pss);
  add(ovss[s], pss[s]);
  add(ovsum[s], psum[s]);
  for (int _n(((int)((sm[s]).size())) - 1), i(0); i <= _n; i++) {
    int w = sm[s][i].first;
    if (bad[w]) continue;
    int cntrem = pcnt[s] - pcnt[w];
    int sumrem =
        (psum[s] - psum[w] - (long long)sm[s][i].second * pcnt[w]) % 1000000007;
    if (sumrem < 0) sumrem += 1000000007;
    int sqrem =
        (pss[s] - pss[w] -
         (long long)sm[s][i].second * sm[s][i].second % 1000000007 * pcnt[w] -
         2LL * sm[s][i].second * psum[w]) %
        1000000007;
    if (sqrem < 0) sqrem += 1000000007;
    dfs_part(w, s, sm[s][i].second, cntrem, sumrem, sqrem);
  }
  bad[s] = 1;
  for (int _n(((int)((sm[s]).size())) - 1), i(0); i <= _n; i++) {
    int w = sm[s][i].first;
    if (bad[w]) continue;
    rec(w);
  }
}
int up[100002][18];
int tin[100002], tout[100002], ct;
int hg[100002];
void dfs_lca(int v, int p = 0) {
  tin[v] = ++ct;
  up[v][0] = p;
  for (int i = 1; i <= 17; ++i) up[v][i] = up[up[v][i - 1]][i - 1];
  for (size_t i = 0; i < sm[v].size(); ++i) {
    int to = sm[v][i].first;
    if (to != p) {
      hg[to] = (hg[v] + sm[v][i].second) % 1000000007;
      dfs_lca(to, v);
    }
  }
  tout[v] = ++ct;
}
bool upper(int a, int b) { return tin[a] <= tin[b] && tout[a] >= tout[b]; }
int lca(int a, int b) {
  if (upper(a, b)) return a;
  if (upper(b, a)) return b;
  for (int i = 17; i >= 0; --i)
    if (!upper(up[a][i], b)) a = up[a][i];
  return up[a][0];
}
int main() {
  scanf("%d", &n);
  for (int _n((n - 1) - 1), i(0); i <= _n; i++) {
    scanf("%d%d%d", &a, &b, &c);
    --a;
    --b;
    sm[a].push_back(make_pair(b, c));
    sm[b].push_back(make_pair(a, c));
  }
  dfsr(0, -1, cnt, sum, ss);
  rec(0);
  dfs_lca(0);
  scanf("%d", &m);
  for (int _n((m)-1), i(0); i <= _n; i++) {
    scanf("%d%d", &a, &b);
    --a;
    --b;
    int toall = ovss[a];
    int l = lca(a, b);
    int ans = 0, sub = 0;
    int len = (hg[a] - hg[l] + hg[b] - hg[l]) % 1000000007;
    if (len < 0) len += 1000000007;
    if (!upper(b, a)) {
      sub = (ss[b] + (long long)len * len % 1000000007 * cnt[b] +
             2LL * len * sum[b]) %
            1000000007;
    } else {
      int ssnd = ovss[b] - ss[b];
      if (ssnd < 0) ssnd += 1000000007;
      int snd = ovsum[b] - sum[b];
      if (snd < 0) snd += 1000000007;
      int cnd = n - cnt[b];
      sub = (ovss[a] - ssnd - (long long)len * len % 1000000007 * cnd -
             2LL * len * snd) %
            1000000007;
      if (sub < 0) sub += 1000000007;
    }
    ans = (2LL * sub - toall) % 1000000007;
    if (ans < 0) ans += 1000000007;
    printf("%d\n", ans);
  }
}
