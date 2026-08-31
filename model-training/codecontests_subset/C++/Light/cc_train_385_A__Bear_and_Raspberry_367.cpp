#include <bits/stdc++.h>
int main() {
  int cost[101], i, count, must, max1 = 0;
  scanf("%d%d", &count, &must);
  for (i = 0; i < count; ++i) scanf("%d", &cost[i]);
  for (i = 0; i < count - 1; ++i)
    if (cost[i] - cost[i + 1] - must > max1)
      max1 = cost[i] - cost[i + 1] - must;
  if (max1 <= 0)
    printf("0");
  else
    printf("%d", max1);
}
