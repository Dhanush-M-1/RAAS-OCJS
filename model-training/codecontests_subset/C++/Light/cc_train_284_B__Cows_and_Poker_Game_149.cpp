#include <bits/stdc++.h>
int main(void) {
  int n, i, q[] = {0, 0, 0}, ans = 0;
  char s[200001];
  scanf("%d", &n);
  scanf("%s", s);
  for (i = 0; i < n; i++) {
    if (s[i] == 'A')
      q[0]++;
    else if (s[i] == 'I')
      q[1]++;
    else
      q[2]++;
  }
  if (q[1] == 0)
    ans = q[0];
  else if (q[1] == 1)
    ans = 1;
  else
    ans = 0;
  printf("%d\n", ans);
  return 0;
}
