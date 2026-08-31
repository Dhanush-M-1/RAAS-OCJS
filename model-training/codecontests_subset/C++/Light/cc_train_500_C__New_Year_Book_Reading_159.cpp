#include <bits/stdc++.h>
using namespace std;
int n, m;
int w[1010];
int b[1010];
bool vis[1010];
int s[1010];
stack<int> s1, s2;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &w[i]);
  }
  for (int i = 1; i <= m; i++) scanf("%d", &b[i]);
  int ans = 0;
  int id;
  int where;
  int num = 0;
  int all = 0;
  for (int j = 1; j <= m; j++) {
    id = b[j];
    if (!vis[id]) {
      ans += all;
      all += w[id];
      vis[id] = 1;
      s1.push(id);
    } else {
      for (;;) {
        int t = s1.top();
        s1.pop();
        if (t == id) {
          while (!s2.empty()) {
            s1.push(s2.top());
            s2.pop();
          }
          s1.push(id);
          break;
        } else {
          s2.push(t);
          ans += w[t];
        }
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
