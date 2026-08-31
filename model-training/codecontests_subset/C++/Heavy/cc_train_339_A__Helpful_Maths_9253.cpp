#include <bits/stdc++.h>
int main() {
  int i, one, two, three;
  char ch[150];
  while (scanf("%s", ch) == 1) {
    one = 0;
    two = 0;
    three = 0;
    for (i = 0; ch[i] != '\0'; i++) {
      if (ch[i] == '1')
        one++;
      else if (ch[i] == '2')
        two++;
      else if (ch[i] == '3')
        three++;
    }
    if (one != 0) {
      for (i = 0; i < one - 1; i++) printf("1+");
      if ((two == 0) && (three == 0))
        printf("1");
      else
        printf("1+");
    }
    if (two != 0) {
      for (i = 0; i < two - 1; i++) printf("2+");
      if (three == 0)
        printf("2");
      else
        printf("2+");
    }
    if (three != 0) {
      for (i = 0; i < three - 1; i++) printf("3+");
      printf("3");
    }
    printf("\n");
  }
  return 0;
}
