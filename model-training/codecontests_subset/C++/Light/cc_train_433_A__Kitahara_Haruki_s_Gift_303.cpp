#include <bits/stdc++.h>
int main(void) {
  int apple[10000];
  int num, i, ans = 0, k = 0, f = 0, j, flag = 0;
  ;
  scanf("%d", &num);
  for (i = 0; i < num; i++) {
    scanf("%d", &apple[i]);
    if (apple[i] == 100)
      k++;
    else
      f++;
    ans += apple[i];
  }
  ans /= 2;
  for (i = 0; i <= f; i++) {
    for (j = 0; j <= k; j++) {
      if (i * 200 + j * 100 == ans) {
        flag = 1;
        break;
      }
    }
    if (flag) break;
  }
  if (flag)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
