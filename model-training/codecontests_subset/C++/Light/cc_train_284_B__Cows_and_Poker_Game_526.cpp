#include <bits/stdc++.h>
char S[200001];
int a, i, j, n, w;
int main() {
  scanf("%d %s", &n, S);
  for (j = 0; S[j]; j++) {
    if (S[j] == 'I')
      i++;
    else if (S[j] == 'A')
      a++;
  }
  if (i == 1)
    w = 1;
  else if (i > 1)
    w = 0;
  else
    w = a;
  printf("%d\n", w);
  return 0;
}
