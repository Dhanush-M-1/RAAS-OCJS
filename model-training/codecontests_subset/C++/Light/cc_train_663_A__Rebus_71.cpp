#include <bits/stdc++.h>
using namespace std;
char x;
vector<bool> add;
vector<int> yy, zz;
int nn, n, y = 1, z;
bool o = 1;
int main() {
  scanf("%c", &x);
  scanf("%c", &x);
  while (1) {
    scanf("%c", &x);
    if (x == '=') break;
    if (x == '+') {
      add.push_back(1);
      y++;
    } else {
      add.push_back(0);
      z++;
    }
    scanf("%c", &x);
    scanf("%c", &x);
    scanf("%c", &x);
  }
  scanf("%d", &n);
  nn = n;
  if (y - z <= n) {
    n -= y - z;
    for (int a = 0; a < y; a++) {
      yy.push_back(1 + n / (y - a));
      n -= n / (y - a);
      if (yy.back() > nn) o = 0;
    }
    for (int a = 0; a < z; a++) zz.push_back(1);
  } else {
    n = y - z - n;
    for (int a = 0; a < z; a++) {
      zz.push_back(1 + n / (z - a));
      n -= n / (z - a);
      if (zz.back() > nn) o = 0;
    }
    for (int a = 0; a < y; a++) yy.push_back(1);
  }
  if (n) o = 0;
  if (!o) {
    printf("Impossible\n");
    return 0;
  }
  printf("Possible\n%d ", yy[--y]);
  for (int a = 0; a < add.size(); a++) {
    if (add[a])
      printf("+ %d ", yy[--y]);
    else
      printf("- %d ", zz[--z]);
  }
  printf("= %d\n", nn);
  return 0;
}
