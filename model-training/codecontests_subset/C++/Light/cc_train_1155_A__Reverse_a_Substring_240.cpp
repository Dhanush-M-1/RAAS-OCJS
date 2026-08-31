#include <bits/stdc++.h>
int main() {
  int l;
  scanf("%d", &l);
  char a[l];
  scanf("%s", a);
  int flag = 0;
  int b, c;
  for (int i = 0; i < l - 1; i++) {
    if (a[i + 1] < a[i]) {
      flag = 1;
      b = i + 1;
      c = b + 1;
      break;
    }
  }
  if (flag == 0)
    printf("NO\n");
  else {
    printf("YES\n%d %d", b, c);
  }
  return 0;
}
