#include <bits/stdc++.h>
using namespace std;
const int N = 5e5 + 10;
struct Edge {
  int go, next;
} e[N];
int head[N], tot;
void add(int x, int y) {
  e[++tot].go = y;
  e[tot].next = head[x];
  head[x] = tot;
}
int pos[N], num[N], p[N], cnt;
bool cmp(int x, int y) { return pos[x] > pos[y]; }
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    int t;
    scanf("%d", &t);
    pos[t] = i;
  }
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    if (pos[u] < pos[v]) {
      num[u]++;
      add(v, u);
      if (pos[v] == n) {
        p[++cnt] = u;
      }
    }
  }
  sort(p + 1, p + cnt + 1, cmp);
  int ans = 0, t = 0;
  for (int i = 1; i <= cnt; i++) {
    int x = p[i];
    if (num[x] + t == n - pos[x]) {
      ans++;
      t++;
      for (int i = head[x]; i; i = e[i].next) {
        num[e[i].go]--;
      }
    }
  }
  printf("%d", ans);
  return 0;
}
