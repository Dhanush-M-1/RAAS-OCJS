#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e6 + 100;
const int inf = 0x3f3f3f3f;
const int iinf = 1 << 30;
const long long linf = 2e18;
const long long mod = 998244353;
const double eps = 1e-7;
template <class T = int>
T read() {
  T f = 1, a = 0;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    a = (a << 3) + (a << 1) + ch - '0';
    ch = getchar();
  }
  return a * f;
}
int n;
vector<int> edge[maxn];
int vis[maxn];
double ans;
int in[maxn], pos[maxn], len;
int dep[maxn], top[maxn];
void find(int now, int step) {
  pos[now] = step;
  for (int to : edge[now]) {
    if (!in[to] || pos[to]) continue;
    find(to, step + 1);
  }
}
void get_tree(int now, int cnt, int fa = -1) {
  dep[now] = fa == -1 ? 1 : dep[fa] + 1, top[now] = cnt;
  for (int to : edge[now]) {
    if (to == fa || pos[to]) continue;
    get_tree(to, cnt, now);
  }
}
void init() {
  queue<int> q;
  len = n;
  for (register int i = (0); i <= (n - 1); ++i)
    if (in[i] == 1) q.push(i);
  while (!q.empty()) {
    int now = q.front();
    q.pop();
    len--;
    for (int to : edge[now]) {
      if (!in[now]) continue;
      in[to]--, in[now]--;
      if (in[to] == 1) q.push(to);
    }
  }
  int now = 0;
  for (register int i = (0); i <= (n - 1); ++i)
    if (in[i]) now = i;
  find(now, 1);
  for (register int i = (0); i <= (n - 1); ++i)
    if (pos[i]) get_tree(i, i);
}
void dfs(int now, int way, int start) {
  vis[now] = 1;
  if (top[now] == top[start])
    ans += 1.0 / way;
  else {
    int cir = abs(pos[top[now]] - pos[top[start]]);
    ans += 1.0 / (dep[now] + dep[start] + cir - 1),
        ans += 1.0 / (dep[now] + dep[start] + len - cir - 1);
    ans -= 1.0 / (dep[now] + dep[start] + len - 2);
  }
  for (int to : edge[now])
    if (!vis[to]) dfs(to, way + 1, start);
}
void solve(int now) {
  for (register int i = (0); i <= (n - 1); ++i) vis[i] = 0;
  dfs(now, 1, now);
}
signed main() {
  scanf("%d", &n);
  for (register int i = (1); i <= (n); ++i) {
    int u, v;
    scanf("%d %d", &u, &v);
    edge[u].push_back(v), edge[v].push_back(u);
    in[u]++, in[v]++;
  }
  init();
  for (register int i = (0); i <= (n - 1); ++i) solve(i);
  printf("%.114514lf\n", ans);
  return 0;
}
