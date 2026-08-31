#include <bits/stdc++.h>
const int N = 150;
int a[N];
int main(void) {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%d", &a[i]);
  }
  for (int k = 0;; ++k) {
    int s1 = 0, s2 = 0;
    bool fl = true;
    for (int i = 0; i < n; ++i) {
      s1 += a[i];
      s2 += k - a[i];
      if (k - a[i] < 0) {
        fl = false;
      }
    }
    if (!fl) {
      continue;
    }
    if (s1 < s2) {
      printf("%d\n", k);
      break;
    }
  }
  return 0;
}
