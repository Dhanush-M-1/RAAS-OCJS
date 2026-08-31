#include <bits/stdc++.h>
int max(int a, int b) {
  if (a > b)
    return a;
  else
    return b;
}
int N, arr[105], c, i;
int main() {
  int ans = 0;
  scanf("%d %d", &N, &c);
  for (i = 1; i <= N; i++) scanf("%d", &arr[i]);
  int tmp = 0;
  for (i = 1; i < N; i++) {
    tmp = arr[i] - arr[i + 1] - c;
    ans = max(ans, tmp);
  }
  printf("%d\n", ans);
  return 0;
}
