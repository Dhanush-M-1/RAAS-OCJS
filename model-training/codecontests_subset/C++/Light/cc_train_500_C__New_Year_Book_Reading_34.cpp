#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e3 + 10;
const int MOD = 1e9 + 7;
stack<int> a, bb, mm;
int w[MAX], b[MAX], vis[MAX];
int main() {
  int n, m;
  while (scanf("%d %d", &n, &m) == 2) {
    memset(vis, 0, sizeof(vis));
    for (int i = 1; i <= n; i++) {
      scanf("%d", &w[i]);
    }
    for (int i = 1; i <= m; i++) {
      scanf("%d", &b[i]);
    }
    int cnt = 0;
    for (int i = 1; i <= m; i++) {
      if (!vis[b[i]]) {
        vis[b[i]] = 1;
        cnt++;
        mm.push(b[i]);
      }
      if (cnt == n) break;
    }
    if (cnt < n) {
      for (int i = 1; i <= n; i++) {
        if (!vis[i]) mm.push(i);
      }
    }
    while (!mm.empty()) {
      int x = mm.top();
      mm.pop();
      a.push(x);
    }
    int res = 0;
    for (int i = 1; i <= m; i++) {
      while (true) {
        int x = a.top();
        a.pop();
        if (x == b[i]) break;
        bb.push(x);
        res += w[x];
      }
      while (!bb.empty()) {
        int x = bb.top();
        bb.pop();
        a.push(x);
      }
      a.push(b[i]);
    }
    printf("%d\n", res);
  }
  return 0;
}
