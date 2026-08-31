#include <bits/stdc++.h>
using namespace std;
char ch[200009];
int main() {
  int n;
  scanf("%d", &n);
  scanf("%s", ch);
  int a = 0, b = 0;
  for (int i = 0; i < n; i++)
    if (ch[i] == 'I') a++;
  for (int i = 0; i < n; i++)
    if (ch[i] == 'A') b++;
  if (a == 1)
    printf("%d\n", a);
  else if (a == 0)
    printf("%d\n", b);
  else
    printf("0\n");
  return 0;
}
