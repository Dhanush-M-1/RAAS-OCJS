#include <bits/stdc++.h>
int main(void) {
  int num_players, bet_A, bet_I, i;
  scanf("%d", &num_players);
  char str[num_players + 1];
  bet_A = bet_I = 0;
  scanf("%s", str);
  for (i = 0; i < num_players; i++) {
    if (str[i] == 'A')
      bet_A++;
    else if (str[i] == 'I')
      bet_I++;
  }
  if (bet_I >= 2)
    printf("0");
  else if (bet_I == 1)
    printf("1");
  else
    printf("%d", bet_A);
  return 0;
}
