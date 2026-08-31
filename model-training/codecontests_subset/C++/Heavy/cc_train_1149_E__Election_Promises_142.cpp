#include <bits/stdc++.h>
using std::cerr;
using std::endl;
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
const int MAXN = 200005;
int n, m, ecnt, head[MAXN], deg[MAXN];
int a[MAXN], sg[MAXN], sum[MAXN];
std::vector<int> ie[MAXN];
struct Edge {
  int to, nxt;
} e[MAXN];
inline void add_edge(int bg, int ed) {
  ++ecnt;
  e[ecnt].to = ed;
  e[ecnt].nxt = head[bg];
  head[bg] = ecnt;
}
std::queue<int> q;
int vis[MAXN];
void topo() {
  while (!q.empty()) q.pop();
  for (int i = (1); i <= (n); ++i)
    if (!deg[i]) q.push(i);
  while (!q.empty()) {
    int x = q.front();
    q.pop();
    for (int i = head[x]; i; i = e[i].nxt) {
      int ver = e[i].to;
      vis[sg[ver]] = x;
    }
    for (int i = (0); i <= (1e9); ++i) {
      if (vis[i] != x) {
        sg[x] = i;
        break;
      }
    }
    sum[sg[x]] ^= a[x];
    for (int i = (0); i <= ((int)ie[x].size() - 1); ++i) {
      int ver = ie[x][i];
      --deg[ver];
      if (!deg[ver]) q.push(ver);
    }
  }
}
int main() {
  n = read(), m = read();
  for (int i = (1); i <= (n); ++i) a[i] = read();
  for (int i = (1); i <= (m); ++i) {
    int u = read(), v = read();
    add_edge(u, v);
    ie[v].push_back(u);
    ++deg[u];
  }
  topo();
  int max_sg = -1;
  for (int i = (n - 1); i >= (0); --i) {
    if (sum[i]) {
      max_sg = i;
      break;
    }
  }
  if (max_sg == -1) {
    printf("LOSE\n");
    return 0;
  }
  printf("WIN\n");
  for (int i = (1); i <= (n); ++i) {
    if (sg[i] == max_sg && (a[i] ^ sum[max_sg]) < a[i]) {
      a[i] ^= sum[max_sg];
      sum[max_sg] = 0;
      for (int j = head[i]; j; j = e[j].nxt) {
        int ver = e[j].to;
        a[ver] ^= sum[sg[ver]];
        sum[sg[ver]] = 0;
      }
    }
  }
  for (int i = (1); i <= (n); ++i) printf("%d ", a[i]);
  putchar('\n');
  return 0;
}
