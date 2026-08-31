#include <bits/stdc++.h>
using namespace std;
char s1[20], s2[20], n1[20], n2[20];
int n;
int main() {
  scanf("%s %s", s1 + 1, s2 + 1);
  printf("%s %s\n", s1 + 1, s2 + 1);
  scanf("%d", &n);
  while (n--) {
    scanf("%s %s", n1 + 1, n2 + 1);
    if (!strcmp(n1 + 1, s1 + 1)) {
      for (int i = 1; i <= 10; i++) s1[i] = n2[i];
    } else if (!strcmp(n1 + 1, s2 + 1)) {
      for (int i = 1; i <= 10; i++) s2[i] = n2[i];
    } else if (!strcmp(n2 + 1, s1 + 1)) {
      for (int i = 1; i <= 10; i++) s1[i] = n1[i];
    } else if (!strcmp(n2 + 1, s2 + 1)) {
      for (int i = 1; i <= 10; i++) s2[i] = n1[i];
    }
    printf("%s %s\n", s1 + 1, s2 + 1);
  }
  return 0;
}
