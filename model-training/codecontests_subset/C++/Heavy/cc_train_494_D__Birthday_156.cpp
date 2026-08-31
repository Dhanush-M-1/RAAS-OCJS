#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100005, MAXM = 17, Mod = 1000000007;
int sz[MAXN], fa[MAXN][MAXM], dep[MAXN], q[MAXN], n, m, x, y, c, lca;
long long s[MAXN], sons[MAXN], sonsq[MAXN], fs[MAXN], fsq[MAXN], dis, ans;
struct Edge {
  int y, c;
  Edge *next;
} pool[MAXN << 1], *mem = pool, *first[MAXN] = {0};
inline void addedge(int a, int b, int c) {
  mem->y = b;
  mem->c = c;
  mem->next = first[a];
  first[a] = mem++;
  mem->y = a;
  mem->c = c;
  mem->next = first[b];
  first[b] = mem++;
}
void dfs(int cur, int depth, int sum) {
  dep[cur] = depth;
  s[cur] = sum;
  for (int log = 1; (1 << log) <= depth; ++log)
    fa[cur][log] = fa[fa[cur][log - 1]][log - 1];
  sz[cur] = 1;
  for (Edge *j = first[cur]; j; j = j->next)
    if (j->y != fa[cur][0]) {
      fa[j->y][0] = cur;
      dfs(j->y, depth + 1, (sum + j->c) % Mod);
      sz[cur] += sz[j->y];
      sons[cur] =
          (sons[cur] + (sons[j->y] + (long long)sz[j->y] * j->c % Mod)) % Mod;
      sonsq[cur] += sonsq[j->y] + (j->c * sons[j->y] % Mod) * 2LL % Mod +
                    ((long long)j->c * j->c % Mod) * sz[j->y] % Mod;
      sonsq[cur] %= Mod;
    }
}
void bfs() {
  int head = 0, tail = 0, cur;
  long long tmp, sum;
  q[tail++] = 1;
  fs[1] = 0;
  fsq[1] = 0;
  while (head != tail) {
    cur = q[head++];
    for (Edge *j = first[cur]; j; j = j->next)
      if (j->y != fa[cur][0]) {
        tmp = sonsq[j->y] + (j->c * sons[j->y] % Mod) * 2LL % Mod +
              ((long long)j->c * j->c % Mod) * sz[j->y] % Mod;
        sum = (((long long)sz[j->y] * j->c % Mod) + sons[j->y]) % Mod;
        fs[j->y] =
            fs[cur] + sons[cur] - sum + (long long)j->c * (n - sz[j->y]) % Mod;
        fs[j->y] %= Mod;
        fsq[j->y] = fsq[cur] + sonsq[cur] - tmp +
                    ((fs[cur] + sons[cur] - sum) * j->c % Mod) * 2LL % Mod +
                    ((long long)j->c * j->c % Mod) * (n - sz[j->y]) % Mod;
        fsq[j->y] %= Mod;
        q[tail++] = j->y;
      }
  }
}
int getLCA(int a, int b) {
  int i, log;
  if (dep[a] < dep[b]) {
    a = a + b;
    b = a - b;
    a = a - b;
  }
  for (log = 0; (1 << (log + 1)) <= dep[a]; ++log)
    ;
  for (i = log; i >= 0; --i)
    if ((1 << i) <= dep[a] && dep[fa[a][i]] >= dep[b]) a = fa[a][i];
  if (a == b) return a;
  for (i = log; i >= 0; --i)
    if (dep[a] >= (1 << i) && fa[a][i] != fa[b][i]) a = fa[a][i], b = fa[b][i];
  return fa[a][0];
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; ++i) {
    scanf("%d%d%d", &x, &y, &c);
    addedge(x, y, c);
  }
  dfs(1, 0, 0);
  bfs();
  scanf("%d", &m);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d", &x, &y);
    lca = getLCA(x, y);
    if (lca == y) {
      dis = s[x] - s[y];
      ans = (sonsq[x] + fsq[x] -
             (2LL *
              (fsq[y] + (fs[y] * dis % Mod) * 2LL % Mod +
               (dis * dis % Mod) * (n - sz[y])) %
              Mod)) %
            Mod;
    } else {
      dis = (s[x] + s[y] - 2 * s[lca]) % Mod;
      ans = ((2LL *
              (sonsq[y] + (2LL * (sons[y] * dis % Mod) % Mod) +
               (dis * dis % Mod) * sz[y] % Mod) %
              Mod) -
             (sonsq[x] + fsq[x])) %
            Mod;
    }
    printf("%I64d\n", (ans + Mod) % Mod);
  }
  return 0;
}
