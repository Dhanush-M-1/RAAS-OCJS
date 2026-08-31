#include <bits/stdc++.h>
using namespace std;
const int MaxN = 5e5;
const int Inf = 1 << 30;
int mpx[MaxN + 5];
vector<int> s, t[MaxN + 5];
bool cmp(int x, int y) { return x > y; }
int main() {
  int n, m, x, u, v, ans, S, p;
  while (~scanf("%d %d", &n, &m)) {
    ans = 0;
    for (int i = 1; i <= n; i++) {
      scanf("%d", &x);
      mpx[x] = i;
      t[i].clear();
    }
    for (int i = 1; i <= m; i++) {
      scanf("%d %d", &u, &v);
      t[mpx[u]].push_back(mpx[v]);
    }
    for (int i = 1; i <= n; i++) sort(t[i].begin(), t[i].end(), cmp);
    s.clear();
    s.push_back(n);
    p = 1;
    for (int i = n - 1; i >= 1; i--) {
      x = 0;
      S = t[i].size();
      for (int j = 0; j < S; j++) {
        if (s[x] == t[i][j]) {
          if (++x == p) {
            ans++;
            break;
          }
        } else if (s[x] > t[i][j])
          break;
      }
      if (x != p) {
        p++;
        s.push_back(i);
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
