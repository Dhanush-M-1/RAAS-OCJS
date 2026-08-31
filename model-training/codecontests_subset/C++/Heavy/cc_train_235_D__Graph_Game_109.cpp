#include <bits/stdc++.h>
using namespace std;
const int N = 3005;
vector<int> g[N];
int n, cirLen, stk[N], top, vis[N], findCir, onCir[N];
double ans;
void dfs(int v, int p) {
  stk[++top] = v;
  vis[v] = 1;
  for (int d : g[v])
    if (d != p) {
      if (!vis[d]) {
        dfs(d, v);
        if (findCir) return;
      } else if (vis[d] == 1) {
        int t;
        do {
          t = stk[top--];
          onCir[t] = 1;
          ++cirLen;
          ;
        } while (t != d);
        findCir = 1;
        return;
      }
    }
  vis[v] = 2;
  --top;
}
void getAns(double x, double y) {
  ;
  if (y <= 1.0)
    ans += 1.0 / x;
  else {
    double z = x - y + cirLen;
    ans -= 1.0 / z;
    ans += 1.0 / x;
    ans += 1.0 / (x - y + cirLen - y + 2);
  }
}
void count(int v, int x, int y) {
  vis[v] = 1;
  ;
  getAns(x, y);
  for (int d : g[v])
    if (!vis[d]) count(d, x + 1, y + onCir[d]);
}
int main(int argc, char *argv[]) {
  scanf("%d", &n);
  for (int i = 1; i <= (n); ++i) {
    int u, v;
    scanf("%d%d", &u, &v);
    ++u, ++v;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  dfs(1, 0);
  for (int i = 1; i <= (n); ++i) {
    memset(vis, 0, sizeof(vis));
    count(i, 1, onCir[i]);
  }
  printf("%.10f\n", ans);
  return 0;
}
