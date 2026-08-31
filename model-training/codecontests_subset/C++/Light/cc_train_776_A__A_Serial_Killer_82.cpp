#include <bits/stdc++.h>
using namespace std;
int main() {
  char str1[15], str2[15];
  while (~scanf("%s%s", str1, str2)) {
    int n, m, i, j, k, l;
    char str3[15], str4[15];
    scanf("%d", &n);
    printf("%s %s\n", str1, str2);
    for (i = 0; i < n; i++) {
      scanf("%s%s", str3, str4);
      if (strcmp(str1, str3) == 0)
        strcpy(str1, str4);
      else if (strcmp(str2, str3) == 0)
        strcpy(str2, str4);
      printf("%s %s\n", str1, str2);
    }
  }
  return 0;
}
