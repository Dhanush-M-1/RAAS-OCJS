#include <bits/stdc++.h>
using namespace std;
int main() {
  char s1[100], s2[100];
  int i, n = 0, m = 0, k = 0, j, l;
  gets(s1);
  l = strlen(s1);
  for (i = 0; i < l; i++) {
    if (s1[i] == 49) {
      n++;
    }
    if (s1[i] == 50) {
      m++;
    }
    if (s1[i] == 51) {
      k++;
    }
  }
  bool first = true;
  for (j = 0; j < n; j++) {
    if (first == true) {
      printf("1");
      first = false;
    } else
      printf("+1");
  }
  for (j = 0; j < m; j++) {
    if (first == true) {
      printf("2");
      first = false;
    } else
      printf("+2");
  }
  for (j = 0; j < k; j++) {
    if (first == true) {
      printf("3");
      first = false;
    } else
      printf("+3");
  }
  printf("\n");
  return 0;
}
