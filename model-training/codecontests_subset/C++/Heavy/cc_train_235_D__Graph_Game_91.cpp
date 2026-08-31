#include <bits/stdc++.h>
using namespace std;
const int MAXN = 3000 + 10;
namespace opt {
int N;
const int alp = 999, MOD = 1004535809;
static int a[MAXN], b[MAXN], w[MAXN], tmp[MAXN];
int Pow(int a, int b) {
  int d = 1;
  for (; b; d = (b & 1) ? (long long)d * a % MOD : d,
            a = (long long)a * a % MOD, b /= 2)
    ;
  return d;
}
void FFT(int *a, int S, int d) {
  if (d == N) return;
  FFT(a, S, d << 1);
  FFT(a, S + d, d << 1);
  for (int i = S, j = S, p = 0; i < N / 2; i += d, j += d << 1, p += d) {
    int G = a[j], K = a[j + d];
    tmp[i] = ((long long)G + (long long)w[p] * K) % MOD;
    tmp[i + N / 2] = ((long long)G + (long long)w[p + N / 2] * K) % MOD;
  }
  for (int i = S; i < N; i += d) a[i] = tmp[i];
}
void conv(int *aa, int *bb, int *c, int n) {
  for (int i = 0; i < n; ++i) a[i] = aa[i], b[i] = bb[i];
  if (n <= 5) {
    for (int i = 0; i < n * 2; ++i) c[i] = 0;
    for (int i = 0; i < n; ++i)
      for (int j = 0; j < n; ++j) c[i + j] += a[i] * b[j];
    for (int i = 0; i < n; ++i) a[i] = b[i] = 0;
    return;
  }
  N = 1;
  for (; N < n; N <<= 1)
    ;
  N <<= 1;
  w[0] = 1;
  w[1] = alp;
  for (int i = N; i <= (1 << 19); i <<= 1, w[1] = (long long)w[1] * w[1] % MOD)
    ;
  for (int i = 2; i < N; ++i) w[i] = (long long)w[i - 1] * w[1] % MOD;
  FFT(a, 0, 1);
  FFT(b, 0, 1);
  for (int i = 0; i < N; ++i) a[i] = (long long)a[i] * b[i] % MOD;
  for (int i = 0; i < N; ++i) b[i] = a[i ? (N - i) : 0];
  FFT(b, 0, 1);
  int InvN = Pow(N, MOD - 2);
  for (int i = 0; i < N; ++i)
    c[i] = (long long)b[i] * InvN % MOD, a[i] = b[i] = 0;
}
}  // namespace opt
vector<int> L;
struct Graph {
  int id, next;
  bool flag;
} g[MAXN * 2];
int st[MAXN], dep[MAXN], bel[MAXN], n, f[MAXN][MAXN], num[MAXN], fa[MAXN];
bool vis[MAXN];
void Add(int tot, int x, int y) {
  g[tot].id = y, g[tot].next = st[x], st[x] = tot, g[tot].flag = true;
}
bool mark[MAXN];
int head, tail, que[MAXN], size[MAXN], h[MAXN];
void work(int x, int y) {
  for (int i = x; i; i = fa[i]) mark[i] = true;
  for (int i = y; i; i = fa[i]) {
    L.push_back(i);
    if (mark[i]) {
      mark[i] = false;
      break;
    }
  }
  reverse(L.begin(), L.end());
  for (int i = x; mark[i]; i = fa[i]) L.push_back(i);
}
void Find_Loop(int S) {
  head = 0, tail = 1, que[1] = S;
  fa[S] = 0;
  vis[S] = true;
  while (head < tail) {
    int x = que[++head];
    for (int i = st[x]; i != -1; i = g[i].next)
      if (g[i].id != fa[x])
        if (vis[g[i].id]) {
          work(x, g[i].id);
          return;
        } else
          vis[g[i].id] = true, fa[g[i].id] = x, que[++tail] = g[i].id;
  }
}
void init() {
  scanf("%d", &n);
  memset(st, -1, sizeof(st));
  for (int i = 1; i <= n; ++i) {
    int x, y;
    scanf("%d%d", &x, &y);
    ++x, ++y;
    Add(i * 2, x, y);
    Add(i * 2 + 1, y, x);
  }
  Find_Loop(1);
  memset(mark, 0, sizeof(mark));
  for (int i = 0; i < (int)L.size(); ++i) mark[L[i]] = true;
  for (int i = 0; i < (int)L.size(); ++i)
    for (int j = st[L[i]]; j != -1; j = g[j].next)
      if (mark[g[j].id]) g[j].flag = false;
  memset(vis, 0, sizeof(vis));
}
double Tohka;
void BFS(int S) {
  head = 0, tail = 1, que[1] = S;
  dep[S] = 0;
  vis[S] = true;
  while (head < tail) {
    int x = que[++head];
    for (int i = st[x]; i != -1; i = g[i].next)
      if (g[i].flag && !vis[g[i].id])
        vis[g[i].id] = true, dep[g[i].id] = dep[x] + 1, que[++tail] = g[i].id;
  }
  for (int t = tail; t >= 1; --t) {
    int x = que[t];
    vis[x] = false;
    size[x] = 1;
    for (int i = st[x]; i != -1; i = g[i].next)
      if (g[i].flag && !vis[g[i].id]) size[x] += size[g[i].id];
  }
}
int Count(int x, int *f) {
  BFS(x);
  for (int i = 1; i <= tail; ++i) ++f[dep[que[i]]];
  int Tohka = 0;
  while (f[Tohka]) ++Tohka;
  return Tohka;
}
int Find_G(int x) {
  BFS(x);
  for (int t = tail; t >= 1; --t) {
    int x = que[t];
    bool flag = true;
    for (int i = st[x]; i != -1; i = g[i].next)
      if (g[i].flag)
        if (size[g[i].id] < size[x] && size[g[i].id] > tail / 2) flag = false;
    if (flag && tail - size[x] <= tail / 2) return x;
  }
}
int Kurumi;
int cnt[100];
void Calc(int *h, int n, int delta, int p, bool flag) {
  for (int i = 0; i < n; ++i)
    Tohka += (double)p * 1.0 / (i + delta) * h[i] * Kurumi,
        h[i] = (!flag) ? 0 : h[i];
}
void solve(int dep, int x, int n) {
  int G = Find_G(x);
  int len = Count(G, h);
  opt::conv(h, h, h, len);
  Calc(h, len * 2, 1, 1, 0);
  for (int i = st[G]; i != -1; i = g[i].next)
    if (g[i].flag) {
      g[i].flag = g[i ^ 1].flag = false;
      len = Count(g[i].id, h);
      opt::conv(h, h, h, len);
      Calc(h, len * 2, 3, -1, 0);
      solve(dep + 1, g[i].id, size[g[i].id]);
    }
}
void solve() {
  Kurumi = 1;
  for (int i = 0; i < (int)L.size(); ++i) {
    num[i] = Count(L[i], f[i]);
    solve(0, L[i], size[L[i]]);
  }
  Kurumi = 2;
  for (int i = 0; i < (int)L.size(); ++i)
    for (int j = i + 1; j < (int)L.size(); ++j) {
      int y = j - i - 1, z = (i - j + (int)L.size()) - 1;
      opt::conv(f[i], f[j], h, max(num[i], num[j]));
      int len = max(num[i], num[j]) * 2;
      Calc(h, len, y + 2, 1, 1);
      Calc(h, len, z + 2, 1, 1);
      Calc(h, len, y + z + 2, -1, 0);
    }
  printf("%.10lf\n", Tohka);
}
int main() {
  init();
  solve();
  fclose(stdin);
  fclose(stdout);
  return 0;
}
