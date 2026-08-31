#include <bits/stdc++.h>
int main() {
  int a[100];
  char s[105], i, k = 0, j, temp;
  scanf("%s", s);
  for (i = 0; i < strlen(s); i += 2) a[k++] = (int)(s[i] - '0');
  for (i = 0; i < k; i++)
    for (j = (i + 1); j < k; j++) {
      if (a[i] >= a[j]) {
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
    }
  k = 0;
  for (i = 1; i < strlen(s); i += 2) {
    printf("%d%c", a[k], s[i]);
    k++;
  }
  printf("%d", a[k]);
  return 0;
}
