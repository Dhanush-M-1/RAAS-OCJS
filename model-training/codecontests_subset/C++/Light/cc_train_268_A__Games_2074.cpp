#include <bits/stdc++.h>
int main() {
  int teamsNum, i, j, x = 0;
  scanf("%i", &teamsNum);
  int colors[teamsNum][2];
  for (i = 0; i < teamsNum; i++)
    for (j = 0; j < 2; j++) scanf("%i", &colors[i][j]);
  for (i = 0; i < teamsNum; i++) {
    for (j = 0; j < teamsNum; j++)
      if (colors[i][0] == colors[j][1]) x++;
  }
  printf("%i", x);
  return 0;
}
