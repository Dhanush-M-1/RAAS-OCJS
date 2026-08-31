#include <bits/stdc++.h>
using namespace std;
template <typename T1, typename T2>
inline T1 max(T1 a, T2 b) {
  return a < b ? b : a;
}
template <typename T1, typename T2>
inline T1 min(T1 a, T2 b) {
  return a < b ? a : b;
}
const char lf = '\n';
namespace ae86 {
const int bufl = 1 << 15;
char buf[bufl], *s = buf, *t = buf;
inline int fetch() {
  if (s == t) {
    t = (s = buf) + fread(buf, 1, bufl, stdin);
    if (s == t) return EOF;
  }
  return *s++;
}
inline int ty() {
  int a = 0;
  int b = 1, c = fetch();
  while (!isdigit(c)) b ^= c == '-', c = fetch();
  while (isdigit(c)) a = a * 10 + c - 48, c = fetch();
  return b ? a : -a;
}
}  // namespace ae86
using ae86::ty;
const int _ = 100007, __ = 300007, _n = _ << 1, lglg = 19;
vector<pair<int, int>> e[_];
inline void adde(int a, int b, int c) { e[a].emplace_back(b, c); }
inline void addde(int a, int b, int c) { adde(a, b, c), adde(b, a, c); }
int n, m, chx, qn;
long long dis[_], via[_];
int ed[_];
struct cxk {
  int a, b;
  long long v;
  cxk(int a_ = 0, int b_ = 0, long long v_ = 0) { a = a_, b = b_, v = v_; }
  friend int operator<(cxk a, cxk b) { return a.v < b.v; }
} es[__];
int ecnts = 0;
void dijks() {
  priority_queue<pair<long long, int>, vector<pair<long long, int>>,
                 greater<pair<long long, int>>>
      q;
  memset(dis, 63, sizeof(dis)), memset(ed, 0, sizeof(ed));
  for (int i = 1; i <= chx; i++) dis[i] = 0, via[i] = i, q.emplace(dis[i], i);
  while (!q.empty()) {
    int a = q.top().second;
    q.pop();
    if (ed[a]) continue;
    ed[a] = 1;
    for (auto [b, c] : e[a]) {
      if (dis[b] <= dis[a] + c) continue;
      dis[b] = dis[a] + c, via[b] = via[a];
      if (!ed[b]) q.emplace(dis[b], b);
    }
  }
  for (int i = 1; i <= n; i++)
    for (auto [b, c] : e[i])
      if (b > i && via[i] != via[b])
        es[++ecnts] = cxk(via[i], via[b], dis[i] + dis[b] + c);
}
int bfa[_n] = {0};
int findbfa(int x) { return bfa[x] == x ? x : bfa[x] = findbfa(bfa[x]); }
int pfa[_n][lglg + 1] = {0}, pdep[_n] = {0}, pcnt = 0;
long long pva[_n] = {0};
int lca(int a, int b) {
  if (pdep[a] < pdep[b]) swap(a, b);
  for (int i = lglg; i >= 0; i--)
    if (pdep[pfa[a][i]] >= pdep[b]) a = pfa[a][i];
  if (a == b) return a;
  for (int i = lglg; i >= 0; i--)
    if (pfa[a][i] != pfa[b][i]) a = pfa[a][i], b = pfa[b][i];
  if (a != b) a = pfa[a][0], b = pfa[b][0];
  return a;
}
void kuro() {
  sort(es + 1, es + ecnts + 1);
  pcnt = n;
  for (int i = 1; i <= pcnt; i++) bfa[i] = i;
  for (int i = 1; i <= ecnts; i++) {
    auto [a, b, c] = es[i];
    int aa = findbfa(a), bb = findbfa(b);
    if (aa == bb) continue;
    pcnt++, bfa[pcnt] = bfa[aa] = bfa[bb] = pcnt, pva[pcnt] = c,
            pfa[aa][0] = pfa[bb][0] = pcnt;
  }
  for (int i = pcnt; i >= 1; i--) pdep[i] = pdep[pfa[i][0]] + 1;
  for (int i = 1; i <= lglg; i++)
    for (int j = 1; j <= pcnt; j++) pfa[j][i] = pfa[pfa[j][i - 1]][i - 1];
}
int main() {
  ios::sync_with_stdio(0), cout.tie(nullptr);
  n = ty(), m = ty(), chx = ty(), qn = ty();
  for (int i = 1, a, b, c; i <= m; i++)
    a = ty(), b = ty(), c = ty(), addde(a, b, c);
  dijks(), kuro();
  for (int qq = 1; qq <= qn; qq++) {
    int a = ty(), b = ty();
    cout << pva[lca(a, b)] << lf;
  }
  return 0;
}
