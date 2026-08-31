#include <bits/stdc++.h>
int vec[5010];
int cont[5010] = {0};
int main() {
  int i, j, N, M, t, l, r, x, val, z, k;
  scanf("%d %d", &N, &M);
  for (i = 1; i <= N; i++) {
    vec[i] = 1000000000;
  }
  k = 0;
  for (i = val = 1; i <= M; i++) {
    scanf("%d %d %d %d", &t, &l, &r, &x);
    if (t == 1) {
      for (; l <= r; l++) {
        cont[l] += x;
        k = 1;
      }
    } else {
      for (z = 0; l <= r; l++) {
        if (vec[l] >= x - cont[l]) {
          z = 1;
          vec[l] = x - cont[l];
        }
      }
      val &= z;
      if (val == 0) {
        printf("NO");
        return 0;
      }
    }
  }
  if (k || M == 1) {
    printf("YES\n");
    for (i = 1; i <= N; i++) printf("%d ", vec[i]);
  } else
    printf("NO");
  return 0;
}
