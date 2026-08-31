#include <bits/stdc++.h>
using namespace std;
int cnt[20005];
int d[4];
int main() {
  int i, j, k, n, max, v, goal;
  while (scanf("%d", &n) != EOF) {
    for (i = 1; i <= 3; i++) scanf("%d", &d[i]);
    max = 0;
    goal = n * 2;
    memset(cnt, 0, sizeof(cnt));
    cnt[0] = 1;
    for (i = 1; i <= 3; i++) {
      if (i == 1)
        v = 1;
      else if (i == 2)
        v = 2;
      else if (i == 3)
        v = 4;
      for (j = max; j >= 0; j--) {
        if (cnt[j]) {
          for (k = 1; k <= d[i]; k++) {
            if (j + k * v > goal) break;
            cnt[j + k * v] += cnt[j];
          }
        }
      }
      max += v * d[i];
      if (max > goal) max = goal;
    }
    printf("%d\n", cnt[goal]);
  }
  return 0;
}
