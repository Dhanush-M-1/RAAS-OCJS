#include <bits/stdc++.h>
using namespace std;
int a[5005], n, m, diff[5005];
int cmd[5005], li[5005], ri[5005], z[5005];
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i < (int)n + 1; i++) a[i] = 1000000000;
  for (int i = 0; i < (int)m; i++) {
    scanf("%d %d %d %d", &cmd[i], &li[i], &ri[i], &z[i]);
    if (cmd[i] == 1)
      for (int j = li[i]; j < (int)ri[i] + 1; j++) diff[j] += z[i];
    else
      for (int j = li[i]; j < (int)ri[i] + 1; j++)
        a[j] = min(a[j], z[i] - diff[j]);
  }
  for (int i = 0; i < (int)m; i++) {
    if (cmd[i] == 1) {
      for (int j = li[i]; j < (int)ri[i] + 1; j++) a[j] += z[i];
    } else {
      int m = -1000000000;
      for (int j = li[i]; j < (int)ri[i] + 1; j++) m = max(m, a[j]);
      if (m != z[i]) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  printf("%d", a[1] - diff[1]);
  for (int i = 2; i < (int)n + 1; i++) printf(" %d", a[i] - diff[i]);
  puts("");
  return 0;
}
