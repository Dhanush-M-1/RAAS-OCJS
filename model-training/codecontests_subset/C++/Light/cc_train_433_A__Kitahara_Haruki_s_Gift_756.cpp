#include <bits/stdc++.h>
int main() {
  int n, w, cnt1, cnt2;
  scanf("%d", &n);
  cnt1 = cnt2 = 0;
  while (n-- > 0) {
    scanf("%d", &w);
    if (w == 100)
      cnt1++;
    else
      cnt2++;
  }
  printf("%s\n", cnt1 % 2 == 0 && (cnt2 % 2 == 0 || cnt1 >= 2) ? "YES" : "NO");
  return 0;
}
