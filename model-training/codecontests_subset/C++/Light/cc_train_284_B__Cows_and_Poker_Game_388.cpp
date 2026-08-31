#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, k, l, res = 0, in = 0, all = 0;
  scanf("%d", &n);
  char ch[n + 5];
  scanf("%s", ch);
  getchar();
  res = 0;
  for (i = 0; i < n; i++) {
    if (ch[i] == 'A') all++;
    if (ch[i] == 'I') in++;
  }
  if (in == 0)
    res = all;
  else if (in == 1)
    res = 1;
  else
    res = 0;
  printf("%d\n", res);
  return 0;
}
