#include <bits/stdc++.h>
char array[200005];
int main() {
  long i, j, k, l, m, n, a, f;
  scanf("%ld", &n);
  scanf("%s", array);
  i = 0;
  a = 0;
  f = 0;
  for (j = 0; j < n; j++) {
    if (array[j] == 'A')
      a++;
    else if (array[j] == 'I')
      i++;
    else
      f++;
  }
  if (i > 1) {
    printf("0\n");
  } else if (i == 1) {
    printf("1\n");
  } else {
    printf("%ld\n", a);
  }
  return 0;
}
