#include <bits/stdc++.h>
void tra(int n, int x) {
  int tmp = x;
  int ans[10000];
  int cnt = 0;
  while (tmp) {
    ans[cnt++] = tmp % n;
    tmp /= n;
  }
  for (int i = cnt - 1; i >= 0; --i) printf("%d", ans[i]);
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i < n; ++i) {
    for (int j = 1; j < n; ++j) {
      tra(n, i * j);
      printf(" ");
    }
    printf("\n");
  }
  return 0;
}
