#include <bits/stdc++.h>
using namespace std;
struct node {
  int e[4];
  int c;
} blocks[60][60];
struct node2 {
  int x;
  int y;
} current;
int main() {
  int i, n, m, k;
  char a[1000];
  scanf("%d%d", &n, &m);
  for (i = 0; i < 52; i++) {
    blocks[0][i].c = 0;
  }
  for (i = 1; i <= n; i++) {
    scanf("%s", a);
    k = strlen(a);
    blocks[i][0].c = 0;
    int j;
    for (j = 1; j <= k; j++) {
      blocks[i][j].c = a[j - 1] - '0';
    }
    blocks[i][j + 1].c = 0;
  }
  for (int j = 0; j < 52; j++) blocks[i + 1][j].c = 0;
  int cp = 0;
  int dp = 1;
  current.x = 1;
  current.y = 1;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= k; j++) {
      if (blocks[i - 1][j].c == 0)
        blocks[i][j].e[0] = 1;
      else
        blocks[i][j].e[0] = 0;
      if (blocks[i + 1][j].c == 0)
        blocks[i][j].e[2] = 1;
      else
        blocks[i][j].e[2] = 0;
      if (blocks[i][j - 1].c == 0)
        blocks[i][j].e[3] = 1;
      else
        blocks[i][j].e[3] = 0;
      if (blocks[i][j + 1].c == 0)
        blocks[i][j].e[1] = 1;
      else
        blocks[i][j].e[1] = 0;
    }
  while (m > 0) {
    if (dp == 0) {
      while (blocks[current.x][current.y].c ==
             blocks[current.x - 1][current.y].c)
        current.x--;
      if (cp == 0)
        while (blocks[current.x][current.y].c ==
               blocks[current.x][current.y - 1].c)
          current.y--;
      if (cp == 1)
        while (blocks[current.x][current.y].c ==
               blocks[current.x][current.y + 1].c)
          current.y++;
    }
    if (dp == 1) {
      while (blocks[current.x][current.y].c ==
             blocks[current.x][current.y + 1].c)
        current.y++;
      if (cp == 0)
        while (blocks[current.x][current.y].c ==
               blocks[current.x - 1][current.y].c)
          current.x--;
      if (cp == 1)
        while (blocks[current.x][current.y].c ==
               blocks[current.x + 1][current.y].c)
          current.x++;
    }
    if (dp == 2) {
      while (blocks[current.x][current.y].c ==
             blocks[current.x + 1][current.y].c)
        current.x++;
      if (cp == 0)
        while (blocks[current.x][current.y].c ==
               blocks[current.x][current.y + 1].c)
          current.y++;
      if (cp == 1)
        while (blocks[current.x][current.y].c ==
               blocks[current.x][current.y - 1].c)
          current.y--;
    }
    if (dp == 3) {
      while (blocks[current.x][current.y].c ==
             blocks[current.x][current.y - 1].c)
        current.y--;
      if (cp == 0)
        while (blocks[current.x][current.y].c ==
               blocks[current.x + 1][current.y].c)
          current.x++;
      if (cp == 1)
        while (blocks[current.x][current.y].c ==
               blocks[current.x - 1][current.y].c)
          current.x--;
    }
    if (blocks[current.x][current.y].e[dp] != 1) {
      if (dp == 0) current.x--;
      if (dp == 1) current.y++;
      if (dp == 2) current.x++;
      if (dp == 3) current.y--;
      m--;
    } else {
      if (cp == 1) dp = (dp + 1) % 4;
      cp = 1 - cp;
      m--;
    }
  }
  cout << blocks[current.x][current.y].c;
  return 0;
}
