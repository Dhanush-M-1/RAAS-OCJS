#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, count1 = 0, count2 = 0;
  scanf("%d", &n);
  while (n--) {
    scanf("%d", &a);
    if (a == 100)
      count1++;
    else
      count2++;
  }
  if ((count1 + 2 * count2) % 2 != 0)
    printf("NO");
  else {
    if (count2 % 2 == 0)
      printf("YES");
    else if (count1 != 0) {
      printf("YES");
    } else
      printf("NO");
  }
  return 0;
}
