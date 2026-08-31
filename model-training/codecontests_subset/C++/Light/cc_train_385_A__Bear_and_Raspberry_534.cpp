#include <bits/stdc++.h>
int main() {
  int n, c, max, i;
  int data[105];
  scanf("%d%d", &n, &c);
  data[0] = 0;
  max = 0;
  for (i = 1; i <= n; i++) {
    scanf("%d", &data[i]);
    if (data[i - 1] - data[i] > max) max = data[i - 1] - data[i];
  }
  if (max - c >= 0)
    printf("%d\n", max - c);
  else
    printf("0\n");
  return 0;
}
