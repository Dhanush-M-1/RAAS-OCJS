#include <bits/stdc++.h>
int x[100000], h[100000];
int main() {
  int N, i, result;
  scanf("%d\n", &N);
  for (i = 0; i < N; i++) scanf("%d %d\n", x + i, h + i);
  result = 0;
  for (i = 0; i < N; i++) {
    if (i == 0 || x[i] - h[i] > x[i - 1])
      result++;
    else if (i + 1 == N || x[i] + h[i] < x[i + 1]) {
      x[i] += h[i];
      result++;
    }
  }
  printf("%d\n", result);
  return 0;
}
