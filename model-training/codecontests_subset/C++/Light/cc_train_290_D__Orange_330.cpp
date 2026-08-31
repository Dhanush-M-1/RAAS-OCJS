#include <bits/stdc++.h>
using namespace std;
int main() {
  char str[64];
  int d;
  scanf("%s%d", str, &d);
  for (int i = 0; str[i]; i++)
    if (tolower(str[i]) < 'a' + d)
      printf("%c", toupper(str[i]));
    else
      printf("%c", tolower(str[i]));
  printf("\n");
  return 0;
}
