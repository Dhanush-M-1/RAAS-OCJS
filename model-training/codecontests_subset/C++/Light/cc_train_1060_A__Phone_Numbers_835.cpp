#include <bits/stdc++.h>
int main() {
  int n;
  scanf("%d", &n);
  char num[10000];
  int i, sum = 0;
  scanf("%s", num);
  int max = n / 11;
  for (i = 0; i < n; i++) {
    if (num[i] == '8') sum++;
  }
  if (max > sum) max = sum;
  printf("%d", max);
  return 0;
}
