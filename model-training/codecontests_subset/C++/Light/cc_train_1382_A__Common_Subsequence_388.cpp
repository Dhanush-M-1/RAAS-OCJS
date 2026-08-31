#include <bits/stdc++.h>
using namespace std;
const int N = 1010, INF = 0x3f3f3f3f;
int f[N];
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int n, m, res = INF, flag = 0;
    int a[N], b[N];
    scanf("%d%d", &n, &m);
    memset(f, 0, sizeof f);
    for (int i = 0; i < n; i++) {
      scanf("%d", &a[i]);
      f[a[i]] = 1;
    }
    for (int i = 0; i < m; i++) {
      scanf("%d", &b[i]);
      if (f[b[i]] == 1 && b[i] < res) {
        res = b[i];
        flag = 1;
      }
    }
    if (flag)
      printf("YES\n1 %d\n", res);
    else
      puts("NO");
  }
  return 0;
}
