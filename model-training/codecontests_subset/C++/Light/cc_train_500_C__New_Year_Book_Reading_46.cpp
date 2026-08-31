#include <bits/stdc++.h>
using namespace std;
int w[550];
int f[1005], flag[550];
int main() {
  int n, m, i;
  while (scanf("%d%d", &n, &m) != EOF) {
    for (i = 1; i <= n; i++) scanf("%d", &w[i]);
    memset(flag, 0, sizeof(flag));
    queue<int> q, Q;
    for (i = 0; i < m; i++) {
      scanf("%d", &f[i]);
      if (!flag[f[i]]) {
        q.push(f[i]);
        flag[f[i]] = 1;
      }
    }
    int sum = 0;
    int a, b;
    for (i = 0; i < m; i++) {
      int p = 0;
      while (!q.empty()) {
        a = q.front();
        if (a == f[i]) {
          p = 1;
          b = a;
        } else {
          Q.push(a);
          if (!p) sum += w[a];
        }
        q.pop();
      }
      q.push(b);
      while (!Q.empty()) {
        b = Q.front();
        Q.pop();
        q.push(b);
      }
    }
    cout << sum << endl;
  }
  return 0;
}
