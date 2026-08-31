#include <bits/stdc++.h>
using namespace std;
struct edge {
  int from, to, vis, next;
} e[400020];
int top, head[200020];
vector<int> g[200020];
int in[200020], gg[200020];
int n, m, k;
int ans[200020], cnt;
void add_edge(int from, int to) {
  e[++top].to = to;
  e[top].from = from;
  e[top].next = head[from];
  head[from] = top;
}
void add(int from, int to) {
  add_edge(from, to);
  add_edge(to, from);
}
queue<int> q;
void del(int pos) {
  if (!gg[pos]) cnt--;
  q.push(pos);
  gg[pos] = 1;
  while (!q.empty()) {
    int now = q.front();
    q.pop();
    for (int i = head[now]; ~i; i = e[i].next) {
      if (e[i].vis || gg[e[i].to]) continue;
      in[e[i].to]--;
      e[i].vis = 1;
      e[i ^ 1].vis = 1;
      if (in[e[i].to] < k) {
        cnt--;
        gg[e[i].to] = 1;
        q.push(e[i].to);
      }
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  cnt = n;
  top = -1;
  memset(head, -1, sizeof(head));
  int from, to;
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &from, &to);
    in[from]++, in[to]++;
    add(from, to);
  }
  for (int i = 1; i <= n; i++) {
    if (head[i] == -1) cnt--, gg[i] = 1;
  }
  for (int i = 1; i <= n; i++) {
    if (in[i] < k && !gg[i]) del(i);
  }
  int ttt = m;
  for (int i = 2 * m - 1; i >= 1; i -= 2) {
    ans[ttt--] = cnt;
    if (e[i].vis) continue;
    in[e[i].from]--;
    in[e[i].to]--;
    e[i].vis = e[i ^ 1].vis = 1;
    if (!gg[e[i].from] && in[e[i].from] < k) del(e[i].from);
    if (!gg[e[i].to] && in[e[i].to] < k) del(e[i].to);
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
}
