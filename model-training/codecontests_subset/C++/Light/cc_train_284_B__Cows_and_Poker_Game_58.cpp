#include <bits/stdc++.h>
using namespace std;
int n, al, in;
char s[200010];
int main() {
  al = in = 0;
  scanf("%d%s", &n, s);
  for (int i = 0; i < n; i++)
    if (s[i] == 'A')
      al++;
    else if (s[i] == 'I')
      in++;
  if (in == 0)
    printf("%d\n", al);
  else if (in == 1)
    printf("1\n");
  else
    printf("0\n");
  return 0;
}
