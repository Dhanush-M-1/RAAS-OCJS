#include <bits/stdc++.h>
int main() {
  int n;
  scanf("%d", &n);
  int ansa = 0;
  int ansb = 0;
  int a;
  for (int i = 0; i < n; i++) {
    scanf("%d", &a);
    if (a <= 500000) {
      ansa = ansa > (a - 1) ? ansa : (a - 1);
    } else {
      ansb = ansb > (1000000 - a) ? ansb : (1000000 - a);
    }
  }
  printf("%d", ansa > ansb ? ansa : ansb);
  return 0;
}
