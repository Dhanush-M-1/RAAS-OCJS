#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e6 + 5;
int n, K, tot, head[MAX], d[MAX], cnt[MAX], cnt_[MAX];
struct P {
  int to, nxt;
} e[MAX];
void init() {
  memset(head, -1, sizeof(head));
  tot = 0;
}
void adde(int u, int v) {
  e[tot].to = v;
  e[tot].nxt = head[u];
  head[u] = tot++;
}
void dfs(int u) {
  if (~head[u]) {
    cnt[u] = cnt_[u] = 0;
    d[u] = 0x3f3f3f3f;
    int tmp = 0;
    for (int i = head[u]; ~i; i = e[i].nxt) {
      int v = e[i].to;
      dfs(v);
      if (d[v] > K)
        cnt_[u] = max(cnt_[u], cnt[v] + cnt_[v]);
      else {
        cnt[u] += cnt[v];
        cnt_[u] = max(cnt_[u], cnt_[v]);
      }
      d[u] = min(d[u], d[v]);
    }
    ++d[u];
  } else {
    d[u] = 1;
    cnt[u] = 1;
    cnt_[u] = 0;
  }
}
int main() {
  int x;
  while (~scanf("%d%d", &n, &K)) {
    init();
    for (int i = 2; i <= n; ++i) {
      scanf("%d", &x);
      adde(x, i);
    }
    dfs(1);
    printf("%d\n", cnt_[1] + cnt[1]);
  }
  return 0;
}
