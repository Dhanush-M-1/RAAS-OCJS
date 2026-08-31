#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c = 0;
  char x[2];
  scanf("%d", &a);
  gets(x);
  char s[a + 1];
  gets(s);
  if (a < 11)
    printf("0");
  else {
    for (int i = 0; i < a; i++) {
      if (s[i] == '8') c++;
    }
    if ((a / 11) <= c)
      printf("%d\n", a / 11);
    else
      printf("%d", c);
  }
  return 0;
}
