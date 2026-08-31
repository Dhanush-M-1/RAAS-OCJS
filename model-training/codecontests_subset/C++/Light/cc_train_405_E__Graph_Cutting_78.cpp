#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100000 + 10;
const int inf = 522133279;
const int mod = 1000000007;
struct edge {
  int s;
  int t;
  int next;
  int vis;
} e[100100 * 2];
int n, m;
int cnt, head[100100];
int color[100100];
void add(int s, int t) {
  e[cnt].s = s;
  e[cnt].t = t;
  e[cnt].next = head[s];
  e[cnt].vis = 0;
  head[s] = cnt++;
}
int dfs(int cur) {
  queue<int> adjacent;
  for (int i = head[cur]; ~i; i = e[i].next) {
    if (!e[i].vis) {
      adjacent.push(e[i].t);
      e[i].vis = e[i ^ 1].vis = 1;
    }
  }
  queue<int> unpair;
  while (!adjacent.empty()) {
    int u = adjacent.front();
    adjacent.pop();
    int w = dfs(u);
    if (w == 0)
      unpair.push(u);
    else
      printf("%d %d %d\n", cur, u, w);
  }
  while (unpair.size() >= 2) {
    int u = unpair.front();
    unpair.pop();
    int v = unpair.front();
    unpair.pop();
    printf("%d %d %d\n", u, cur, v);
  }
  if (unpair.size()) return unpair.front();
  return 0;
}
int main() {
  scanf("%d%d", &n, &m);
  memset(head, -1, sizeof(head));
  for (int i = 0; i < m; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    add(a, b);
    add(b, a);
  }
  if (m % 2)
    puts("No solution");
  else
    dfs(1);
  return 0;
}
