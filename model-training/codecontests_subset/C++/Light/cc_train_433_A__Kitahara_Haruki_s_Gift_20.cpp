#include <bits/stdc++.h>
using namespace std;
int n, t, a = 0, b = 0;
int main() {
  scanf("%d", &n);
  while (n > 0) {
    scanf("%d", &t);
    if (t == 100)
      a++;
    else
      b++;
    n--;
  }
  if (a % 2 == 0) {
    if (b % 2 == 0)
      printf("YES");
    else {
      if (a > 1)
        printf("YES");
      else
        printf("NO");
    }
  } else
    printf("NO");
  return 0;
}
