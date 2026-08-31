#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-8;
const double PI = acos(-1.0);
int a[555], b[555 * 2], c[555 * 2];
bool vis[555];
stack<int> ss;
int main() {
  int n, m, i, ans, j, cnt, tot;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (i = 1; i <= m; i++) {
    scanf("%d", &b[i]);
  }
  memset(vis, false, sizeof(vis));
  while (!ss.empty()) ss.pop();
  ans = 0;
  tot = 0;
  memset(vis, false, sizeof(vis));
  for (i = 1; i <= m; i++) {
    if (!vis[b[i]]) {
      ss.push(b[i]);
      ans += tot;
      tot += a[b[i]];
      vis[b[i]] = true;
    } else {
      cnt = 0;
      while (ss.top() != b[i]) {
        ans += a[ss.top()];
        c[cnt++] = ss.top();
        ss.pop();
      }
      ss.pop();
      for (j = cnt - 1; j >= 0; j--) ss.push(c[j]);
      ss.push(b[i]);
    }
  }
  cout << ans << endl;
}
