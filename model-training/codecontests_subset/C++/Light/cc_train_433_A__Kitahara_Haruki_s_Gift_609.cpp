#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i;
  scanf("%d", &n);
  int val, count1 = 0, count2 = 0;
  for (i = 1; i <= n; i++) {
    scanf("%d", &val);
    if (val == 200)
      count2++;
    else
      count1++;
  }
  if (count2 % 2 == 0 && count1 % 2 == 0)
    printf("YES\n");
  else if (count2 % 2 == 0 && count1 % 2 != 0)
    printf("NO\n");
  else if (count2 % 2 != 0) {
    if (count1 < 2)
      printf("NO\n");
    else if (count1 == 2)
      printf("YES\n");
    else if (count1 > 2 && count1 % 2 == 0)
      printf("YES\n");
    else
      printf("NO\n");
  }
  return 0;
}
