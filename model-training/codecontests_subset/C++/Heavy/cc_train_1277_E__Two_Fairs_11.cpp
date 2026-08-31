#include <bits/stdc++.h>
const long long maxn = 2e6 + 9, inf = 0x3f3f3f3f;
long long Read() {
  long long x(0), f(1);
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = (x << 3ll) + (x << 1ll) + c - '0';
    c = getchar();
  }
  return x * f;
}
long long T, n, m;
struct node {
  long long to, nxt;
} dis[maxn];
long long num, tim, N, tot, a, b, flag;
long long visit[maxn], dfn[maxn], low[maxn], head[maxn], ge[maxn];
void Add(long long u, long long v) {
  dis[++num] = (node){v, head[u]};
  head[u] = num;
}
void Dfs(long long u, long long ff) {
  flag |= (u == ff);
  visit[u] = 1;
  ++tot;
  for (long long i = head[u]; i; i = dis[i].nxt) {
    long long v(dis[i].to);
    if (!visit[v]) Dfs(v, ff);
  }
}
void solve() {
  for (long long i = 1; i <= n; ++i) visit[i] = 0;
  visit[a] = 1;
  long long N(0), Tmp, flag1(0);
  for (long long i = head[a]; i; i = dis[i].nxt) {
    long long v(dis[i].to);
    if (!visit[v]) {
      flag = 0;
      tot = 0;
      Dfs(v, b);
      N += tot;
      if (flag) Tmp = tot, flag1 = 1;
    }
  }
  if (flag1) {
    long long N1(N - Tmp);
    N = flag1 = 0;
    for (long long i = 1; i <= n; ++i) visit[i] = 0;
    visit[b] = 1;
    for (long long i = head[b]; i; i = dis[i].nxt) {
      long long v(dis[i].to);
      if (!visit[v]) {
        flag = 0;
        tot = 0;
        Dfs(v, a);
        N += tot;
        if (flag) Tmp = tot, flag1 = 1;
      }
    }
    if (flag1) {
      long long N2(N - Tmp);
      printf("%lld\n", N1 * N2);
    } else
      puts("0");
  } else
    puts("0");
}
int main() {
  T = Read();
  while (T--) {
    n = Read();
    m = Read();
    a = Read();
    b = Read();
    num = tim = 0;
    for (long long i = 1; i <= n; ++i) head[i] = dfn[i] = low[i] = ge[i] = 0;
    for (long long i = 1; i <= m; ++i) {
      long long u(Read()), v(Read());
      Add(u, v);
      Add(v, u);
    }
    solve();
  }
  return 0;
}
