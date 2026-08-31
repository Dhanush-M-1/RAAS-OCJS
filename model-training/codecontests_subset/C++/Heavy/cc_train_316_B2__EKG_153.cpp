#include <bits/stdc++.h>
using namespace std;
int p[1010], a[1010], n, x, m, all;
vector<int> ans, cnt;
bool f[1010];
int main() {
  scanf("%d%d", &n, &x);
  cnt.clear();
  ans.clear();
  memset(p, 0, sizeof(p));
  memset(a, 0, sizeof(a));
  int c, i, y, cc;
  for (i = 1; i <= n; i++) {
    scanf("%d", &c);
    p[i] = c;
    a[c] = i;
  }
  c = 1;
  for (i = x; p[i]; i = p[i]) c++;
  p[i] = -1;
  for (i = 1; i <= n; i++)
    if (p[i] == 0) {
      cc = 1;
      for (int j = i; a[j]; j = a[j]) cc++;
      cnt.push_back(cc);
    }
  memset(f, false, sizeof(f));
  f[0] = true;
  for (int i = 0; i < cnt.size(); i++) {
    for (int j = n; j >= cnt[i]; j--) f[j] = f[j] || f[j - cnt[i]];
  }
  ans.push_back(c);
  for (int i = 1; i <= n - c; i++)
    if (f[i]) ans.push_back(i + c);
  sort(ans.begin(), ans.end());
  m = unique(ans.begin(), ans.end()) - ans.begin();
  for (int i = 0; i < m; i++) printf("%d\n", ans[i]);
  return 0;
}
