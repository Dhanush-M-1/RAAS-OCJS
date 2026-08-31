#include <bits/stdc++.h>
using namespace std;
const int siz = 5e5 + 5;
int nex[siz], to[siz], head[siz], t[siz], cnt, n, m;
set<pair<int, int> > s;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &t[i]);
  for (int i = 1, a, b; i <= m; i++) {
    scanf("%d%d", &a, &b);
    s.insert(make_pair(a, b));
  }
  int ans = 0;
  for (int i = n - 1; i >= 1; i--) {
    int k = i;
    while (k < n - ans && s.count(make_pair(t[k], t[k + 1]))) {
      swap(t[k], t[k + 1]);
      k++;
    }
    if (k == n - ans) ans++;
  }
  printf("%d", ans);
  return 0;
}
