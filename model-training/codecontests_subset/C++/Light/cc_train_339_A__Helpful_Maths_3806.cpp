#include <bits/stdc++.h>
int main() {
  char s[100], s1[50];
  scanf("%s", &s);
  int a = strlen(s), m = 0;
  for (int i = 0; i < a; i++) {
    if (i % 2 == 0) {
      s1[m] = s[i];
      m++;
    }
  }
  for (int i = 0; i < m; ++i) {
    for (int j = i + 1; j < m; ++j) {
      if (s1[i] > s1[j]) {
        a = s1[i];
        s1[i] = s1[j];
        s1[j] = a;
      }
    }
  }
  for (int i = 0; i < m; i++) {
    if (i != (m - 1)) {
      printf("%c+", s1[i]);
    } else
      printf("%c", s1[i]);
  }
}
