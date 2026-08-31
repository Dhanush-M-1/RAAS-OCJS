#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5, maxm = 2e5 + 5;
int head[maxn], nume;
struct edge {
  int v, w, c, next;
} e[maxm];
inline void init_edge() {
  memset(head, -1, sizeof head);
  nume = 0;
}
inline void add_edge(int u, int v, int w = 0, int c = 0) {
  e[nume].v = v;
  e[nume].w = w;
  e[nume].c = c;
  e[nume].next = head[u];
  head[u] = nume++;
}
int c[maxn], h[maxn];
long long sg[maxn], a[maxn];
void dfs(int u) {
  if (h[u] >= 0) return;
  for (int i = head[u]; ~i; i = e[i].next) {
    int v = e[i].v;
    dfs(v);
  }
  for (int i = head[u]; ~i; i = e[i].next) {
    int v = e[i].v;
    c[h[v]]++;
  }
  for (int i = 0;; i++) {
    if (c[i] == 0) {
      h[u] = i;
      break;
    }
  }
  for (int i = head[u]; ~i; i = e[i].next) {
    int v = e[i].v;
    c[h[v]]--;
  }
}
int n, m;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &a[i]);
  }
  init_edge();
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    add_edge(u, v);
  }
  for (int i = 1; i <= n; i++) h[i] = -1;
  for (int i = 1; i <= n; i++) {
    if (h[i] == -1) dfs(i);
  }
  for (int i = 1; i <= n; i++) {
    sg[h[i]] ^= a[i];
  }
  for (int i = n; i >= 0; i--) {
    if (sg[i] != 0) {
      printf("WIN\n");
      for (int j = 1; j <= n; j++) {
        if (h[j] == i && (a[j] ^ sg[i]) < a[j]) {
          a[j] ^= sg[i];
          sg[i] = 0;
          for (int k = head[j]; ~k; k = e[k].next) {
            int v = e[k].v;
            a[v] ^= sg[h[v]];
            sg[h[v]] = 0;
          }
          break;
        }
      }
      for (int j = 1; j <= n; j++) printf("%lld ", a[j]);
      break;
    }
    if (i == 0) {
      printf("LOSE");
      break;
    }
  }
}
