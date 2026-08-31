#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, w[1111], b[1111], seq[1111], dir[1111], cnt = 0, ans = 0;
  bool exist[1111] = {0};
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", w + i);
  for (int i = 1; i <= m; i++) scanf("%d", b + i);
  for (int i = 1; i <= m; i++)
    if (!exist[b[i]]) {
      exist[b[i]] = 1;
      seq[++cnt] = b[i];
      dir[b[i]] = cnt;
    }
  for (int i = 1; i <= m; i++)
    if (seq[1] != b[i]) {
      for (int j = dir[b[i]] - 1; j >= 1; j--) {
        ans += w[seq[j]];
        seq[j + 1] = seq[j];
        dir[seq[j + 1]] = j + 1;
      }
      seq[1] = b[i];
      dir[b[i]] = 1;
    }
  printf("%d\n", ans);
  return 0;
}
