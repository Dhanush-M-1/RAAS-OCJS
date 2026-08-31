#include <bits/stdc++.h>
int main() {
  int a1, a2, b1, b2, c1, c2;
  scanf("%d%d%d%d%d%d", &a1, &a2, &b1, &b2, &c1, &c2);
  if (c1 == 0 && c2 == 0) {
    if ((a1 == b1 && a2 == b2) || (a1 == -b1 && a2 == -b2) ||
        (a1 == b2 && a2 == -b1) || (a1 == -b2 && a2 == b1))
      printf("YES\n");
    else
      printf("NO\n");
    return 0;
  }
  long long D = (long long)(c1)*c1 + (long long)(c2)*c2;
  int b1a1 = b1 + a1, b1_a1 = b1 - a1, b1a2 = b1 + a2, b1_a2 = b1 - a2,
      b2a2 = b2 + a2, b2_a2 = b2 - a2, b2a1 = b2 + a1, b2_a1 = b2 - a1;
  if (((((b1a1) * (long long)(c1) + (b2a2) * (long long)(c2)) % D) ||
       (((b1a1) * (long long)(c2) - (b2a2) * (long long)(c1)) % D)) &&
      ((((b1_a1) * (long long)(c1) + (b2_a2) * (long long)(c2)) % D) ||
       (((b1_a1) * (long long)(c2) - (b2_a2) * (long long)(c1)) % D)) &&
      ((((b1_a2) * (long long)(c1) + (b2a1) * (long long)(c2)) % D) ||
       (((b1_a2) * (long long)(c2) - (b2a1) * (long long)(c1)) % D)) &&
      ((((b1a2) * (long long)(c1) + (b2_a1) * (long long)(c2)) % D) ||
       (((b1a2) * (long long)(c2) - (b2_a1) * (long long)(c1)) % D)))
    printf("NO\n");
  else
    printf("YES\n");
  return 0;
}
