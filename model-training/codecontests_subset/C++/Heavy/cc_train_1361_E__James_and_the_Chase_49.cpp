#include <bits/stdc++.h>
using namespace std;
int n, m;
struct Edge {
  int v, nxt;
} e[200010];
int tot;
int first[100010];
void build(int u, int v) {
  e[++tot] = (Edge){v, first[u]};
  first[u] = tot;
  return;
}
int dep[100010];
bool insta[100010];
bool ok;
void dfs(int u, int lst) {
  dep[u] = dep[lst] + 1;
  insta[u] = true;
  for (int i = first[u]; i; i = e[i].nxt) {
    int v = e[i].v;
    if (!dep[v])
      dfs(v, u);
    else if (!insta[v])
      ok = false;
  }
  insta[u] = false;
  return;
}
int cnt[100010];
int top[100010];
void work1(int u) {
  top[u] = u;
  cnt[u] = 0;
  for (int i = first[u]; i; i = e[i].nxt) {
    int v = e[i].v;
    if (dep[v] < dep[u]) {
      cnt[v]--;
      cnt[u]++;
      if (dep[v] < dep[top[u]]) top[u] = v;
    } else {
      work1(v);
      cnt[u] += cnt[v];
      if (dep[top[v]] < dep[top[u]]) top[u] = top[v];
    }
  }
  return;
}
bool able[100010];
void work2(int u) {
  able[u] = true;
  able[u] = (able[top[u]]) && (cnt[u] < 2);
  for (int i = first[u]; i; i = e[i].nxt) {
    int v = e[i].v;
    if (dep[v] < dep[u]) continue;
    work2(v);
  }
  return;
}
bool check(int S) {
  for (int i = 1; i <= n; i++) dep[i] = 0;
  ok = true;
  dfs(S, 0);
  return ok;
}
int rnd() { return rand() % 10000 + rand() * 10000; }
void solve() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    build(u, v);
  }
  int S = 0, tim = 100;
  while (tim--) {
    int x = rnd() % n + 1;
    if (check(x)) {
      S = x;
      break;
    }
  }
  if (!S)
    printf("-1\n");
  else {
    work1(S);
    work2(S);
    int res = 0;
    for (int i = 1; i <= n; i++)
      if (able[i]) res++;
    if (res * 5 < n)
      printf("-1\n");
    else {
      for (int i = 1; i <= n; i++)
        if (able[i]) printf("%d ", i);
      printf("\n");
    }
  }
  for (int i = 1; i <= n; i++) first[i] = top[i] = cnt[i] = able[i] = 0;
  return;
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) solve();
  return 0;
}
