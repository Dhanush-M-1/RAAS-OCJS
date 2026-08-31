#include <bits/stdc++.h>
using namespace std;
const long long nr = 1e6 + 500;
inline long long read() {
  long long ret = 0;
  long long x = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') x = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    ret = ret * 10 + ch - '0';
    ch = getchar();
  }
  return ret * x;
}
long long fir[nr];
long long item = 0;
struct edge {
  long long nxt, to, val;
} p[nr * 2];
void add(long long a, long long b, long long c) {
  ++item;
  p[item].val = c;
  p[item].to = b;
  p[item].nxt = fir[a];
  fir[a] = item;
}
long long leave[nr];
long long low[nr];
bool islve[nr];
long long n, k;
long long depth[nr];
void dfs1(long long now, long long fat) {
  depth[now] = depth[fat] + 1;
  if (islve[now]) {
    low[now] = depth[now];
  }
  for (int tmp = fir[now]; tmp; tmp = p[tmp].nxt) {
    long long v = p[tmp].to;
    if (v == fat) continue;
    dfs1(v, now);
    low[now] = min(low[now], low[v]);
  }
}
void dfs2(long long now, long long fat) {
  if (islve[now]) {
    leave[now] = 1;
  }
  for (int tmp = fir[now]; tmp; tmp = p[tmp].nxt) {
    long long v = p[tmp].to;
    if (v == fat) continue;
    dfs2(v, now);
    if (low[v] - depth[now] <= k) {
      leave[now] += leave[v];
      leave[v] = 0;
    }
  }
}
long long dfsans(long long now) {
  long long maxx = 0;
  for (int tmp = fir[now]; tmp; tmp = p[tmp].nxt) {
    long long v = p[tmp].to;
    maxx = max(maxx, dfsans(v));
  }
  return maxx + leave[now];
}
int main() {
  n = read();
  k = read();
  memset(low, 999999, sizeof(low));
  memset(islve, 1, sizeof(islve));
  for (int i = 2; i <= n; i++) {
    long long f = read();
    add(f, i, 1);
    islve[f] = 0;
  }
  dfs1(1, 0);
  dfs2(1, 0);
  cout << dfsans(1);
  return 0;
}
