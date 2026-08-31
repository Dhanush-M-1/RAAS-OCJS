#include <bits/stdc++.h>
int main() {
  char a[100];
  int l, t;
  scanf("%s", &a);
  l = strlen(a);
  for (int i = 0; i < l - 2; i += 2)
    for (int j = i + 2; j < l; j += 2) {
      if (a[i] > a[j]) {
        t = a[i];
        a[i] = a[j];
        a[j] = t;
      }
    }
  printf("%s\n", a);
  return 0;
}
