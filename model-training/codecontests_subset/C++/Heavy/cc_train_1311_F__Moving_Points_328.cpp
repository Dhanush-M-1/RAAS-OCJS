#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 10;
struct node {
  long long a;
  long long t;
} w[N];
bool cmp(node a, node b) { return a.a < b.a; }
long long c[N][2], cnt[N], n;
long long lowbit(long long x) { return x & (-x); }
void add(long long x, long long val) {
  while (x <= n) c[x][0]++, c[x][1] += val, x += lowbit(x);
}
long long ask(long long x, long long k) {
  long long res = 0;
  while (x) res += c[x][k], x -= lowbit(x);
  return res;
}
long long ans = 0, len = 0;
struct EDGE {
  long long to, next;
  long long dis;
} edge[N];
struct ha {
  long long pos;
  long long dis;
  friend bool operator<(ha a, ha b) { return a.dis > b.dis; }
};
long long tot;
long long head[N];
long long dis[N];
bool vis[N];
void Init(long long n) {
  for (long long i = 1; i <= n; ++i) dis[i] = 1;
}
void add(long long from, long long to, long long cost) {
  ++tot;
  edge[tot].to = to;
  edge[tot].dis = cost;
  edge[tot].next = head[from];
  head[from] = tot;
}
priority_queue<ha> q;
void Dijkstra(long long s) {
  dis[s] = 0;
  q.push({s, 0});
  while (!q.empty()) {
    ha tmp = q.top();
    q.pop();
    long long x = tmp.pos;
    if (vis[x]) continue;
    vis[x] = 1;
    for (long long i = head[x]; i; i = edge[i].next) {
      long long y = edge[i].to;
      if (dis[y] > dis[x] + edge[i].dis) {
        dis[y] = dis[x] + edge[i].dis;
        if (!vis[y]) {
          q.push({y, dis[y]});
        }
      }
    }
  }
}
void solve() {
  ios::sync_with_stdio(false), cin.tie(0);
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> w[i].a;
  for (long long i = 1; i <= n; i++) cin >> w[i].t, cnt[++len] = w[i].t;
  sort(w + 1, w + 1 + n, cmp);
  sort(cnt + 1, cnt + 1 + len);
  len = unique(cnt + 1, cnt + 1 + len) - cnt - 1;
  for (long long i = 1; i <= n; i++) {
    long long now = lower_bound(cnt + 1, cnt + 1 + len, w[i].t) - cnt;
    ans += w[i].a * ask(now, 0) - ask(now, 1);
    add(now, w[i].a);
  }
  cout << ans << '\n';
}
signed main() {
  solve();
  return 0;
}
