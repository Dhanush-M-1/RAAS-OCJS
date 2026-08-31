#include <bits/stdc++.h>
int main() {
  int N;
  scanf("%d", &N);
  int gu[N], hu[N], i, j, ct = 0;
  for (i = 0; i < N; i++) {
    scanf("%d %d\n", &hu[i], &gu[i]);
  }
  for (i = 0; i < N; i++) {
    for (j = 0; j < N; j++) {
      if (hu[i] == gu[j] && i != j) ct++;
    }
  }
  printf("%d\n", ct);
  return 0;
}
