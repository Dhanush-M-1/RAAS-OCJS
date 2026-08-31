#include <bits/stdc++.h>
using std::max;
using std::min;
using std::queue;
using std::stack;
const int N = 1e6 + 10;
const int M = N << 2;
const int LOGN = 22;
void file(const char *str) {
  char in[100], out[100];
  sprintf(in, "%s.in", str), sprintf(out, "%s.out", str);
  freopen(in, "r", stdin), freopen(out, "w", stdout);
}
const int _IB = 1e6;
char _ibuf[_IB], *_s, *_t;
long long read() {
  long long a = 0;
  int op = 1;
  char ch =
      (_s == _t && (_t = (_s = _ibuf) + fread(_ibuf, 1, _IB, stdin), _s == _t)
           ? EOF
           : *_s++);
  while (ch < '0' || '9' < ch) {
    if (ch == '-') op = -1;
    ch =
        (_s == _t && (_t = (_s = _ibuf) + fread(_ibuf, 1, _IB, stdin), _s == _t)
             ? EOF
             : *_s++);
  }
  while ('0' <= ch && ch <= '9') {
    a = (a << 3) + (a << 1) + (48 ^ ch);
    ch =
        (_s == _t && (_t = (_s = _ibuf) + fread(_ibuf, 1, _IB, stdin), _s == _t)
             ? EOF
             : *_s++);
  }
  return a * op;
}
struct L {
  int to, next;
};
struct Graph {
  L l[M];
  int head[N];
  int lcount;
} g[2];
void add(Graph &g, int from, int to) {
  g.l[++g.lcount].to = to;
  g.l[g.lcount].next = g.head[from];
  g.head[from] = g.lcount;
}
int n, k;
int f[N][LOGN];
long long value[N];
int low[N];
int dfn[N];
int dfn_count;
int color[N];
int color_count;
int sum[N];
long long dp[N];
long long ans;
stack<int> s;
bool is_in[N];
int in[N];
void build(int now = 1) {
  for (int i = 1; i < LOGN; i++) f[now][i] = f[f[now][i - 1]][i - 1];
  for (int i = g[0].head[now], to; to = g[0].l[i].to, i; i = g[0].l[i].next) {
    f[to][0] = now;
    build(to);
  }
  if (!g[0].head[now]) {
    value[now] = 1;
    int x = now;
    for (int i = 0; i < LOGN; i++)
      if (k & (1 << i)) x = f[x][i];
    add(g[0], now, max(1, x));
  }
}
void dfs(int now) {
  is_in[now] = 1;
  low[now] = dfn[now] = ++dfn_count;
  s.push(now);
  for (int i = g[0].head[now], to; to = g[0].l[i].to, i; i = g[0].l[i].next) {
    if (!dfn[to]) {
      dfs(to);
      low[now] = min(low[now], low[to]);
    } else if (is_in[to]) {
      low[now] = min(low[now], dfn[to]);
    }
  }
  if (dfn[now] == low[now]) {
    ++color_count;
    while (1) {
      is_in[s.top()] = 0;
      color[s.top()] = color_count;
      if (s.top() == now) {
        s.pop();
        break;
      }
      s.pop();
    }
  }
}
void make() {
  for (int i = 1; i <= n; i++) {
    sum[color[i]] += value[i];
    for (int j = g[0].head[i], to; to = g[0].l[j].to, j; j = g[0].l[j].next) {
      if (color[i] != color[to]) {
        add(g[1], color[i], color[to]);
        in[color[to]]++;
      }
    }
  }
}
void DAG() {
  queue<int> q;
  for (int i = 1; i <= color_count; i++) {
    if (!in[i]) {
      dp[i] = sum[i];
      q.push(i);
    }
  }
  int now;
  while (!q.empty()) {
    now = q.front();
    q.pop();
    for (int i = g[1].head[now], to; to = g[1].l[i].to, i; i = g[1].l[i].next) {
      in[to]--;
      if (!in[to]) {
        q.push(to);
      }
      dp[to] = max(dp[to], dp[now] + sum[to]);
    }
  }
}
void input() {
  n = read();
  k = read();
  for (int i = 2; i <= n; i++) add(g[0], read(), i);
}
void ini() {}
void solve() {
  build();
  dfs(1);
  make();
  DAG();
  for (int i = 1; i <= color_count; i++) ans = max(ans, dp[i]);
}
void output() { printf("%lld\n", ans); }
void test() {
  input();
  ini();
  solve();
  output();
}
void all() {
  file("J");
  test();
}
int main() {
  test();
  return 0;
}
