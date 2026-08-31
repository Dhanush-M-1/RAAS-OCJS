#include <bits/stdc++.h>
char str[200010];
int main() {
  int n, i, I = 0, A = 0, answer = 0;
  scanf("%d%s", &n, str);
  for (i = 0; i < n; i++)
    if (str[i] == 'I')
      I++;
    else if (str[i] == 'A')
      A++;
  if (I == 1)
    answer = 1;
  else if (I > 1)
    answer = 0;
  else
    answer = A;
  printf("%d\n", answer);
}
