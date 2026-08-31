#include <bits/stdc++.h>
int main() {
  char s[100];
  int ones = 0, twos = 0, threes = 0, pluses = 0;
  scanf("%s", s);
  for (int i = 0; i < strlen(s); i++) {
    if (s[i] == '1')
      ones++;
    else if (s[i] == '2')
      twos++;
    else if (s[i] == '3')
      threes++;
    else if (s[i] == '+')
      pluses++;
  }
  for (int i = 1; i <= ones; i++) {
    printf("1");
    if (pluses--) printf("+");
  }
  for (int i = 1; i <= twos; i++) {
    printf("2");
    if (pluses--) printf("+");
  }
  for (int i = 1; i <= threes; i++) {
    printf("3");
    if (pluses--) printf("+");
  }
}
