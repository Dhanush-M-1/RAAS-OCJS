#include <bits/stdc++.h>
#pragma GCC optimize(2)
const double esp = 1e-6;
const double pi = acos(-1.0);
const int INF = 0x3f3f3f3f;
const int inf = 1e9;
using namespace std;
long long read() {
  char ch = getchar();
  long long x = 0, f = 1;
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
const int N = 1e5 + 10;
int n, m, k, q, cnt;
long long dis[2 * N];
struct edges {
  int from, to, next;
  long long wi;
  bool operator<(const edges &node) const { return wi < node.wi; }
} edge[6 * N];
int head[6 * N];
vector<int> tr[N << 1];
long long tr_wi[N << 1];
int tr_num = 0;
void addedge(int u, int v, long long w) {
  edge[cnt].from = u;
  edge[cnt].wi = w;
  edge[cnt].next = head[u];
  edge[cnt].to = v;
  head[u] = cnt++;
}
void dj() {
  priority_queue<pair<long long, int>, vector<pair<long long, int> >,
                 greater<pair<long long, int> > >
      que;
  for (int i = 1; i <= n; i++) {
    if (i <= k) {
      que.push(make_pair(0, i));
    } else
      dis[i] = 1e18;
  }
  while (!que.empty()) {
    auto s = que.top();
    que.pop();
    long long fi = s.first;
    int se = s.second;
    if (dis[se] < fi) continue;
    for (int i = head[se]; ~i; i = edge[i].next) {
      int v = edge[i].to;
      if (dis[v] > fi + edge[i].wi) {
        dis[v] = fi + edge[i].wi;
        que.push(make_pair(dis[edge[i].to], edge[i].to));
      }
    }
  }
}
int pr[3 * N];
int height[3 * N];
set<int> s[3 * N];
long long ans[3 * N];
vector<pair<int, int> > ip[N];
void init() {
  for (int i = 0; i <= n; i++) pr[i] = i, height[i] = 1, s[i].insert(i);
}
int find_pr(int u) { return pr[u] == u ? u : pr[u] = find_pr(pr[u]); }
bool same(int u, int v) { return find_pr(u) == find_pr(v); }
void insert(int u, int v, long long w) {
  u = find_pr(u), v = find_pr(v);
  if (u == v) return;
  if (height[u] < height[v]) swap(u, v);
  pr[v] = u;
  height[u] += height[v];
  for (auto k : s[v])
    for (auto p : ip[k]) {
      if (s[u].count(p.second)) ans[p.first] = w;
    }
  for (auto k : s[v]) s[u].insert(k);
}
int main() {
  memset(head, -1, sizeof(head));
  n = read(), m = read(), k = read(), q = read();
  int u, v;
  long long w;
  for (int i = 1; i <= m; i++) {
    u = read(), v = read(), w = read();
    addedge(u, v, w);
    addedge(v, u, w);
  }
  dj();
  for (int i = 0; i < cnt; i++) {
    edge[i].wi += dis[edge[i].from] + dis[edge[i].to];
  }
  sort(edge, edge + cnt);
  int ip_cnt = 0;
  init();
  while (q--) {
    u = read(), v = read();
    ip[u].push_back(make_pair(ip_cnt, v));
    ip[v].push_back(make_pair(ip_cnt, u));
    ip_cnt++;
  }
  for (int i = 0; i < cnt; i++) {
    u = edge[i].from;
    v = edge[i].to;
    insert(u, v, edge[i].wi);
  }
  for (int i = 0; i < ip_cnt; i++) {
    printf("%lld\n", ans[i]);
  }
  return 0;
}
