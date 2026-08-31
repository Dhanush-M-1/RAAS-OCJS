#include <bits/stdc++.h>
using namespace std;
int n, m;
char s[630000];
int fa[630000];
int val[630000];
vector<int> belong[630000];
int Push(int x) { return x; }
int Unpush(int x) { return m + x; }
int find(int x) { return x == fa[x] ? x : fa[x] = find(fa[x]); }
bool vis[630000];
void merge(int x, int y) {
  int u = find(x), v = find(y);
  if (u == v) return;
  val[v] += val[u];
  if (vis[u]) vis[v] = 1;
  fa[u] = v;
}
int value(int x) {
  if (vis[find(x)]) return 1000000000;
  return val[find(x)];
}
int main() {
  scanf("%d%d", &n, &m);
  scanf("%s", s + 1);
  for (int i = 1; i <= m + m; i++) fa[i] = i;
  for (int i = 1; i <= m; i++) {
    val[Push(i)] = 1;
    int c;
    scanf("%d", &c);
    for (int j = 1; j <= c; j++) {
      int x;
      scanf("%d", &x);
      belong[x].push_back(i);
    }
  }
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (belong[i].size() == 0) {
    } else if (belong[i].size() == 1) {
      int v = belong[i][0];
      ans -= min(value(Push(v)), value(Unpush(v)));
      if (s[i] == '0') {
        vis[find(Unpush(v))] = 1;
      } else {
        vis[find(Push(v))] = 1;
      }
      ans += min(value(Push(v)), value(Unpush(v)));
    } else {
      int u = belong[i][0], v = belong[i][1];
      if (find(Push(u)) == find(Push(v)) || find(Push(u)) == find(Unpush(v)) ||
          find(Push(v)) == find(Unpush(u)) ||
          find(Unpush(u)) == find(Unpush(v))) {
      } else if (s[i] == '0') {
        ans -= min(value(Push(u)), value(Unpush(u)));
        ans -= min(value(Push(v)), value(Unpush(v)));
        merge(Push(u), Unpush(v));
        merge(Push(v), Unpush(u));
        ans += min(value(Push(u)), value(Unpush(u)));
      } else {
        ans -= min(value(Push(u)), value(Unpush(u)));
        ans -= min(value(Push(v)), value(Unpush(v)));
        merge(Push(u), Push(v));
        merge(Unpush(u), Unpush(v));
        ans += min(value(Push(u)), value(Unpush(u)));
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
