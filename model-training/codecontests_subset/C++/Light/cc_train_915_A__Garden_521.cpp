#include <bits/stdc++.h>
int main() {
  int n, l;
  scanf("%d", &n);
  scanf("%d", &l);
  int temp, buckets[n], i;
  for (i = 0; i < n; i++) {
    scanf("%d", &buckets[i]);
  }
  for (i = 0; i < n; i++) {
    if (l % buckets[i] == 0) {
      continue;
    } else {
      buckets[i] = -9999999;
    }
  }
  temp = buckets[0];
  i = 1;
  while (i < n) {
    if (buckets[i] != -9999999) {
      temp = (temp > buckets[i]) ? temp : buckets[i];
      i++;
    } else {
      i++;
      continue;
    }
  }
  printf("%d", l / temp);
}
