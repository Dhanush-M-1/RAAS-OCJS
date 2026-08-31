#include <bits/stdc++.h>
using namespace std;
int was[1111], pr[1111], l[1111], ln = 0, dep[1111], tail[1111], f[1111];
int n, x, add = 0;
int dfs(int x) {
  if (x == 0) return 0;
  was[x] = true;
  return dep[x] = dfs(pr[x]) + 1;
}
int main() {
  scanf("%d%d", &n, &x);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &pr[i]);
    tail[pr[i]] = true;
  }
  for (int i = 1; i <= n; ++i)
    if (!tail[i]) {
      bool clev = (dep[x] == 0);
      dfs(i);
      if (clev && dep[x] != 0) {
        add = dep[x];
      } else {
        l[ln++] = dep[i];
      }
    }
  f[0] = 1;
  for (int i = 0; i < ln; ++i) {
    for (int j = n; j >= l[i]; j--) f[j] |= f[j - l[i]];
  }
  for (int i = 0; i <= n; ++i) {
    if (f[i]) {
      cout << i + add << endl;
    }
  }
  return 0;
}
