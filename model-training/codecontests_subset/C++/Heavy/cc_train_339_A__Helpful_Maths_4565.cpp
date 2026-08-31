#include <bits/stdc++.h>
int main() {
#pragma comment(linker, "/STACK:67108864")
  char c[107];
  int i, d = 0, f = 0, g = 0, s;
  gets(c);
  s = strlen(c);
  for (i = 0; i < s; i++) {
    if (c[i] == '1') {
      d = d + 1;
    }
    if (c[i] == '2') {
      f = f + 1;
    }
    if (c[i] == '3') {
      g = g + 1;
    }
  }
  for (i = 0; i < d; i++) {
    if (i != d - 1) {
      printf("1+");
    } else {
      printf("1");
    }
  }
  if (f != 0 && d != 0 || d != 0 && g != 0) {
    printf("+");
  }
  for (i = 0; i < f; i++) {
    if (i != f - 1) {
      printf("2+");
    } else {
      printf("2");
    }
  }
  if (g != 0 && f != 0) {
    printf("+");
  }
  for (i = 0; i < g; i++) {
    if (i != g - 1) {
      printf("3+");
    } else {
      printf("3");
    }
  }
  return 0;
}
