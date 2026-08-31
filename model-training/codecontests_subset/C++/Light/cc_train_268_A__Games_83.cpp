#include <bits/stdc++.h>
int color[2][100];
int N;
int couter;
int main() {
  scanf("%d", &N);
  couter = 0;
  for (int i = 0; i < N; i++) {
    scanf("%d %d", &color[0][i], &color[1][i]);
  }
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      if (j != i) {
        if (color[0][i] == color[1][j]) couter++;
      }
    }
  }
  printf("%d\n", couter);
  return 0;
}
