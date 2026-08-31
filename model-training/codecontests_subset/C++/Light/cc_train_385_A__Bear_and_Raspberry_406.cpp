#include <bits/stdc++.h>
int main() {
  int n, c, max = -1, pt = -1;
  scanf("%d %d", &n, &c);
  int a[n];
  for (int i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  for (int i = 0; i < n - 1; i++) {
    if (a[i] >= a[i + 1]) {
      int s = a[i] - a[i + 1] - c;
      if (max < s) max = s;
    }
  }
  if (max == -1)
    printf("%d", 0);
  else
    printf("%d", max);
  return 0;
}
