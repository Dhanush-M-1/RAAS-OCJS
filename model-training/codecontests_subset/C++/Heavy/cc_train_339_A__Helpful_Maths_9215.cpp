#include <bits/stdc++.h>
using namespace std;
int main() {
  int c[5];
  for (int i = 1; i < 4; i++) {
    c[i] = 0;
  }
  char l[105];
  scanf(" %s", l);
  for (int i = 0; i < (int)strlen(l); i++) {
    if (l[i] == '1') {
      c[1] = c[1] + 1;
    }
    if (l[i] == '2') {
      c[2] = c[2] + 1;
    }
    if (l[i] == '3') {
      c[3] = c[3] + 1;
    }
  }
  for (int i = 0; i < c[1] + c[2] + c[3]; i++) {
    if (i != 0) {
      printf("+");
    }
    if (i < c[1]) {
      printf("1");
    }
    if ((i < c[1] + c[2]) && (i >= c[1])) {
      printf("2");
    }
    if (i >= c[1] + c[2]) {
      printf("3");
    }
    if (i == c[1] + c[2] + c[3] - 1) {
      printf("\n");
    }
  }
  return 0;
}
